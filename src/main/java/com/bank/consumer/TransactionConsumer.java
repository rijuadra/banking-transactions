package com.bank.consumer;

import com.bank.bo.TransactionRequest;
import com.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {
    @Autowired
    TransactionService transactionService;
    @KafkaListener(topics = "transactionDetails", groupId = "group_id",
    containerFactory = "transactionKafkaListenerContainerFactory")
    public void consume(TransactionRequest transactionRequest) {
        transactionService.saveTransaction(transactionRequest);
    }
}
