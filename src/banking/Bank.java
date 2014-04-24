package banking;

import javax.swing.UIManager;

import banking.account.factory.BankAccountFactory;
import banking.ui.BankGUI;
import framework.FinCo;
import framework.FinancialApp;
import framework.account.factory.IAccountFactory;
import framework.ui.AFincoView;
import framework.ui.FincoView;

public class Bank extends FinancialApp {
	
	
	/**
	 * Initialize all variables.
	 * @param factory
	 */
	public Bank() {
		super(new BankAccountFactory());
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinancialApp app = new Bank();
		AFincoView view = new BankGUI(app);
		app.setView(view);
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (Exception e) { 
			}

			//Create a new instance of our application's frame, and make it visible.
			app.getView().setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	

}
