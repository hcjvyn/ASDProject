package creditcard.account.factory;

import java.util.Date;

import framework.account.Account;
import framework.customer.ICustomer;

public abstract class ACCAccount extends Account {

	protected Date expDate;
	
	public ACCAccount(ICustomer customer, String accountNum) {
		super(customer, accountNum);
//		this.expDate = expDate;
	}

	public Date getExpDate() {
		return expDate;
	}

}
