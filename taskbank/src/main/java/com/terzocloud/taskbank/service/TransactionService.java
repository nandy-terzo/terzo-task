package com.terzocloud.taskbank.service;



import com.terzocloud.taskbank.dao.TransactionDateSummary;

import java.time.LocalDate;


public interface TransactionService {
    public void Withdraw(int accountID, int amount);
    public void Deposit(int accountID, int amount);
    public TransactionDateSummary transactionSummary(String transactionDate);
}
