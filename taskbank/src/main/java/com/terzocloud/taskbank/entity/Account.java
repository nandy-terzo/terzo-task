package com.terzocloud.taskbank.entity;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private int accountId;

    @Column(name="account_holder_name")
    private String accountHolderName;

    @Column(name="current_balance")
    private String currentBalance;

    public Account()
    {}

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Account(String accountHolderName, String currentBalance) {
        this.accountHolderName = accountHolderName;
        this.currentBalance = currentBalance;
    }



    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
}
