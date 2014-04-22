package banking.account.factory;

import banking.account.CheckingAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class CheckingAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new CheckingAccount(iCustomer, accountNumber);
	}

}
