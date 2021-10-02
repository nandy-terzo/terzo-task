package com.terzocloud.taskbank.rest;

import com.terzocloud.taskbank.dao.TransactionDateSummary;
import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.entity.Transaction;
import com.terzocloud.taskbank.service.AccountService;
import com.terzocloud.taskbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class AccountRestController {


    private AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public AccountRestController(AccountService accountService, TransactionService transactionService)
    {
        this.accountService=accountService;
        this.transactionService= transactionService;
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
    public void depositAccount(@PathVariable int accountId, @PathVariable int amount)
    {
         transactionService.Deposit(accountId, amount);
    }

    @PutMapping("/withdraw/{accountId}/{amount}")  //withdraw amt
    public void withdrawAccount(@PathVariable int accountId, @PathVariable int amount)
    {
//
        transactionService.Withdraw(accountId, amount);
    }

    @GetMapping("/transaction/summary/{transaction_date}")
    public TransactionDateSummary summaryTransaction(@PathVariable String transaction_date)
    {
        return transactionService.transactionSummary(transaction_date);
    }


}
