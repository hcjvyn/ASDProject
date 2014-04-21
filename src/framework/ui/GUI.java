package framework.ui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import framework.account.AccountManager;
import framework.account.factory.IAccountFactory;
import framework.transaction.TransactionManager;

public class GUI extends JFrame {
	private TransactionManager transactionManager;
	private DialogBox dialogManager;
	private AccountManager accountManager;
	private ArrayList<IAccountFactory> iAccountFactoryList;
	
	protected JPanel JPanel1 = new JPanel();
	protected JButton AddAccountButton = new JButton();
	protected JButton DepositButton = new JButton();
	protected JButton WithdrawButton = new JButton();
	protected JButton ExitButton = new JButton();
	
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];
	
	
	public GUI()
	{
		setTitle("FinCo Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(610,350);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,610,350);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        rowdata = new Object[8];
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
		
        AddAccountButton.setText("Add account");
        AddAccountButton.setActionCommand("jbutton");
		JPanel1.add(AddAccountButton);
		AddAccountButton.setBounds(24,20,192,33);
		
		DepositButton.setText("Deposit");
		JPanel1.add(DepositButton);
		DepositButton.setBounds(468,104,96,33);
		
		WithdrawButton.setText("Withdraw");
		WithdrawButton.setBounds(468,164,96,33);
		JPanel1.add(WithdrawButton);
		
		ExitButton.setText("Exit");
		ExitButton.setBounds(468,248,96,31);
		JPanel1.add(ExitButton);
	}
	
	public void setTableColumns(String[] columnNames)
	{
		for(int i=0 ; i < columnNames.length ; i++)
			model.addColumn(columnNames[i]);
		rowdata = new Object[columnNames.length];
	}
}
