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


            Transaction tempTransaction = new Transaction();
            tempTransaction.setTransactionId(0);
            tempTransaction.setAccountId(accountID);
            tempTransaction.setTransaction_amount(amount);
            tempTransaction.setTransaction_type("Withdraw");
            tempTransaction.setTransaction_date(LocalDate.now().toString());

            Transaction tempTransaction1 = eManager.merge(tempTransaction);
            tempTransaction.setTransactionId(tempTransaction1.getTransactionId());

            totalTransactions+=1;
            totalwithdrawnAmt+=amount;

            accountQuery.executeUpdate();

        }



    }

    @Override
    public void Deposit(int accountID, int amount) {


        Query accountQuery = eManager.createQuery("update Account set currentBalance=currentBalance+:amount where accountId=:ID");
        accountQuery.setParameter("amount",amount);
        accountQuery.setParameter("ID",accountID);

        Transaction tempTransaction = new Transaction();
        tempTransaction.setTransactionId(0);
        tempTransaction.setAccountId(accountID);
        tempTransaction.setTransaction_amount(amount);
        tempTransaction.setTransaction_type("Deposit");
        tempTransaction.setTransaction_date(LocalDate.now().toString());

        Transaction tempTransaction1 = eManager.merge(tempTransaction);
        tempTransaction.setTransactionId(tempTransaction1.getTransactionId());

        totalTransactions+=1;
        totalDepositedAmt+=amount;

        accountQuery.executeUpdate();

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
