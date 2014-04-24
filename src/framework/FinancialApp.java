/**
 * Purpose: 
 * Author: jhiolen
 * Date: Apr 23, 2014
 * Lab Number:
 */
package framework;

import java.util.List;

import framework.account.AccountManager;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;
import framework.transaction.AddAccountTransaction;
import framework.transaction.ITransaction;
import framework.transaction.TransactionManager;
import framework.ui.AFincoView;

public abstract class FinancialApp {
	protected TransactionManager transactionManager=null;
	protected AccountManager accountManager=null;
	protected IAccountFactory factory;
	protected AFincoView view;
	protected ICustomer customer;
	protected String acctNumber;
	protected String accountType;
	protected double amount;
	
	public FinancialApp(IAccountFactory factory ){
		transactionManager=new TransactionManager();
		accountManager=new AccountManager();
		this.factory = factory;
	}
	
	
	/**
	 * @param customer
	 * @param acctNumber
	 */
	public void addCustomer() {
		IAccountFactory iAccountFactory = factory;
		
		IAccount iAccount = iAccountFactory.createAccount(customer, acctNumber, accountType);
		if (iAccount!=null){
			customer.addAccount(iAccount);
			ITransaction transaction = new AddAccountTransaction(accountManager, customer);
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.submit(transaction);
		}
		
		// Reset to null
		customer = null;
		acctNumber = null;
		accountType = null;
	}
	
	/*public void compute(){
		ICustomer iCustomerTemp=accountManager.findCustomerByAccountNumber(acctNumber);
		
		String amt = getAmount();
		if (amt!=null){
			IOperation addOperation=null;
			if (event.getSource() == DepositButton)
				addOperation = new AddOperation(Double.parseDouble(amt));
			else if (event.getSource() == WithdrawButton)
				addOperation = new SubtractOperation(Double.parseDouble(amt));
			ITransaction transaction = new ComputeTransaction(accountManager, addOperation, iCustomerTemp.getAccount());
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.submit(transaction);
			refreshTable();
		}
		
	}*/
	
	/**
	 * 
	 */
	public List<ICustomer> getCustomerList() {
		return accountManager.getCustomerList();
	}
	
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	
	/**
	 * @param acctNumber
	 */
	public void setAccountNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	
	/**
	 * @param acctNumber
	 */
	public void setAccountType(String acctType) {
		this.accountType = acctType;
	}
	
	/**
	 * @param view the view to set
	 */
	public void setView(AFincoView view){
		this.view = view;
	}
	
	public AFincoView getView(){
		return view;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
