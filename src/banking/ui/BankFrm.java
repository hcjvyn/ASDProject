package banking.ui;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import framework.customer.ICustomer;
import framework.transaction.AddAccountTransaction;
import framework.transaction.ITransaction;
import framework.transaction.TransactionManager;
import framework.ui.AddAccDialog;
import framework.ui.GUI;

/**
 * A basic JFC based application.
 */
public class BankFrm extends GUI {

	javax.swing.JButton AddCompanyAccountButton = new javax.swing.JButton();
	javax.swing.JButton AddinterestButton = new javax.swing.JButton();
    
	public BankFrm()
	{
		setTitle("Bank Application.");
		
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        
        String[] columnNames= { "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount" };
        setTableColumns(columnNames);
        
        AddAccountButton.setText("Add personal account");
        
        AddCompanyAccountButton.setText("Add company account");
        AddCompanyAccountButton.setActionCommand("jbutton");
		JPanel1.add(AddCompanyAccountButton);
		AddCompanyAccountButton.setBounds(240,20,192,33);
		
		AddinterestButton.setBounds(448,20,106,33);
		AddinterestButton.setText("Add interest");
		JPanel1.add(AddinterestButton);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		ExitButton.addActionListener(lSymAction);
		AddAccountButton.addActionListener(lSymAction);
		AddCompanyAccountButton.addActionListener(lSymAction);
		DepositButton.addActionListener(lSymAction);
		WithdrawButton.addActionListener(lSymAction);
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

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
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
			else if (object == AddAccountButton)
				AddAccountButton_actionPerformed(event);
			else if (object == AddCompanyAccountButton)
				AddCompanyAccountButton_actionPerformed(event);
			else if (object == DepositButton)
				DepositButton_actionPerformed(event);
			else if (object == WithdrawButton)
				WithdrawButton_actionPerformed(event);
			else if (object == AddinterestButton)
				AddinterestButton_actionPerformed(event);
			
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void ExitButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void AddAccountButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		AddAccDialog pac = new JDialog_AddPAcc();
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		
		ICustomer customer = pac.getCustomer();
		
		ITransaction transaction = new AddAccountTransaction(accountManager, customer);
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.submit(transaction);
		
		refreshTable();
    }

	void AddCompanyAccountButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		
		JDialog_AddCompAcc pac = new JDialog_AddCompAcc();
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		
		ICustomer customer = pac.getCustomer();
		
		ITransaction transaction = new AddAccountTransaction(accountManager, customer);
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.submit(transaction);

		refreshTable();
	}

	void DepositButton_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(accnr);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(dep.getAmount());
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 5);
		}
		
		
	}

	void WithdrawButton_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(accnr);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(wd.getAmount());
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount-deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 5);
		    if (newamount <0){
		       JOptionPane.showMessageDialog(WithdrawButton, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    }
		}
		
		
	}
	
	void AddinterestButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(AddinterestButton, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
	    
	}
	
	void refreshTable()
	{
		for(int i=0 ; i < model.getRowCount() ; i++)
			model.removeRow(i);
		
		for(int i=0 ; i < accountManager.getCustomerList().size() ; i++)
		{
			ICustomer customerTemp = accountManager.getCustomerList().get(i);
			rowdata[0] = customerTemp.getAccount().getAccountNum();
			rowdata[1] = customerTemp.getName();
			rowdata[2] = customerTemp.getCity();
			rowdata[3] = "Later";
			rowdata[4] = "Later";
			rowdata[5] = "0";
			model.addRow(rowdata);
		}
	}
}
