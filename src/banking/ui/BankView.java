package banking.ui;

import banking.ui.dialog.AddCompAccDialog;
import banking.ui.dialog.AddPersAccDialog;
import framework.FinancialApp;
import framework.customer.ICustomer;
import framework.ui.FincoView;
import framework.ui.dialog.AAddAccDialog;

/**
 * A basic JFC based application.
 */
public class BankView extends FincoView {

	javax.swing.JButton AddCompanyAccountButton = new javax.swing.JButton();
	javax.swing.JButton AddinterestButton = new javax.swing.JButton();

	@Override
	protected void setTable()
	{
		String[] columnNames= { "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount" };
		setTableColumns(columnNames);
	}

	public BankView(FinancialApp app)
	{
		super(app);
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
		AddinterestButton.addActionListener(lSymAction);

	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == ExitButton)
				ExitButton_actionPerformed(event);
			else if (object == AddCompanyAccountButton)
				AddAccountButton_actionPerformed(new AddCompAccDialog());
			/*else if (object == DepositButton || object == WithdrawButton)
				computeActionPerformed(event);
			else if (object == AddinterestButton)
				addInterestActionPerformed(event);
			*/
		}
	}

	@Override
	protected AAddAccDialog getAccountDialog(){
		return new AddPersAccDialog();
	}

	/*private void addInterestActionPerformed(java.awt.event.ActionEvent event)
	{
		IOperation addOperation = new AddInterestOperation();
		ITransaction transaction = new ComputeTransaction(accountManager, addOperation);
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.submit(transaction);
		JOptionPane.showMessageDialog(AddinterestButton, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		refreshTable();
	}*/

	@Override
	protected String[] fillRowData(ICustomer customerTemp)
	{
		String[] rowdata2=new String[6];
		rowdata2[0] = customerTemp.getAccount().getAccountNum();
		rowdata2[1] = customerTemp.getName();
		rowdata2[2] = customerTemp.getCity();
		rowdata2[3] = customerTemp.getCustomerType();
		rowdata2[4] = customerTemp.getAccount().getAccountType();
		rowdata2[5] = Double.toString(customerTemp.getAccount().getBalance());
		return rowdata2;
	}

}
