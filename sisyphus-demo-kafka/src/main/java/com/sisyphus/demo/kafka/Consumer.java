package com.sisyphus.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Optional;

/**
 * @author zard
 * @date Created in 15/04/2022 03:58
 */
@Component
public class Consumer {

    @KafkaListener(topics="test", containerFactory="kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("---->" + record);
            System.out.println("---->" + message);
        }

    }
}