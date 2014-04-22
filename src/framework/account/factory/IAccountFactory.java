package framework.account.factory;

import framework.account.IAccount;
import framework.customer.ICustomer;

public interface IAccountFactory {
	public IAccount createAccount(ICustomer iCustomer, String accountNumber);
}
