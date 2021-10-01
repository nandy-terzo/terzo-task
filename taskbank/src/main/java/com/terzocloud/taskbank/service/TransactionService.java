package com.terzocloud.taskbank.service;



import com.terzocloud.taskbank.entity.Transaction;

import java.time.LocalDate;
import java.util.List;


public interface TransactionService {
    public void Withdraw(int accountID, int amount);
    public void Deposit(int accountID, int amount);
    public List<Transaction> transactionSummary(LocalDate transactionDate);
}
