package creditcard.account.factory;

import creditcard.account.SilverCCAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class SilverCCAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new SilverCCAccount(iCustomer, accountNumber);
	}
	
}
