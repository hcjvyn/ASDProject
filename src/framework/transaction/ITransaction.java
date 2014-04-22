package framework.transaction;

import framework.account.IAccount;

public interface ITransaction {
	public void execute(IAccount acct);
}
