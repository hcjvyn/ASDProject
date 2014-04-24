package framework.account;

import java.util.ArrayList;
import java.util.List;

import framework.customer.ICustomer;
import framework.operation.IOperation;

public class AccountManager {
	
	private List<ICustomer> customerList = new ArrayList<ICustomer>();
	
	public void addCustomer(ICustomer iCustomer) {
		customerList.add(iCustomer);
	}
	
	public void removeCustomer(ICustomer iCustomer) {
		customerList.remove(iCustomer);
	}
	
	public void compute(IAccount account, IOperation operation) {
		operation.compute(account);
	}
	
	public void computeAll(IOperation operation) {
		for (ICustomer customer : customerList) {
			operation.compute(customer.getAccount());
		}
	}
	
	public List<ICustomer> getCustomerList() {
		return this.customerList;
	}

	public ICustomer findCustomerByAccountNumber(String accountNumber)
	{
		for(int i=0 ; i < customerList.size() ; i++)
	    {
			if(customerList.get(i).getAccount().getAccountNum().equals(accountNumber))
	    	{
	    		return customerList.get(i);
	    	}
	    }
		return null;
	}

}
