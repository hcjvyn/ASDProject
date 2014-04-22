package framework.operation;


import framework.account.IAccount;
import framework.account.entry.Entry;
import framework.account.entry.IEntry;

public abstract class AOperation implements IOperation {
	/*protected IAccount account;
	
	public AOperation(IAccount account){
		this.account = account;
	}*/
	
	public abstract void compute(IAccount acct);
	
	public void addEntry(IAccount acct, double amount, String entryType){
		IEntry entry = new Entry(amount, entryType);
		acct.addEntry(entry);
		
	}
}
