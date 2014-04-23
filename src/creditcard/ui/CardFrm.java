package creditcard.ui;

import javax.swing.JButton;
import javax.swing.UIManager;

import framework.customer.ICustomer;
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
		
        newaccount=false;
        		
		AddAccountButton.setText("Add Credit-card account");
        
		GenerateMonthlyBillsButton.setText("Generate Monthly bills");
		GenerateMonthlyBillsButton.setActionCommand("jbutton");
		JPanel1.add(GenerateMonthlyBillsButton);
		GenerateMonthlyBillsButton.setBounds(240,20,192,33);
		
		this.addWindowListener(this);
//		SymWindow aSymWindow = new SymWindow();
//		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		ExitButton.addActionListener(lSymAction);
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

	/*class SymWindow extends java.awt.event.WindowAdapter
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
	}*/

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == ExitButton)
				ExitButton_actionPerformed(event);
			else if (object == GenerateMonthlyBillsButton)
				GenerateMonthlyBillsButton_actionPerformed(event);
			else if (object == DepositButton || object == WithdrawButton)
				computeActionPerformed(event);
			
		}
	}
	
	 protected AAddAccDialog getDialog(){
		  return new JDialog_AddCCAccount();
		 }

	void GenerateMonthlyBillsButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.out.println(accountManager.getCustomerList().get(0).getName());
		JDialogGenBill billFrm = new JDialogGenBill(this, accountManager);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	}
	
	protected void setTable()
	{
		String[] columnNames= { "CC Number", "Name", "Exp Date", "Type", "Balance" };
        setTableColumns(columnNames);
	}
	 
	public String[] fillRowData(ICustomer customerTemp)
	{
		String[] rowdata2=new String[5];
		rowdata2[0] = customerTemp.getAccount().getAccountNum();
		rowdata2[1] = customerTemp.getName();
		if(customerTemp.getAccount().getExpDate() != null)
			rowdata2[2] = customerTemp.getAccount().getExpDate().toString();
		else
			rowdata2[2] = "";
		rowdata2[3] = customerTemp.getAccount().getAccountType();
		rowdata2[4] = Double.toString(customerTemp.getAccount().getBalance());
		return rowdata2;
	}
	
}
