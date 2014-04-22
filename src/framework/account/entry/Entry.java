package framework.account.entry;

import java.util.Date;

public class Entry implements IEntry {

	private double amount;
	private Date date;
	private String entryType;
	
	public Entry(double amount, String entryType) {
		this.amount = amount;
		this.date = new Date();
		this.entryType=entryType;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}

	@Override
	public String getEntryType() {
		// TODO Auto-generated method stub
		return this.entryType;
	}

}
