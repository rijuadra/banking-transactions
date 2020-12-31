package com.bank.service;

import com.bank.bo.TransactionRequest;
import com.bank.document.AccountDetails;
import com.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void saveTransaction(TransactionRequest transactionRequest) {
        AccountDetails accountDetails = new AccountDetails();
        int accountId = (int) transactionRequest.getUser().getAccountId();
        accountDetails.setAccountId(accountId);
        double accountBalance = retriveAccountBalance(accountId);
        String typeOfTransaction = transactionRequest.getTypeOfTransaction();
        if(typeOfTransaction.equalsIgnoreCase("CREDIT"))
        {
            accountBalance=accountBalance+transactionRequest.getAmount();
        }
        if(typeOfTransaction.equalsIgnoreCase("DEBIT"))
        {
            accountBalance=accountBalance-transactionRequest.getAmount();
        }
        accountDetails.setAccountBalance(accountBalance);
        transactionRepository.save(accountDetails);
    }

    private double retriveAccountBalance(int accountId) {
       Optional<AccountDetails> accountDetails= transactionRepository.findById(accountId);
       if(accountDetails.isEmpty())
           return 0;
       return accountDetails.get().getAccountBalance();
    }
}
