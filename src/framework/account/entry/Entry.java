package framework.account.entry;

import java.util.Date;

public class Entry implements IEntry {

	private double amount;
	private Date date;
	
	public Entry(double amount) {
		this.amount = amount;
		this.date = new Date();
	}

	@Override
	public double getAmount() {
		return amount;
	}

}
