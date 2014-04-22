package banking.account.factory;

import banking.account.SavingsAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class SavingAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new SavingsAccount(iCustomer, accountNumber);
	}
	
}
