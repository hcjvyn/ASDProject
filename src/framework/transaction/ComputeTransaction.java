package framework.transaction;

import framework.account.AccountManager;
import framework.account.IAccount;
import framework.operation.IOperation;

public class ComputeTransaction extends ATransaction {
	
	private IOperation iOperation;
	private double amountToBeComputed;
	private IAccount account;
	
	/**
	 * Initialize all variables.
	 * @param acctMgr
	 */
	public ComputeTransaction(AccountManager acctMgr, IOperation iOperation, double amountToBeComputed, IAccount acct) {
		super(acctMgr);
		this.iOperation = iOperation;
		this.amountToBeComputed = amountToBeComputed;
		this.account = acct;
	}

	
	
	@Override
	public void execute() {
		this.iOperation.compute(account);
	}

}
