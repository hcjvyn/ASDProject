package banking.ui;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import banking.operation.AddInterestOperation;
import framework.customer.ICustomer;
import framework.operation.IOperation;
import framework.transaction.ComputeTransaction;
import framework.transaction.ITransaction;
import framework.transaction.TransactionManager;
import framework.ui.AAddAccDialog;
import framework.ui.GUI;

/**
 * A basic JFC based application.
 */
public class BankFrm extends GUI {

	javax.swing.JButton AddCompanyAccountButton = new javax.swing.JButton();
	javax.swing.JButton AddinterestButton = new javax.swing.JButton();
    
	protected void setTable()
	{
		String[] columnNames= { "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount" };
        setTableColumns(columnNames);
	}
	
	public BankFrm()
	{
		setTitle("Bank Application.");
		
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        
        AddAccountButton.setText("Add personal account");
        
        AddCompanyAccountButton.setText("Add company account");
        AddCompanyAccountButton.setActionCommand("jbutton");
		JPanel1.add(AddCompanyAccountButton);
		AddCompanyAccountButton.setBounds(240,20,192,33);
		
		AddinterestButton.setBounds(448,20,106,33);
		AddinterestButton.setText("Add interest");
		JPanel1.add(AddinterestButton);

		addWindowListener(this);
		SymAction lSymAction = new SymAction();
		ExitButton.addActionListener(lSymAction);
		AddCompanyAccountButton.addActionListener(lSymAction);
//		DepositButton.addActionListener(lSymAction);
//		WithdrawButton.addActionListener(lSymAction);
		AddinterestButton.addActionListener(lSymAction);
		
	}

	
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new BankFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	
	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == ExitButton)
				ExitButton_actionPerformed(event);
			else if (object == AddCompanyAccountButton)
				AddAccountButton_actionPerformed(event, new JDialog_AddCompAcc());
			else if (object == DepositButton || object == WithdrawButton)
				computeActionPerformed(event);
			else if (object == AddinterestButton)
				AddinterestButton_actionPerformed(event);
			
		}
	}

	 protected AAddAccDialog getDialog(){
		  return new JDialog_AddPAcc();
	 }
	 
	void AddinterestButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		IOperation addOperation = new AddInterestOperation();
		ITransaction transaction = new ComputeTransaction(accountManager, addOperation);
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.submit(transaction);
		JOptionPane.showMessageDialog(AddinterestButton, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		refreshTable();
	}
	
	protected String[] fillRowData(ICustomer customerTemp)
	{
		String[] rowdata2=new String[6];
		rowdata2[0] = customerTemp.getAccount().getAccountNum();
		rowdata2[1] = customerTemp.getName();
		rowdata2[2] = customerTemp.getCity();
		rowdata2[3] = customerTemp.getCustomerType();
		rowdata2[4] = customerTemp.getAccount().getAccountType();
		rowdata2[5] = Double.toString(customerTemp.getAccount().getBalance());
		return rowdata2;
	}
	
	
}
