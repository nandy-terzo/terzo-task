package com.terzocloud.taskbank.dao;

import com.terzocloud.taskbank.entity.Account;

import java.util.List;

public interface AccountDAO {
    public List<Account> findAll();
    public Account findById(int theId);
    public void save(Account account);
    public void deleteById(int theId);
}
