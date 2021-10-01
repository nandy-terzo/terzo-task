package com.terzocloud.taskbank.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private int transactionId;

    //    @OneToMany
    @Column(name="account_id")
    private int accountId;

    /*
      @Column(name="account_id")
      private int accountId;
  */
    @Column(name="transaction_type")
    private String transaction_type;

    //  @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_amount")
    private int transaction_amount;

    @Column(name="transaction_date")
    private String transaction_date;



    public Transaction()
    {
//        this.accountId=0;
//        this.transaction_type = "Type";
//        this.transaction_amount = 0;
//        this.transaction_date = "2021-1-01";
    }

    public Transaction(String transaction_type, int transaction_amount, String transaction_date, int accountId) {
        this.accountId=accountId;
        this.transaction_type = transaction_type;
        this.transaction_amount = transaction_amount;
        this.transaction_date = transaction_date;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }



}

