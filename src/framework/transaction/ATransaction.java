package framework.transaction;

import framework.account.AccountManager;

public abstract class ATransaction implements ITransaction{
	protected AccountManager accountManager;
	
	public ATransaction(AccountManager acctMgr){
		this.accountManager=acctMgr;
	}
	
	public abstract void execute();
}
