package com.terzocloud.taskbank.service;

import com.terzocloud.taskbank.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAll();
    public Account getById(int id);
    public void save(Account account);
    public void deleteById(int id);
}
