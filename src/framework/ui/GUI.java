package framework.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.account.AccountManager;
import framework.customer.ICustomer;
import framework.transaction.AddAccountTransaction;
import framework.transaction.ITransaction;
import framework.transaction.TransactionManager;
import framework.ui.actions.SymWindow;

public class GUI extends JFrame {
	protected TransactionManager transactionManager=new TransactionManager();
	private DialogBox dialogManager;
	protected AccountManager accountManager=new AccountManager();
	
	protected JPanel JPanel1 = new JPanel();
	protected JButton AddAccountButton = new JButton();
	protected JButton DepositButton = new JButton();
	protected JButton WithdrawButton = new JButton();
	protected JButton ExitButton = new JButton();
	
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected String rowdata[];
	
	
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
        rowdata = new String[8];
        String[] columnNames= { "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount" };
        setTableColumns(columnNames);
        
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
		addWindowListener(this);
		
		SymAction lSymAction = new SymAction();
		ExitButton.addActionListener(lSymAction);
		AddAccountButton.addActionListener(lSymAction);
		DepositButton.addActionListener(lSymAction);
		WithdrawButton.addActionListener(lSymAction);
	}
	
	public void setTableColumns(String[] columnNames)
	{
		for(int i=0 ; i < columnNames.length ; i++)
			model.addColumn(columnNames[i]);
		rowdata = new String[columnNames.length];
	}
	
	public void addWindowListener(GUI frame){
		SymWindow aSymWindow = new SymWindow(this);
		frame.addWindowListener(aSymWindow);
	}
	
	
	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == ExitButton)
				ExitButton_actionPerformed(event);
			else if (object == AddAccountButton)
				AddAccountButton_actionPerformed(event, new AddAccDialog());
			else if (object == DepositButton)
				DepositButton_actionPerformed(event);
			/*else if (object == WithdrawButton)
				WithdrawButton_actionPerformed(event);
			else if (object == AddinterestButton)
				AddinterestButton_actionPerformed(event);*/
			
		}
	}
	
	protected void AddAccountButton_actionPerformed(java.awt.event.ActionEvent event, AAddAccDialog pac)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		//AddAccDialog pac = new JDialog_AddPAcc();
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
		    AmountDialog dep = new AmountDialog(accnr, "Deposit");
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    ICustomer iCustomerTemp=null;
		    for(int i=0 ; i < accountManager.getCustomerList().size() ; i++)
		    {
		    	if(accountManager.getCustomerList().get(i).getAccount().getAccountNum() == dep.getAccountNumber())
		    	{
		    		iCustomerTemp=accountManager.getCustomerList().get(i);
		    		break;
		    	}
		    }
		    
		    
		    
		    // compute new amount
            long deposit = Long.parseLong(dep.getAmount());
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 5);
		}
		
		
	}
	
	void refreshTable()
	{
		for(int i=0 ; i < model.getRowCount() ; i++)
			model.removeRow(i);
		
		for(int i=0 ; i < accountManager.getCustomerList().size() ; i++)
		{
			ICustomer customerTemp = accountManager.getCustomerList().get(i);
			model.addRow(fillRowData(customerTemp));
		}
	}
	
	public String[] fillRowData(ICustomer customerTemp)
	{
		String[] rowdata2=new String[6];
		rowdata2[0] = customerTemp.getAccount().getAccountNum();
		rowdata2[1] = customerTemp.getName();
		rowdata2[2] = customerTemp.getCity();
		rowdata2[3] = customerTemp.getAccount().getAccountType();
		rowdata2[4] = customerTemp.getAccount().getAccountType();
		rowdata2[5] = Double.toString(customerTemp.getAccount().getBalance());
		return rowdata2;
	}
	
	//When the Exit button is pressed this code gets executed
    //this will exit from the system
    protected void ExitButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}
	
	
}
