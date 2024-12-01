package org.Akhil.email_service.kafka;

import org.Akhil.base_domains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger logger= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
             logger.info(String.format("Order event received in stock service => %s",orderEvent.toString()));
             // send email to the customer
    }
}
