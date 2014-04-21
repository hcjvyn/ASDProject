package creditcard.account;

import framework.account.Account;
import framework.customer.ICustomer;

public class PlatinumCCAccount extends Account {

	private static final double INTEREST_RATE = 0.06;
	
	public PlatinumCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
	}

}
