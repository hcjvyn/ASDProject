package creditcard.account;

import framework.account.Account;
import framework.customer.ICustomer;

public class SilverCCAccount extends Account {

	private static final double INTEREST_RATE = 0.1;
	
	public SilverCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
	}

}
