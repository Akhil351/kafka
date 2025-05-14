package com.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("testing-topic")
                .partitions(3)
                .replicas((short)1)
                .build();
    }
}


//🔹 Kafka Architecture Key Components
//Producer
//
//Sends data (messages) to Kafka topics.
//
//Consumer
//
//Reads data from Kafka topics.
//
//        Broker
//
//Kafka server that stores and serves data.
//
//A Kafka cluster has multiple brokers.
//
//Topic
//
//A named stream of data.
//
//Messages are published to topics.
//
//        Partition
//
//Each topic is split into partitions.
//
//Partitions enable parallelism and scalability.
//
//        Offset
//
//Unique ID for each message in a partition.
//
//Consumers use it to track read progress.
//
//        Consumer Group
//
//A group of consumers that share topic partitions.
//
//Each partition is consumed by only one member in the group.
//
//ZooKeeper (Legacy) / KRaft (New)
//
//Manages Kafka cluster metadata and leader election.
//
//Kafka is moving away from ZooKeeper to KRaft mode (Kafka Raft).
//
//Leader & Replica
//
//Each partition has one leader and zero or more replicas.
//
//Leaders handle all reads and writes; replicas provide fault tolerance.
//
//


//🔁 What is Serialization and Deserialization?
//Term	Meaning
//Serialization	Converting a Java (or other language) object into a byte array before sending it to Kafka.
//Deserialization	Converting the byte array received from Kafka back into an object.
//
//Kafka producers serialize messages before publishing, and consumers deserialize them when consuming.
