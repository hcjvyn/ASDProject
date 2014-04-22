package framework.account.factory;

import framework.account.Account;
import framework.account.IAccount;
import framework.customer.ICustomer;


public class DefaultAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new Account(iCustomer, accountNumber);
	}

}
