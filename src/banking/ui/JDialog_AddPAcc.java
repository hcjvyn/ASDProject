package banking.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import banking.account.factory.CheckingAccountFactory;
import banking.account.factory.SavingAccountFactory;
import banking.customer.Person;
import framework.account.factory.IAccountFactory;
import framework.customer.ICustomer;
import framework.ui.AAddAccDialog;

/*
		A basic implementation of the JDialog class.
*/


public class JDialog_AddPAcc extends AAddAccDialog {
	
    public JDialog_AddPAcc()
	{
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283,303);
		setVisible(false);
		
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,0,84,24);
		
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,24,84,24);
		
		JLabelName.setText("Name");
		getContentPane().add(JLabelName);
		JLabelName.setForeground(java.awt.Color.black);
		JLabelName.setBounds(12,84,48,24);
		
		JLabelStreet.setText("Street");
		getContentPane().add(JLabelStreet);
		JLabelStreet.setForeground(java.awt.Color.black);
		JLabelStreet.setBounds(12,108,48,24);
		
		JLabelCity.setText("City");
		getContentPane().add(JLabelCity);
		JLabelCity.setForeground(java.awt.Color.black);
		JLabelCity.setBounds(12,132,48,24);
		
		JLabelState.setText("State");
		getContentPane().add(JLabelState);
		JLabelState.setForeground(java.awt.Color.black);
		JLabelState.setBounds(12,156,48,24);
		
		JLabelZip.setText("Zip");
		getContentPane().add(JLabelZip);
		JLabelZip.setForeground(java.awt.Color.black);
		JLabelZip.setBounds(12,180,48,24);
		
		JLabelBday.setText("Birthdate");
		getContentPane().add(JLabelBday);
		JLabelBday.setForeground(java.awt.Color.black);
		JLabelBday.setBounds(12,204,96,24);
		
		JLabelEmail.setText("Email");
		getContentPane().add(JLabelEmail);
		JLabelEmail.setForeground(java.awt.Color.black);
		JLabelEmail.setBounds(12,228,48,24);
		
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,84,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84,132,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84,156,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84,108,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84,180,156,20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84,204,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84,228,156,20);
		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,264,84,24);
		
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,264,84,24);
		
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84,60,156,20);
		JLabelAcnr.setText("Acc Nr");
		getContentPane().add(JLabelAcnr);
		
		JLabelAcnr.setForeground(java.awt.Color.black);
		JLabelAcnr.setBounds(12,60,48,24);
		//}}
	
		//{{REGISTER_LISTENERS
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
		//}}
	}

	//{{DECLARE_CONTROLS
	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	
	javax.swing.JLabel JLabelBday = new javax.swing.JLabel();
	javax.swing.JLabel JLabelEmail = new javax.swing.JLabel();
	
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	//}}


	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	private void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Checking radio is clicked make this radio on 
		//and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	private void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Saving radio is clicked make this radio on 
		//and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	 
	}

	@Override
	protected ICustomer createCustomer() {
		try {
			String clientName = JTextField_NAME.getText();
			String street = JTextField_STR.getText();
			String city = JTextField_CT.getText();
			String zip = JTextField_ZIP.getText();
			String state = JTextField_ST.getText();
			Date birthDate = new SimpleDateFormat("MM/dd/yyyy").parse(JTextField_BD.getText());
			
			return new Person(
					clientName,
					street,
					city,
					state,
					zip,
					birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected IAccountFactory selectFactory() {
		if (JRadioButton_Chk.isSelected())
			return new CheckingAccountFactory();
		else
			return new SavingAccountFactory();
	}

}