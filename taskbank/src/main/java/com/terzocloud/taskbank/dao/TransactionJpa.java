package com.terzocloud.taskbank.dao;

import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class TransactionJpa implements TransactionDAO{

    private EntityManager eManager;

    @Autowired
    public TransactionJpa(EntityManager manager){eManager=manager;}


    @Override
    public void Withdraw(int accountID, int amount) {
        Query query = eManager.createQuery("update Transaction set transaction_amount=transaction_amount-"+amount+" where transaction_accout_id="+accountID);
        query.executeUpdate();
    }

    @Override
    public void Deposit(int accountID, int amount) {
        Query query = eManager.createQuery("update Transaction set transaction_amount=transaction_amount+"+ amount +" where transaction_accout_id="+accountID);
        query.executeUpdate();
    }

    @Override
    public List<Transaction> transactionSummary(LocalDate transactionDate) {
        Query thequery=eManager.createQuery("select from Transaction where transaction_date=transactionDate");
        List<Transaction> transactions=thequery.getResultList();
        return transactions;
    }
}
