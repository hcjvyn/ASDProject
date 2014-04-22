package framework.customer;

import framework.account.IAccount;

public interface ICustomer {
	
	public void addAccount(IAccount account);
	public IAccount getAccount();
	public String getName();
	public String getStreet();
	public String getCity();
	public String getState();
	public String getZip();

}
