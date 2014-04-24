package framework.ui.dialog;

import javax.swing.JDialog;

import framework.account.IAccount;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;

public abstract class AAddAccDialog extends JDialog {

	protected ICustomer customer;
	protected String acctNumber;
	protected String acctType;
	
	public AAddAccDialog() {
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}
	
	protected javax.swing.JLabel JLabelName = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabelStreet = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabelCity = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabelState = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabelZip = new javax.swing.JLabel();
	
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	
	protected javax.swing.JLabel JLabelAcnr = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	
	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}
	
	private void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		customer = createCustomer();
		acctNumber = JTextField_ACNR.getText();
		acctType = selectAccountType();
		/*String accountnr = JTextField_ACNR.getText();

		IAccountFactory iAccountFactory = selectFactory();
		IAccount iAccount = iAccountFactory.createAccount(customer, accountnr);
		customer.addAccount(iAccount);*/

		dispose();
	}
	
	public abstract String selectAccountType();
	
	/**
	 * @return the acctType
	 */
	public String getAcctType() {
		return acctType;
	}

	private void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) 
	{
    //make this frame invisible if Cancel button is clicked
        dispose();
	}
	
	protected abstract ICustomer createCustomer();
	
	
	public ICustomer getCustomer() {
		return customer;
	}
	
	public String getAcctNumber(){
		return acctNumber;
	}
	

}
