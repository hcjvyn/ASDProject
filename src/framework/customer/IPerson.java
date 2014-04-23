package framework.customer;

import java.util.Date;

public interface IPerson extends ICustomer {

	public void setCompany(ICompany company);
	public Date getBirthDate();

}
