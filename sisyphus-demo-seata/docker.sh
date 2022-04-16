#mvn clean install -am -amd -Pdev -Dmaven.test.skip=true -Dsun.net.maxDatagramSockets=50
docker stop demo-seata
docker rm demo-seata
docker build -t demo-seata:0.0.1-SNAPSHOT .
#docker run -d --network sisyphus-master_default --name sisyphus-auth-authorize -p 8010:8080 sisyphus-auth-authorize
