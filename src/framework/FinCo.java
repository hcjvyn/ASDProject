package framework;

import javax.swing.UIManager;

import framework.account.factory.AccountFactory;
import framework.account.factory.IAccountFactory;
import framework.ui.FincoView;

public class FinCo extends FinancialApp{
	
	public FinCo(){
		super(new AccountFactory());
	}
	
	
	public static void main(String args[])
	{
		FinancialApp app = new FinCo();
		FincoView view = new FincoView(app);
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
		    app.view.setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


}
