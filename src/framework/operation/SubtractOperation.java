package framework.operation;

import framework.account.IAccount;

public class SubtractOperation extends AOperation{

	private double amount;

	/**
	 * Initialize all variables.
	 * @param account
	 */
	public SubtractOperation(double amt) {
		this.amount=amt;
	}
	
	/* (non-Javadoc)
	 * @see framework.operation.AOperation#compute(framework.account.IAccount)
	 */
	@Override
	public void compute(IAccount acct) {
		double newAmt = acct.getBalance()+amount;
		acct.setBalance(newAmt);
		addEntry(acct,amount);
	}


	

}
