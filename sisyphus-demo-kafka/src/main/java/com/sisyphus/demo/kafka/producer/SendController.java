package com.sisyphus.demo.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zard
 * @date Created in 15/04/2022 03:58
 */
@RestController
@RequestMapping("/kafka")
public class SendController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/send")
    public String send() {
        producer.send();
        return "{\"code\":0}";
    }
}