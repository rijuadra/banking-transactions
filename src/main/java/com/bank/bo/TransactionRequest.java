package com.bank.bo;

public class TransactionRequest {
    private User user;
    private String typeOfTransaction;
    private double amount;

    public TransactionRequest() {
    }

    public TransactionRequest(User user, String typeOfTransaction, double amount) {
        this.user = user;
        this.typeOfTransaction = typeOfTransaction;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
