package com.terzocloud.taskbank.dao;

import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class TransactionJpa implements TransactionDAO{

    private EntityManager eManager;
    private int totalTransactions=0;
    private int totalwithdrawnAmt=0;
    private int totalDepositedAmt=0;

    @Autowired
    public TransactionJpa(EntityManager manager){eManager=manager;}


    @Override
    public void Withdraw(int accountID, int amount) {

        boolean isPossible=false;
        Account currentAccount = eManager.find(Account.class, accountID);
        if(currentAccount.getCurrentBalance()-amount>currentAccount.getCurrentBalance()) isPossible=true;

        if(isPossible){
            Query accountQuery = eManager.createQuery("update Account set currentBalance=currentBalance-:amount where accountId=:ID");
            accountQuery.setParameter("amount",amount);
            accountQuery.setParameter("ID",accountID);

            Query transactionQuery = eManager.createQuery("insert into Transaction(account_id, transaction_type, transaction_amount, transaction_date) values(:accID, :transType, :transAmount, :transDate )");
            transactionQuery.setParameter("account_id",accountID);
            transactionQuery.setParameter("transaction_type","Withdraw");
            transactionQuery.setParameter("transaction_amount",amount);
            transactionQuery.setParameter("transaction_date",LocalDate.now());

            totalTransactions+=1;
            totalwithdrawnAmt+=amount;

            accountQuery.executeUpdate();
            transactionQuery.executeUpdate();
        }



    }

    @Override
    public void Deposit(int accountID, int amount) {


        Query accountQuery = eManager.createQuery("update Account set currentBalance=currentBalance+:amount where accountId=:ID");
        accountQuery.setParameter("amount",amount);
        accountQuery.setParameter("ID",accountID);

        Query transactionQuery = eManager.createQuery("insert into Transaction(account_id, transaction_type, transaction_amount, transaction_date) values(:accID, :transType, :transAmount, :transDate )");
        transactionQuery.setParameter("account_id",accountID);
        transactionQuery.setParameter("transaction_type","Deposit");
        transactionQuery.setParameter("transaction_amount",amount);
        transactionQuery.setParameter("transaction_date",LocalDate.now());

        totalTransactions+=1;
        totalDepositedAmt+=amount;

        accountQuery.executeUpdate();
        transactionQuery.executeUpdate();
    }

    @Override
    public List<Transaction> transactionSummary(LocalDate transactionDate) {
        List<Transaction> transactions= (List<Transaction>) eManager.find(Transaction.class, transactionDate);
        return transactions;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public int getTotalwithdrawnAmt() {
        return totalwithdrawnAmt;
    }

    public int getTotalDepositedAmt() {
        return totalDepositedAmt;
    }
}
