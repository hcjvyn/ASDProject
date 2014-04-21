package framework;

import java.util.ArrayList;

public class Account implements IAccount{
	private String accountNum;
	private ArrayList<Entry> entryList;

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addEntry(Entry entry) {
		// TODO Auto-generated method stub
		this.entryList.add(entry);
	}
	
}
