package framework.account.factory;

import framework.account.IAccount;
import framework.customer.ICustomer;

public interface IAccountFactory {
	IAccount createAccount(ICustomer iCustomer, String accountNumber, String accountType);
}
