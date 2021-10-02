package com.terzocloud.taskbank;

import com.terzocloud.taskbank.dao.TransactionDateSummary;
import com.terzocloud.taskbank.entity.Account;
import com.terzocloud.taskbank.service.AccountService;
import com.terzocloud.taskbank.service.TransactionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
	@DisplayName("Tests that  the Ash accountis saved to the 10 preset accounts. Also tests that the getByID method of accountService runs correctly.")
	public void testAccountSave(){
		Account account = new Account();
		account.setAccountHolderName("Ash");
		account.setCurrentBalance(500);

		accountService.save(account);
		assertNotNull(accountService.getById(11));
	}

	@Test
	@DisplayName("Tests that the total accounts after adding the Ash account in the previous test to the 10 preset accounts is 11")
	public void TestAccountGetAll(){
		List <Account> accList = accountService.getAll();
		Assertions.assertEquals(11,accList.size());
	}

	@Test
	@DisplayName("Testing if DeleteByIdmethod of AccountService runs as expected")
	public void TestAccountDeleteById(){

		accountService.deleteById(11);
		assertNull(accountService.getById(11));

	}

	@Test
	@DisplayName("Testing transactionSummary in Transactions")
	public void TestTransactionSummary(){
		TransactionDateSummary summary = transactionService.transactionSummary("2021-01-10");
		assertEquals(3, summary.getTotalTransactions());
		assertEquals(100, summary.getTotalwithdrawnAmt());
		assertEquals(500, summary.getTotalDepositedAmt());
	}

	@Test
	@DisplayName("Testing the Deposit method in Transactions")
	public void TestTransactionDeposit(){

		transactionService.Deposit(1,800);

		TransactionDateSummary summary = transactionService.transactionSummary("2021-10-02");
		assertEquals(1, summary.getTotalTransactions());
		assertEquals(0, summary.getTotalwithdrawnAmt());
		assertEquals(800, summary.getTotalDepositedAmt());
	}

	@Test
	@DisplayName("Testing the Withdraw method in Transactions")
	public void TestTransactionWithdraw(){

		transactionService.Withdraw(1,800);

		TransactionDateSummary summary = transactionService.transactionSummary("2021-10-02");
		assertEquals(2, summary.getTotalTransactions());
		assertEquals(800, summary.getTotalwithdrawnAmt());
		assertEquals(800, summary.getTotalDepositedAmt());
	}




}
