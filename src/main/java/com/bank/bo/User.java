package com.bank.bo;

public class User {
    private String userName;
    private String password;
    private long accountId;

    public User() {

    }

    public User(String userName, String password, long accountId) {
        this.userName = userName;
        this.password = password;
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
