package banking.ui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import framework.customer.ICustomer;
import framework.transaction.AddAccountTransaction;
import framework.transaction.ITransaction;
import framework.transaction.TransactionManager;
import framework.ui.AAddAccDialog;
import framework.ui.AddAccDialog;
import framework.ui.GUI;
import framework.ui.actions.SymWindow;

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
	
	
}
