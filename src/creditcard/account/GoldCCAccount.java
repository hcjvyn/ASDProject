package creditcard.account;

import framework.account.Account;
import framework.customer.ICustomer;

public class GoldCCAccount extends Account {

	private static final double INTEREST_RATE = 0.08;
	
	public GoldCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
	}

}
