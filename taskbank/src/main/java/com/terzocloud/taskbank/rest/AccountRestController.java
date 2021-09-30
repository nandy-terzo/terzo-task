package com.terzocloud.taskbank.rest;

import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class AccountRestController {


    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService)
    {
        this.accountService=accountService;
    }

    @GetMapping("/account/all")  //all account info
    public List<Account> allAccounts()
    {
        return accountService.getAll();

    }

    @GetMapping("/account/{accountId}")  // account info id
    public Account getAccount(@PathVariable int accountId)
    {
        return accountService.getById(accountId);
       // return "requested account id"+accountId;
    }

    @PutMapping("/account/{accountId}")  // update account by id
    public Account updateAccount(@RequestBody Account account ,@PathVariable int accountId)
    {
        account.setAccountId(accountId);
        accountService.save(account);
        return account;
    }

    @DeleteMapping("/account/{accountId}") //delete account by id
    public Account deleteAccount(@PathVariable int accountId)
    {
        Account account=accountService.deleteById(accountId);
        return account;
    }

    @PostMapping("/account")//create an account
    public Account createAccount(@RequestBody Account account)
    {
        account.setAccountId(0);
        account.setCurrentBalance(1000);
        accountService.save(account);
        return account;
    }

    @PutMapping("/deposit/{accountId}/{amount}") //deposit amt
    public Account depositAccount(@PathVariable int accountId, @PathVariable int amount)
    {
        Account account=accountService.getById(accountId); //get user account
        int temp=account.getCurrentBalance()+amount;
        account.setCurrentBalance(temp);
        accountService.save(account);
        return account;
    }

    @PutMapping("/withdraw/{accountId}/{amount}")  //withdraw amt
    public Account withdrawAccount(@PathVariable int accountId, @PathVariable int amount)
    {
        Account account=accountService.getById(accountId); //get user account
        int temp=account.getCurrentBalance()-amount;
        account.setCurrentBalance(temp);
        accountService.save(account);
        return account;
    }



}
