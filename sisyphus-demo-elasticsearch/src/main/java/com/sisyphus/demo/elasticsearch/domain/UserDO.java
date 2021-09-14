package com.sisyphus.demo.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zard
 * @date Created in 14/09/2021 23:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDO {

    public String name;
    public int age;
}
