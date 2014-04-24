package creditcard.ui;


import java.util.List;

import javax.swing.JButton;
import javax.swing.UIManager;

import creditcard.ui.dialog.AddCCAccDialog;
import creditcard.ui.dialog.GenBillDialog;
import framework.FinancialApp;
import framework.customer.ICustomer;
import framework.ui.FincoView;
import framework.ui.dialog.AAddAccDialog;

/**
 * A basic JFC based application.
 */
public class CCardView extends FincoView {
	/****
	 * init variables in the object
	 ****/
	JButton GenerateMonthlyBillsButton = new JButton();

	public CCardView(FinancialApp app)
	{
		super(app);
		setTitle("Credit-card processing Application.");

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
		//		DepositButton.addActionListener(lSymAction);
		//		WithdrawButton.addActionListener(lSymAction);

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
			else if (object == DepositButton || object == WithdrawButton)
				computeActionPerformed(event);
			else if (object == GenerateMonthlyBillsButton)
				genMonBillsActionPerformed(event);
		}
	}

	@Override
	protected AAddAccDialog getAccountDialog(){
		return new AddCCAccDialog();
	}

	private void genMonBillsActionPerformed(java.awt.event.ActionEvent event)
	{
		List<ICustomer> customerList=app.getCustomerList();
		GenBillDialog billFrm = new GenBillDialog(customerList);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	}

	@Override
	protected void setTable()
	{
		String[] columnNames= { "CC Number", "Name", "Exp Date", "Type", "Balance" };
		setTableColumns(columnNames);
	}

	@Override
	protected String[] fillRowData(ICustomer customerTemp)
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
