package framework.customer;

import framework.account.IAccount;

public class Customer implements ICustomer {
	
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected IAccount account;
	
	public Customer(String name, String street, String city, String state,
			String zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Override
	public void addAccount(IAccount account) {
		this.account = account;
	}

	@Override
	public IAccount getAccount() {
		return account;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String getZip() {
		return zip;
	}

}
