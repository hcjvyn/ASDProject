package creditcard.account.factory;

import creditcard.account.GoldCCAccount;
import framework.account.IAccount;
import framework.account.factory.AAccountFactory;
import framework.customer.ICustomer;

public class GoldCCAccountFactory extends AAccountFactory{

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		// TODO Auto-generated method stub
		return new GoldCCAccount(iCustomer, accountNumber);
	}

}
