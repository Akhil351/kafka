package com.kafka.consumer;

import com.kafka.consumer.model.RiderLocation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "testing-topic",groupId = "testing-group")
    public void riderLocationListener1(RiderLocation riderLocation){
        System.out.println("Received Location1: "+riderLocation.toString());
    }
    @KafkaListener(topics = "testing-topic",groupId = "testing-group")
    public void riderLocationListener2(RiderLocation riderLocation){
        System.out.println("Received Location2: "+riderLocation.toString());
    }
    @KafkaListener(topics = "testing-topic",groupId = "testing-group")
    public void riderLocationListener3(RiderLocation riderLocation){
        System.out.println("Received Location3: "+riderLocation.toString());
    }
}
