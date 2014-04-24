package framework.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.FinCo;
import framework.FinancialApp;
import framework.customer.ICustomer;
import framework.operation.AddOperation;
import framework.operation.SubtractOperation;
import framework.ui.actions.SymWindow;
import framework.ui.dialog.AAddAccDialog;
import framework.ui.dialog.AddAccDialog;
import framework.ui.dialog.AmountDialog;

public class FincoView extends AFincoView {
	
	protected FinancialApp app = null;

	protected JPanel JPanel1 = new JPanel();
	protected JButton AddAccountButton = new JButton();
	protected JButton DepositButton = new JButton();
	protected JButton WithdrawButton = new JButton();
	protected JButton ExitButton = new JButton();

	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected String rowdata[];

	protected void setTable()
	{
		String[] columnNames= { "AccountNr", "Name", "City", "Amount" };
		setTableColumns(columnNames);
	}

	public FincoView(FinancialApp view)
	{
		this.app = view; 
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
		setTable();

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

	public void addWindowListener(FincoView frame){
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
				AddAccountButton_actionPerformed(getAccountDialog());
			else if (object == DepositButton || object == WithdrawButton)
				computeActionPerformed(event);
			/*else if (object == AddinterestButton)
				AddinterestButton_actionPerformed(event);*/

		}

	}
	
	protected AAddAccDialog getAccountDialog(){
		return new AddAccDialog();
	}

	
	/**
	 * 
	 */
	public void AddAccountButton_actionPerformed(AAddAccDialog pac) {
		pac.setBounds(450, 20, 300, 400);
		pac.show();
		
		ICustomer customer = pac.getCustomer();
		String acctNumber = pac.getAcctNumber();
		String acctType = pac.getAcctType();
		
		if (customer!=null) {
			app.setCustomer(customer);
			app.setAccountNumber(acctNumber);
			app.setAccountType(acctType);
			app.addCustomer();
			refreshTable();
		}

	}
	
	protected void computeActionPerformed(java.awt.event.ActionEvent event)
	{
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accnr = (String)model.getValueAt(selection, 0);

			//Show the dialog for adding deposit amount for the current mane
			AmountDialog dep = new AmountDialog(accnr, "Deposit");
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			String amt = dep.getAmount();
			if (amt!=null) {
				if (event.getSource() == DepositButton)
				{
					app.setAmount(dep.getAmount());
					app.compute(accnr,AddOperation.ENTRY_TYPE);
				}
				else if (event.getSource() == WithdrawButton)
				{
					app.setAmount(dep.getAmount());
					app.compute(accnr,SubtractOperation.ENTRY_TYPE);
				}
				refreshTable();
			}
		}
	}

	protected void refreshTable()
	{
		List<ICustomer> customerList = app.getCustomerList();
		
		for(int i=model.getRowCount() - 1 ; i >= 0  ; i--)
			model.removeRow(i);

		for(int i=0 ; i < customerList.size() ; i++)
		{
			ICustomer customerTemp = customerList.get(i);
			model.addRow(fillRowData(customerTemp));
		}
		JTable1.setRowSelectionInterval(0, 0);
	}

	protected String[] fillRowData(ICustomer customerTemp)
	{
		String[] rowdata2=new String[4];
		rowdata2[0] = customerTemp.getAccount().getAccountNum();
		rowdata2[1] = customerTemp.getName();
		rowdata2[2] = customerTemp.getCity();
		rowdata2[3] = Double.toString(customerTemp.getAccount().getBalance());
		return rowdata2;
	}

	//When the Exit button is pressed this code gets executed
	//this will exit from the system
	protected void ExitButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}
	


}
