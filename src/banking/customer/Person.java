package banking.customer;

import java.util.Date;

import framework.customer.Customer;

public class Person extends Customer implements IPerson {
	
	private Date birthDate;
	private IOrganization organization;
	
	public Person(String name, String street, String city, String state,
			String zip, Date birthDate) {
		super(name, street, city, state, zip);
		this.birthDate = birthDate;
	}
	
	@Override
	public void setOrganization(IOrganization organization) {
		this.organization = organization;
	}

	@Override
	public Date getBirthDate() {
		return birthDate;
	}
	
}
