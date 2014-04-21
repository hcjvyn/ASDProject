package framework.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

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
	
	JButton addPersonalAccountButton = new JButton();
	JButton addCompanyAccountButton = new JButton();
	JButton addInterestButton = new JButton();
	JButton depositButton = new JButton();
	JButton withdrawButton = new JButton();
	JButton exitButton = new JButton();
	JTable accountTable = new JTable();
	
	
	public GUI()
	{
		setTitle("FinCo Application"); 
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(550,350);
		setVisible(false);
		
		addPersonalAccountButton.setText("Add Personal Account");
		getContentPane().add(addPersonalAccountButton);
		addPersonalAccountButton.setBounds(30,40,150,30);
		
		addCompanyAccountButton.setText("Add Company Account");
		getContentPane().add(addCompanyAccountButton);
		addCompanyAccountButton.setBounds(200,40,150,30);
		
		addInterestButton.setText("Add Interest");
		getContentPane().add(addInterestButton);
		addInterestButton.setBounds(370,40,150,30);
		
		depositButton.setText("Deposit");
		getContentPane().add(depositButton);
		depositButton.setBounds(420,120,100,30);
		
		withdrawButton.setText("Withdraw");
		getContentPane().add(withdrawButton);
		withdrawButton.setBounds(420,180,100,30);
		
		exitButton.setText("Exit");
		getContentPane().add(exitButton);
		exitButton.setBounds(420,250,100,30);
		
	    accountTable=new JTable(3, 3);
	    accountTable.setBounds(30, 90, 350, 200);
		getContentPane().add(accountTable);
	}
}
