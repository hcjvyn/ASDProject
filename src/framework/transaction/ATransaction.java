package framework.transaction;

import framework.account.AccountManager;

public abstract class ATransaction implements ITransaction{
	protected AccountManager accountManager;
	public abstract void execute();
}
