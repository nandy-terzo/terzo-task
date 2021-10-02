package com.terzocloud.taskbank;

import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.service.AccountService;
import com.terzocloud.taskbank.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Query;

//JUNIT TESTING FOR THE ACCOUNT MANAGENMENT APPLICATION

@SpringBootTest
class TaskbankApplicationTests {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;


//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testSave(){
		Account account = new Account();
		account.setAccountHolderName("Ash");
		account.setCurrentBalance(500);

		accountService.save(account);
		Assertions.assertNotNull(accountService.getById(11));
	}





}
