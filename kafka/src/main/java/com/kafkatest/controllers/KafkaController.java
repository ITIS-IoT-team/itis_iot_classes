package com.kafkatest.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello! \nTo send message to kafka go to /kafka/{topicName}/{message}";
    }

    @GetMapping("/kafka/{topicName}/{message}")
    public String sendMsgToKafkaHandler(@PathVariable("topicName") String topicName, @PathVariable("message") String message) {
        kafkaTemplate.send(topicName, message);
        return "Message sent to " + topicName;
    }

}
