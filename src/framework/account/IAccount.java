package framework.account;

import framework.account.entry.IEntry;

public interface IAccount {
	
	public double getBalance();
	public void setBalance(double balance);
	public void addEntry(IEntry entry);

}
