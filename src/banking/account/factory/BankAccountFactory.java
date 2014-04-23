package banking.account.factory;

import banking.account.CheckingAccount;
import banking.account.SavingsAccount;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public class BankAccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer iCustomer, String accountNumber, String accountType) {
		switch (accountType) {
		case SavingsAccount.ACCT_TYPE:
			return new SavingsAccount(iCustomer, accountNumber);
		case CheckingAccount.ACCT_TYPE:
			return new CheckingAccount(iCustomer, accountNumber);
		default:
			return null;
		}
	}
	
}
