package framework.account;

import framework.account.entry.IEntry;
import framework.customer.ICustomer;

public interface IAccount {
	
	public ICustomer getCustomer();
	public String getAccountNum();
	public double getInterestRate();
	public String getAccountType();
	public double getBalance();
	public void setBalance(double balance);
	public void addEntry(IEntry entry);

}
