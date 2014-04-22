package creditcard.account.factory;

import creditcard.account.SilverCCAccount;
import framework.account.IAccount;
import framework.account.factory.AAccountFactory;
import framework.customer.ICustomer;

public class SilverCCAccountFactory extends AAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber) {
		// TODO Auto-generated method stub
		return new SilverCCAccount(iCustomer, accountNumber);
	}
	
}
