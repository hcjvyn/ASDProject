package framework.account;

import java.util.ArrayList;

import framework.customer.ICustomer;
import framework.operation.IOperation;

public class AccountManager {
	
	private ArrayList<ICustomer> customerList;
	
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
	
	public ArrayList<ICustomer> getCustomerList() {
		return this.customerList;
	}
}
