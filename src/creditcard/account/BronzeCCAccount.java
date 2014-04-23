package creditcard.account;

import framework.customer.ICustomer;

public class BronzeCCAccount extends ACCAccount {

	public static final String ACCT_TYPE = "B";
	
	private static final double INTEREST_RATE = 0.06;
	private static final double MINIMUM_PAYMENT_RATE = 0.14;
	
	public BronzeCCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
		this.interestRate = INTEREST_RATE;
		this.accountType = ACCT_TYPE;
		this.minimumPayment=MINIMUM_PAYMENT_RATE;
	}

}
