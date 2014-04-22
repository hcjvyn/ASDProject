package framework.transaction;

import framework.account.AccountManager;
import framework.customer.ICustomer;

public class AddAccountTransaction extends ATransaction {
	private ICustomer customer;

	/**
	 * Initialize all variables.
	 * @param acctMgr
	 */
	public AddAccountTransaction(AccountManager acctMgr, ICustomer customer) {
		super(acctMgr) ;
		this.customer = customer;
	}

	@Override
	public void execute() {
		accountManager.addCustomer(customer);
	}

	
}
