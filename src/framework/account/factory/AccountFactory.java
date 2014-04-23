package framework.account.factory;

import framework.account.Account;
import framework.account.IAccount;
import framework.customer.ICustomer;


public class AccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber, String accountType) {
		return new Account(iCustomer, accountNumber);
	}

}
