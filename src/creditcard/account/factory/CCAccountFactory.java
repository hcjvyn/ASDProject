package creditcard.account.factory;

import creditcard.account.BronzeCCAccount;
import creditcard.account.GoldCCAccount;
import creditcard.account.SilverCCAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class CCAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber, String accountType) {
		switch (accountType) {
		case GoldCCAccount.ACCT_TYPE:
			return new GoldCCAccount(iCustomer, accountNumber);
		case SilverCCAccount.ACCT_TYPE:
			return new SilverCCAccount(iCustomer, accountNumber);
		case BronzeCCAccount.ACCT_TYPE:
			return new BronzeCCAccount(iCustomer, accountNumber);
		default:
			return null;
		}
	}

}
