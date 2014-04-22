package creditcard.account;

import creditcard.account.factory.ACCAccount;
import framework.customer.ICustomer;

public class PlatinumCCAccount extends ACCAccount {

	private static final double INTEREST_RATE = 0.06;
	private static final String ACCT_TYPE = "S";
	
	public PlatinumCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType = ACCT_TYPE;
	}

}
