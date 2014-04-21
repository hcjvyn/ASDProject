package banking.customer;

import java.util.Date;

import framework.customer.ICustomer;

public interface IPerson extends ICustomer {

	public void setOrganization(IOrganization organization);
	public Date getBirthDate();

}
