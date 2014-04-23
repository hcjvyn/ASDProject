package framework.customer;


public interface ICompany extends ICustomer {

	public void addPerson(IPerson person);
	public int numOfEmployees();

}
