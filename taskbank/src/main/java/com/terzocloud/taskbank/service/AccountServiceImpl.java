package com.terzocloud.taskbank.service;

import com.terzocloud.taskbank.dao.AccountDAO;
import com.terzocloud.taskbank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{
   @Autowired
   private AccountDAO accountDAO;
    @Override
    public List<Account> getAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account getById(int id) {
        return accountDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Account account) {
        accountDAO.save(account);
    }

    @Override
    @Transactional
    public Account deleteById(int id) {
        Account account=accountDAO.deleteById(id);
        return account;
    }

}
