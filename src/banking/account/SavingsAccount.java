package banking.account;

import framework.account.Account;
import framework.customer.ICustomer;

public class SavingsAccount extends Account {

	public static final String ACCT_TYPE = "S";
	private static final double INTEREST_RATE = 0.06;
	
	public SavingsAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType=ACCT_TYPE;
	}

}
