package framework.account;

import java.util.ArrayList;

import framework.account.entry.IEntry;
import framework.customer.ICustomer;

public class Account implements IAccount {
	
	private ICustomer customer;
	private String accountNum;
	private double balance;
	private ArrayList<IEntry> entryList = new ArrayList<IEntry>();

	protected double interestRate;
	
	public Account(ICustomer customer, String accountNum) {
		this.customer = customer;
		this.accountNum = accountNum;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void addEntry(IEntry entry) {
		this.entryList.add(entry);
	}

}
