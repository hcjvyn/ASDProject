package framework.operation;

import framework.account.Account;
import framework.account.IAccount;
import framework.account.entry.IEntry;

public class AddOperation extends AOperation{
	
	private double amount;
	public static final String ENTRY_TYPE="D"; 

	/**
	 * Initialize all variables.
	 * @param account
	 */
	public AddOperation(double amt) {
		this.amount=amt;
	}

	
	/* (non-Javadoc)
	 * @see framework.operation.AOperation#compute(framework.account.IAccount)
	 */
	@Override
	public void compute(IAccount acct) {
		double newAmt = acct.getBalance()+amount;
		acct.setBalance(newAmt);
		addEntry(acct,amount, ENTRY_TYPE);
	}

}
