package banking.account;

import framework.account.Account;
import framework.customer.ICustomer;

public class CheckingAccount extends Account {

	public static final String ACCT_TYPE = "C";
	private static final double INTEREST_RATE = 0.04;
	
	public CheckingAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType = ACCT_TYPE;
	}

}
