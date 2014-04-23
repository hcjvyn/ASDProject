package creditcard.account;

import framework.customer.ICustomer;

public class PlatinumCCAccount extends ACCAccount {

	private static final double INTEREST_RATE = 0.06;
	private static final String ACCT_TYPE = "S";
	private static final double MINIMUM_PAYMENT_RATE = 0.14;
	
	public PlatinumCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType = ACCT_TYPE;
		this.minimumPayment=MINIMUM_PAYMENT_RATE;
	}

}
