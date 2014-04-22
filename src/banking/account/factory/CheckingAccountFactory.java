package banking.account.factory;

import banking.account.CheckingAccount;
import framework.account.IAccount;
import framework.account.factory.AAccountFactory;
import framework.customer.ICustomer;

public class CheckingAccountFactory extends AAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		// TODO Auto-generated method stub
		return new CheckingAccount(iCustomer, accountNumber);
	}

}
