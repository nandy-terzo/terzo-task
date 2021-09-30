package com.terzocloud.taskbank.service;

import com.terzocloud.taskbank.dao.TransactionDAO;
import com.terzocloud.taskbank.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImpl implements TransactionService{

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
    public List<Transaction> transactionSummary(LocalDate transactionDate) {
        return transactionDAO.transactionSummary(transactionDate);
    }
}
