package framework;

public abstract class ACustomer implements ICustomer{
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected IAccount iAccount;
	
	public abstract void addAccount();
}
