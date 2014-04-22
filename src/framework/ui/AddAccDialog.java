package framework.ui;

import framework.customer.ICustomer;

public abstract class AddAccDialog extends javax.swing.JDialog {

	protected ICustomer customer;
	public ICustomer getCustomer() {
		return customer;
	}

}
