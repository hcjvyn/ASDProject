package framework.transaction;

import framework.account.AccountManager;
import framework.account.IAccount;
import framework.operation.IOperation;

public class ComputeTransaction extends ATransaction {
	
	private IOperation iOperation;
	private IAccount account;
	
	/**
	 * Initialize all variables.
	 * @param acctMgr
	 */
	public ComputeTransaction(AccountManager acctMgr, IOperation iOperation, IAccount acct) {
		super(acctMgr);
		this.iOperation = iOperation;
		this.account = acct;
	}
	
	public ComputeTransaction(AccountManager acctMgr, IOperation iOperation) {
		super(acctMgr);
		this.iOperation = iOperation;
	}
	
	
	@Override
	public void execute() {
		if (account!=null){
			this.accountManager.compute(account, iOperation);
		}else{
			this.accountManager.computeAll(iOperation);
		}
		
	}

}
