package framework;

import java.util.ArrayList;

public class AccountManager {
	protected ArrayList<ICustomer> iCustomerList;
	
	public void addCustomer(ICustomer iCustomer)
	{
		iCustomerList.add(iCustomer);
	}
	public void removeCustomer(ICustomer iCustomer)
	{
		iCustomerList.remove(iCustomer);
	}
	public void compute()
	{
		
	}
	public void computeAll()
	{
		
	}
	public ArrayList<ICustomer> getCustomerList()
	{
		return this.iCustomerList;
	}
}
