package com.kafkatest.consumers;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaTopicsListener {

    @KafkaListener(topics = "topic1", id = "simple-consumer-1")
    public void topic1Consumer(String message) {
        log.info("Received a message in topic1: <---" + message);
    }

    @KafkaListener(topics = "topic3", id = "simple-consumer-3")
    public void topic3Consumer(String message) {
        log.info("Received a message in topic3: <--- " + message);
    }
}
