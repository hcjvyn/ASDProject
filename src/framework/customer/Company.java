package framework.customer;

import java.util.ArrayList;

public class Company extends Customer implements ICompany {

	private ArrayList<IPerson> personList = new ArrayList<IPerson>();

	public Company(String name, String street, String city, String state,
			String zip) {
		super(name, street, city, state, zip, "C");
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
