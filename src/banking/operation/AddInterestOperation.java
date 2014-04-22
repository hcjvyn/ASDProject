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

	
	/* (non-Javadoc)
	 * @see framework.operation.AOperation#compute(framework.account.IAccount)
	 */
	@Override
	public void compute(IAccount acct) {
		double newBal = acct.getBalance()*acct.getInterestRate();
		acct.setBalance(newBal);
	}

}
