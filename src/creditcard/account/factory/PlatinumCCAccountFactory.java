package creditcard.account.factory;

import creditcard.account.PlatinumCCAccount;
import framework.account.IAccount;
import framework.account.factory.AAccountFactory;
import framework.customer.ICustomer;

public class PlatinumCCAccountFactory extends AAccountFactory{

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		// TODO Auto-generated method stub
		return new PlatinumCCAccount(iCustomer, accountNumber);
	}

}
