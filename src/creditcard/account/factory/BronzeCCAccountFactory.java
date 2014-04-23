package creditcard.account.factory;

import creditcard.account.BronzeCCAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class BronzeCCAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		return new BronzeCCAccount(iCustomer, accountNumber);
	}

}
