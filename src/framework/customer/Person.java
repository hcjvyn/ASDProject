package framework.customer;

import java.util.Date;

public class Person extends Customer implements IPerson {
	
	private Date birthDate;
	private ICompany company;
	
	public Person(String name, String street, String city, String state,
			String zip, Date birthDate) {
		super(name, street, city, state, zip, "P");
		this.birthDate = birthDate;
	}
	
	@Override
	public void setCompany(ICompany company) {
		this.company = company;
	}

	@Override
	public Date getBirthDate() {
		return birthDate;
	}
	
}
