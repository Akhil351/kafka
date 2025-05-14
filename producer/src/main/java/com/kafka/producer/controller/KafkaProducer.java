package com.kafka.producer.controller;

import com.kafka.producer.model.RiderLocation;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class KafkaProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(){
        RiderLocation location=new RiderLocation(UUID.randomUUID().toString(),28.61,77.23);
        kafkaTemplate.send("testing-topic",location.getRiderId(),location);
        return "Message sent:"+location.getRiderId();
    }
}
