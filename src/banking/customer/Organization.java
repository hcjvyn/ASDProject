package banking.customer;

import java.util.ArrayList;

import framework.customer.Customer;

public class Organization extends Customer implements IOrganization {

	private ArrayList<IPerson> personList = new ArrayList<IPerson>();

	public Organization(String name, String street, String city, String state,
			String zip) {
		super(name, street, city, state, zip);
	}

	@Override
	public void addPerson(IPerson person) {
		this.personList.add(person);
	}

	@Override
	public int numOfEmployees() {
		return this.personList.size();
	}
	
}
