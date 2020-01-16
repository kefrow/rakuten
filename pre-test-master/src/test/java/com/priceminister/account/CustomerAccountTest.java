package com.priceminister.account;


import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.customerAccount = new CustomerAccount();
        this.rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
    	assertEquals(this.customerAccount.getBalance(), BigDecimal.ZERO);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	BigDecimal addedAmount = new BigDecimal(5);
		this.customerAccount.add(addedAmount);
		assertEquals(this.customerAccount.getBalance(), addedAmount);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     * @throws IllegalBalanceException The balance is illegal
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
    	this.customerAccount.withdrawAndReportBalance(new BigDecimal(10), this.rule);
        fail("This test must throw the exception.");
    }
    
    // Also implement missing unit tests for the above functionalities.
    
    @Test
    public void testWithdrawAndReportBalanceLlegalBalance() throws IllegalBalanceException {
    	BigDecimal addedAmount = new BigDecimal(50);
		this.customerAccount.add(addedAmount);
    	BigDecimal withdrawnAmount = new BigDecimal(10);
		this.customerAccount.withdrawAndReportBalance(withdrawnAmount, this.rule);
        assertEquals(this.customerAccount.getBalance(), addedAmount.subtract(withdrawnAmount));
    }

}
