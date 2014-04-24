package creditcard;

import javax.swing.UIManager;

import creditcard.account.factory.CCAccountFactory;
import creditcard.ui.CardGUI;
import framework.FinancialApp;
import framework.ui.AFincoView;

public class CCard extends FinancialApp{

	/**
	 * Initialize all variables.
	 * @param factory
	 */
	public CCard() {
		super(new CCAccountFactory());
	}

	public static void main(String[] args) {
		FinancialApp app = new CCard();
		AFincoView view = new CardGUI(app);
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
