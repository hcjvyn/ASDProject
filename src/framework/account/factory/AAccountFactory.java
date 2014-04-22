package framework.account.factory;

import framework.account.IAccount;
import framework.customer.ICustomer;


public abstract class AAccountFactory implements IAccountFactory{

	@Override
	public abstract IAccount createAccount(ICustomer iCustomer, String accountNumber);
}
