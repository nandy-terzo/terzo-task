package com.terzocloud.taskbank.dao;

import com.terzocloud.taskbank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountJpaImpl implements AccountDAO{

    private EntityManager entityManager;
    @Autowired
    public AccountJpaImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Account> findAll() {
        Query thequery=entityManager.createQuery("from Account");
        List<Account> accounts=thequery.getResultList();
        return accounts;
    }

    @Override
    public Account findById(int theId) {
       Account tempAccount=entityManager.find(Account.class,theId);
        return tempAccount;
    }

    @Override
    public void save(Account account) {
        Account account1=entityManager.merge(account);
        account.setAccountId(account1.getAccountId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery=entityManager.createQuery("delete from Account where id=:accountId");
        theQuery.setParameter("accountId",theId);
        theQuery.executeUpdate();
    }
}
