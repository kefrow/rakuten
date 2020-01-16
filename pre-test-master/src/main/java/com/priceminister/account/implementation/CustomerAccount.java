package com.priceminister.account.implementation;

import java.math.BigDecimal;

import com.priceminister.account.*;


public class CustomerAccount implements Account {
	
	private BigDecimal balance = BigDecimal.ZERO;

    public void add(BigDecimal addedAmount) {
        this.balance = this.balance.add(addedAmount);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BigDecimal withdrawAndReportBalance(BigDecimal withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	
    	BigDecimal balanceSubtractWithdrawn = this.balance.subtract(withdrawnAmount);
    	if(!rule.withdrawPermitted(balanceSubtractWithdrawn)) {
    		throw new IllegalBalanceException(balanceSubtractWithdrawn);
    	}
    	
    	this.balance = balanceSubtractWithdrawn;
        return this.balance;
    }

}
