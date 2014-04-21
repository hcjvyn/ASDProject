package framework.account;

import framework.account.entry.Entry;

public interface IAccount {
	public double getBalance();
	public void addEntry(Entry entry);
}
