/**
 * Purpose: 
 * Author: jhiolen
 * Date: Apr 23, 2014
 * Lab Number:
 */
package framework;

import java.util.List;

import banking.operation.AddInterestOperation;
import framework.account.AccountManager;
import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;
import framework.operation.AddOperation;
import framework.operation.IOperation;
import framework.operation.SubtractOperation;
import framework.transaction.AddAccountTransaction;
import framework.transaction.ComputeTransaction;
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
	protected String amount;
	
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
	
	public void compute(String acctNumber, String entryType){
		ICustomer iCustomerTemp=accountManager.findCustomerByAccountNumber(acctNumber);

		String amt = this.amount;
		if (amt!=null){
			IOperation operation=getOperation(amt, entryType);
			ITransaction transaction = new ComputeTransaction(accountManager, operation, iCustomerTemp.getAccount());
			this.transactionManager.submit(transaction);
		}
	}
	
	public IOperation getOperation(String amt, String entryType)
	{
		IOperation operation=null;
		if(AddOperation.ENTRY_TYPE.equals(entryType))
			operation = new AddOperation(Double.parseDouble(amt));
		else if(SubtractOperation.ENTRY_TYPE.equals(entryType))
			operation = new SubtractOperation(Double.parseDouble(amt));
		return operation;
	}
	
	public void computeAll()
	{
		IOperation addOperation = getOperation("",null);
		ITransaction transaction = new ComputeTransaction(accountManager, addOperation);
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.submit(transaction);
	}
	
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
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
