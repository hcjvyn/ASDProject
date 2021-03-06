package creditcard.ui.dialog;

/*
		A basic implementation of the JDialog class.
*/

import java.awt.*;
import java.util.List;
import java.util.Date;

import javax.swing.*;

import framework.account.AccountManager;
import framework.account.IAccount;
import framework.account.entry.IEntry;
import framework.customer.ICustomer;

public class GenBillDialog extends javax.swing.JDialog
{
    String billstring;
    List<ICustomer> customerList;
    
	public GenBillDialog(List<ICustomer> customerList)
	{
		//super(parent);
		
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		
		this.customerList=customerList;
		
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextArea1);
		JTextArea1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		// generate the string for the monthly bill
		billstring="";
		for(int i=0 ; i < customerList.size() ; i++)
		{
			ICustomer iCustomerTemp=customerList.get(i);
			billstring +=  "Name= " + iCustomerTemp.getName() + "\r\n";
			billstring += "Address= " + iCustomerTemp.getStreet() + ", " + iCustomerTemp.getCity() + ", " + iCustomerTemp.getState() + ", " + iCustomerTemp.getZip() + "\r\n";
			
			IAccount iAccount = iCustomerTemp.getAccount();
			billstring += "CC number= " + iAccount.getAccountNum() + "\r\n";
			billstring += "CC type= " + iAccount.getAccountType() + "\r\n";
			
			List<IEntry> iEntryList = iAccount.getEntryList();
			Date now=new Date();
			double previousBalance=iAccount.getBalance(), totalCharges=0, totalCredits=0;
			
			for(int j=0 ; j < iEntryList.size() ; j++)
			{
				IEntry iEntryTemp = iEntryList.get(j);
				Date date=iEntryTemp.getDate();
				// haven't use dateadd for comparing
				if(date.getMonth()==now.getMonth())
				{
					if(iEntryTemp.getEntryType()=="D")
					{
						totalCredits=totalCredits+iEntryTemp.getAmount();
						previousBalance=previousBalance+iEntryTemp.getAmount();
					}
					else if(iEntryTemp.getEntryType()=="C")
					{
						totalCharges=totalCharges+iEntryTemp.getAmount();
						previousBalance=previousBalance-iEntryTemp.getAmount();
					}
				}
			}
			billstring += "Previous balance = $ " + previousBalance + "\r\n";
			billstring += "Total Credits = $ " + totalCredits + "\r\n";
			billstring += "Total Charges = $ " + totalCharges + "\r\n";
			double newBalance=previousBalance - totalCredits + totalCharges + iAccount.getInterestRate() * (previousBalance - totalCredits) ;
			billstring += "New balance = $ " + newBalance + "\r\n";
			billstring += "Total amount due = $ " + iAccount.getMinimumPayment() * newBalance + "\r\n";
			billstring += "\r\n";		
			billstring += "\r\n";
		}
		JTextArea1.setText(billstring);
		//}}
	
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		//}}
	}

	//{{DECLARE_CONTROLS
	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea JTextArea1 = new JTextArea();
	JButton JButton_OK = new JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}
}
