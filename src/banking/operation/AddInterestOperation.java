/**
 * Purpose: 
 * Author: jhiolen
 * Date: Apr 21, 2014
 * Lab Number:
 */
package banking.operation;

import framework.account.IAccount;
import framework.operation.AOperation;

public class AddInterestOperation extends AOperation {

	public static final String ENTRY_TYPE = "I";
	
	/* (non-Javadoc)
	 * @see framework.operation.AOperation#compute(framework.account.IAccount)
	 */
	@Override
	public void compute(IAccount acct) {
		double amount = acct.getBalance()*acct.getInterestRate();
		double newBal = acct.getBalance()+amount;
		acct.setBalance(newBal);
		addEntry(acct,amount, ENTRY_TYPE);
	}

}
