package banking.account;

import framework.account.Account;
import framework.customer.ICustomer;

public class SavingsAccount extends Account {

	private static final double INTEREST_RATE = 0.06;
	
	public SavingsAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType="S";
	}

}
