package banking;

import javax.swing.UIManager;

import banking.ui.BankGUI;
import framework.FinCo;

public class Bank extends FinCo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (Exception e) { 
			}

			//Create a new instance of our application's frame, and make it visible.
			(new BankGUI()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
