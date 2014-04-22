package framework.transaction;

import framework.account.AccountManager;
import framework.account.IAccount;
import framework.operation.IOperation;

public class ComputeTransaction extends ATransaction {
	
	private IOperation iOperation;
	private double amountToBeComputed;
	
	/**
	 * Initialize all variables.
	 * @param acctMgr
	 */
	public ComputeTransaction(AccountManager acctMgr, IOperation iOperation, double amountToBeComputed) {
		super(acctMgr);
		this.iOperation = iOperation;
		this.amountToBeComputed = amountToBeComputed;
	}

	
	
	@Override
	public void execute(IAccount acct) {
		this.iOperation.compute(acct);
	}

}
