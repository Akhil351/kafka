package org.Akhil.order_service.kafka;

import org.Akhil.base_domains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private static final Logger logger= LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private NewTopic newTopic;
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent orderEvent){
        logger.info(String.format("Order event=> %s",orderEvent.toString()));
            // create Message
        Message<OrderEvent>message =MessageBuilder.withPayload(orderEvent).setHeader(KafkaHeaders.TOPIC,newTopic.name()).build();
        kafkaTemplate.send(message);
    }

}
