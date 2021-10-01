package com.terzocloud.taskbank.dao;

import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionJpaImpl implements TransactionDAO{

    private EntityManager eManager;
    private int totalTransactions=0;
    private int totalwithdrawnAmt=0;
    private int totalDepositedAmt=0;

    @Autowired
    public TransactionJpaImpl(EntityManager manager){eManager=manager;}


    @Override
    @Transactional
    public void Withdraw(int accountID, int amount) {

        //CHECKING IF ACCOUNT BALANCE IS GREATER THAN OR EQUAL TO WITHDRAWAL AMOUNT.
        boolean isPossible=false;
        Account currentAccount = eManager.find(Account.class, accountID);
        if(currentAccount.getCurrentBalance()>=amount) isPossible=true;

        if(isPossible){
            //UPDATING ACCOUNT TABLE WITH BALANCE AFTER WITHDRAWAL
            Query accountQuery = eManager.createQuery("update Account set currentBalance=currentBalance-:amount where accountId=:ID");
            accountQuery.setParameter("amount",amount);
            accountQuery.setParameter("ID",accountID);
            accountQuery.executeUpdate();

            //ADDING TRANSACTION TO THE TABLE
            Transaction tempTransaction = new Transaction();
            tempTransaction.setTransactionId(0);
            tempTransaction.setAccountId(accountID);
            tempTransaction.setTransaction_amount(amount);
            tempTransaction.setTransaction_type("Withdraw");
            tempTransaction.setTransaction_date(LocalDate.now().toString());

            eManager.merge(tempTransaction);

            totalTransactions+=1;
            totalwithdrawnAmt+=amount;



        }



    }

    @Override
    @Transactional
    public void Deposit(int accountID, int amount) {

        //UPDATING ACCOUNT TABLE WITH BALANCE AFTER DEPOSIT
        Query accountQuery = eManager.createQuery("update Account set currentBalance=currentBalance+:amount where accountId=:ID");
        accountQuery.setParameter("amount",amount);
        accountQuery.setParameter("ID",accountID);

        //ADDING TRANSACTION TO THE TABLE
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
    @Transactional
    public TransactionDateSummary transactionSummary(String transactionDate) {
        Query summaryQuery = eManager.createQuery(" from Transaction where transaction_date like :date");
        summaryQuery.setParameter("date", transactionDate);

        List<Transaction> transactions= summaryQuery.getResultList();
        int transactionCount = transactions.size();
        int totalWithdraw=0;
        int totalDeposit = 0;
        for (int i=0; i<transactions.size(); i++) {
            Transaction bufferTransaction= transactions.get(i);
            if(bufferTransaction.getTransaction_type().equals("Deposit"))
                totalDeposit+=bufferTransaction.getTransaction_amount();
            if(bufferTransaction.getTransaction_type().equals("Withdraw"))
                totalWithdraw+=bufferTransaction.getTransaction_amount();
        }
        System.out.println(transactions + "\t\t\t\t\t\tIS QUERY CORRECT");
        TransactionDateSummary returnSummary = new TransactionDateSummary(transactionCount, totalWithdraw, totalDeposit);
        return returnSummary;

    }


}


