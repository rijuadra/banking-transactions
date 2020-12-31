package com.bank.repository;

import com.bank.bo.TransactionRequest;
import com.bank.document.AccountDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<AccountDetails,Integer> {

}
