package com.terzocloud.taskbank.service;


import com.terzocloud.taskbank.dao.TransactionDateSummary;
import com.terzocloud.taskbank.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionDAO transactionDAO;

    @Override
    public void Withdraw(int accountID, int amount) {
        transactionDAO.Withdraw(accountID, amount);
    }

    @Override
    public void Deposit(int accountID, int amount) {
        transactionDAO.Deposit(accountID, amount);
    }

    @Override
    public TransactionDateSummary transactionSummary(String transactionDate) {
        return transactionDAO.transactionSummary(transactionDate);
    }
}
