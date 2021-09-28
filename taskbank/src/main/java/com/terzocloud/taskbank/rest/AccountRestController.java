package com.terzocloud.taskbank.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class AccountRestController {
    @GetMapping("/account/all")
    public String allAccounts()
    {
        return "all account";
    }

    @GetMapping("/account/{accountId}")
    public String getAccount(@PathVariable int accountId)
    {
        return "requested account id"+accountId;
    }

    @PutMapping("/account/{accountId}")
    public String updateAccount(@PathVariable int accountId)
    {
        return "update account id"+accountId;
    }

    @DeleteMapping("/account/{accountId}")
    public String deleteAccount(@PathVariable int accountId)
    {
        return "delete account id"+accountId;
    }



}
