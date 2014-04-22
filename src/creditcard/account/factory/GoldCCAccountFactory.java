package creditcard.account.factory;

import creditcard.account.GoldCCAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class GoldCCAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new GoldCCAccount(iCustomer, accountNumber);
	}

}
