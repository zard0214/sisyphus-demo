package com.sisyphus.demo.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.sisyphus.demo.elasticsearch.domain.UserDO;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SisyphusDemoElasticsearchApplicationTests {

    //object-orient
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void creatIndex() throws IOException {
        //1. to create index request
        CreateIndexRequest request = new CreateIndexRequest("test_index");
        //2. excute request
        CreateIndexResponse response = restHighLevelClient.indices()
                .create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    public void exitIndex() throws IOException {
        //1. to get index request
        GetIndexRequest request = new GetIndexRequest("test_index");
        //2. excute request
        boolean exists = restHighLevelClient.indices()
                .exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void deleteIndex() throws IOException {
        //1. to delete index request
        DeleteIndexRequest request = new DeleteIndexRequest("test_index");
        //2. excute request
        AcknowledgedResponse response = restHighLevelClient.indices()
                .delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    public void addDocument() throws IOException {
        //1. create object
        UserDO user = new UserDO("zard",3);

        IndexRequest request = new IndexRequest("zard_index");
        request.id("1");
        request.timeout(TimeValue.timeValueMillis(1));

        IndexRequest indexRequest = request.source(JSON.toJSON(user), XContentType.JSON);
        //2. excute request
        IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    @Test
    public void getDocument() throws IOException {
        //1. create object
        UserDO user = new UserDO("zard",3);

        IndexRequest request = new IndexRequest("zard_index");
        request.id("1");
        request.timeout(TimeValue.timeValueMillis(1));

        IndexRequest indexRequest = request.source(JSON.toJSON(user), XContentType.JSON);
        //2. excute request
        IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    @Test
    public void testIsExits() throws IOException {
        GetRequest request = new GetRequest("zard_index", "1");
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");

        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("zard_index", "1");

        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        System.out.println(response);
    }

    @Test
    public void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("zard_index", "1");
        request.id("1");
        request.timeout(TimeValue.timeValueMillis(1));

        UserDO user = new UserDO("zard",7);
        request.doc(JSON.toJSONString(user),XContentType.JSON);

        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    public void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("zard_index", "1");
        request.id("1");
        request.timeout(TimeValue.timeValueMillis(1));

        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    @Test
    public void testBulkRequest() throws IOException {
        BulkRequest request = new BulkRequest("zard_index");
        request.timeout(TimeValue.timeValueMillis(1));

        ArrayList<UserDO> list = new ArrayList<>();
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));
        list.add(new UserDO("zard",7));

        for (int i = 0 ; i < list.size() ; i ++
             ) {
            request.add(new IndexRequest("zard_index")
                    .id("" + (i + 1))
                    .source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }

        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.hasFailures());
    }


    @Test
    public void testSearchDocument() throws IOException {
        SearchRequest request = new SearchRequest("zard_index", "1");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.highlighter();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "1");
//        TermQueryBuilder termQueryBuilder = QueryBuilders.matchAllQuery();

        builder.query(termQueryBuilder);
//        builder.from();
//        builder.size();
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
    }
}
