package framework.transaction;

import framework.account.AccountManager;
import framework.account.IAccount;

public abstract class ATransaction implements ITransaction{
	protected AccountManager accountManager;
	
	public ATransaction(AccountManager acctMgr){
		this.accountManager = acctMgr;
	}
	
	public abstract void execute(IAccount acct);
}
