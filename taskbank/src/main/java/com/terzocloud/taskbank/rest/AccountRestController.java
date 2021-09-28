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
    public String getAccount(@PathVariable int accountId)
    {
        return "requested account id"+accountId;
    }

    @PutMapping("/account/{accountId}")  // update account by id
    public String updateAccount(@PathVariable int accountId)
    {
        return "update account id"+accountId;
    }

    @DeleteMapping("/account/{accountId}") //delete account by id
    public String deleteAccount(@PathVariable int accountId)
    {
        return "delete account id"+accountId;
    }

    @PostMapping("/account")//create an account
    public String createAccount()
    {
        return "Create account";
    }

    @PutMapping("/deposit/{accountId}/{amount}") //deposit amt
    public String depositAccount(@PathVariable int accountId, @PathVariable int amount)
    {
        return "deposit amount:"+amount+", id:"+accountId;
    }

    @PutMapping("/withdraw/{accountId}/{amount}")  //withdraw amt
    public String withdrawAccount(@PathVariable int accountId, @PathVariable int amount)
    {
        return "withdraw amount:"+amount+", id:"+accountId;
    }



}
