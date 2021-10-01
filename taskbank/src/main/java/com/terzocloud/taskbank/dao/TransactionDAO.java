package com.terzocloud.taskbank.dao;



import java.time.LocalDate;


public interface TransactionDAO {
    public void Withdraw(int accountID, int amount);
    public void Deposit(int accountID, int amount);
    public TransactionDateSummary transactionSummary(String transactionDate);
}
