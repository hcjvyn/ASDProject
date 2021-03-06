package creditcard.account;

import framework.customer.ICustomer;

public class SilverCCAccount extends ACCAccount {

	public static final String ACCT_TYPE = "S";
	
	private static final double INTEREST_RATE = 0.1;
	private static final double MINIMUM_PAYMENT_RATE = 0.12;
	
	public SilverCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType = ACCT_TYPE;
		this.minimumPayment=MINIMUM_PAYMENT_RATE;
	}

}
