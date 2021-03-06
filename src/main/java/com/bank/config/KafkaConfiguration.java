package com.bank.config;

import com.bank.bo.TransactionRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String, TransactionRequest> transactionConsumerFactory(){
        Map<String, Object> config=new HashMap<>();
        JsonDeserializer<TransactionRequest> deserializer = new JsonDeserializer<>(TransactionRequest.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.24.176.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,TransactionRequest> transactionKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,TransactionRequest> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(transactionConsumerFactory());
        return factory;
    }
   }
