package creditcard.account.factory;

import creditcard.account.PlatinumCCAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class PlatinumCCAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new PlatinumCCAccount(iCustomer, accountNumber);
	}

}
