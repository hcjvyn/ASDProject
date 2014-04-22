package creditcard.ui;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import framework.customer.ICustomer;
import framework.transaction.AddAccountTransaction;
import framework.transaction.ITransaction;
import framework.transaction.TransactionManager;
import framework.ui.AAddAccDialog;
import framework.ui.GUI;

/**
 * A basic JFC based application.
 */
public class CardFrm extends GUI {
    /****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber;
    boolean newaccount;
    CardFrm thisframe;
    
	JButton GenerateMonthlyBillsButton = new JButton();
	
	public CardFrm()
	{
		thisframe=this;
		
		setTitle("Credit-card processing Application.");
		
		String[] columnNames= { "Name", "CC number", "Exp date", "Type", "Balance" }; 
        setTableColumns(columnNames);
        newaccount=false;
        		
		AddAccountButton.setText("Add Credit-card account");
		
		GenerateMonthlyBillsButton.setText("Generate Monthly bills");
		GenerateMonthlyBillsButton.setActionCommand("jbutton");
		JPanel1.add(GenerateMonthlyBillsButton);
		GenerateMonthlyBillsButton.setBounds(240,20,192,33);
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		ExitButton.addActionListener(lSymAction);
		AddAccountButton.addActionListener(lSymAction);
		GenerateMonthlyBillsButton.addActionListener(lSymAction);
		DepositButton.addActionListener(lSymAction);
		WithdrawButton.addActionListener(lSymAction);
		
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
			(new CardFrm()).setVisible(true);
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
			if (object == CardFrm.this)
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
			else if (object == GenerateMonthlyBillsButton)
				GenerateMonthlyBillsButton_actionPerformed(event);
			else if (object == DepositButton)
				DepositButton_actionPerformed(event);
			else if (object == WithdrawButton)
				WithdrawButton_actionPerformed(event);
			
		}
	}
    
   

	void AddAccountButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		AAddAccDialog ccac = new JDialog_AddCCAccount();
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		ICustomer customer = ccac.getCustomer();
		
		ITransaction transaction = new AddAccountTransaction(accountManager, customer);
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.submit(transaction);
		
		fillRowData(customer);
    }

	void GenerateMonthlyBillsButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill(this);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}

	/*void DepositButton_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(thisframe,name);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 4);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 4);
		}
		
		
	}*/

	void WithdrawButton_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(thisframe,name);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 4);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount-deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 4);
		    if (newamount <0){
		       JOptionPane.showMessageDialog(WithdrawButton, " "+name+" Your balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    }
		}
		
		
	}
	 
	public String[] fillRowData(ICustomer customerTemp)
	{
		String[] rowdata2=new String[6];
		rowdata2[0] = customerTemp.getName();
		rowdata2[1] = customerTemp.getAccount().getAccountNum();
		rowdata2[2] = customerTemp.getAccount().getExpDate().toString();
		rowdata2[3] = customerTemp.getAccount().getAccountType();
		rowdata2[4] = Double.toString(customerTemp.getAccount().getBalance());
		return rowdata;
	}
	
}
