package banking.customer;

import framework.customer.ICustomer;

public interface IOrganization extends ICustomer {

	public void addPerson(IPerson person);
	public int numOfEmployees();

}