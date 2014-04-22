package framework.ui;

import framework.account.factory.AccountFactory;
import framework.account.factory.IAccountFactory;
import framework.customer.Customer;
import framework.customer.ICustomer;

public class AddAccDialog extends AAddAccDialog {

	protected ICustomer createCustomer() {
		String clientName = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		String zip = JTextField_ZIP.getText();
		String state = JTextField_ST.getText();
		
		return new Customer(
				clientName,
				street,
				city,
				state,
				zip);
	}
	
	protected IAccountFactory selectFactory() {
		return new AccountFactory();
	}

}
