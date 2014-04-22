/**
 * Purpose: 
 * Author: jhiolen
 * Date: Apr 22, 2014
 * Lab Number:
 */
package framework.ui.actions;

import javax.swing.JFrame;


public class SymWindow extends java.awt.event.WindowAdapter
{
	private JFrame frame ;
	public SymWindow(JFrame frame){
		this.frame = frame;
	}
	
	public void windowClosing(java.awt.event.WindowEvent event)
	{
		try {
			frame.setVisible(false);    // hide the Frame
			frame.dispose();            // free the system resources
		    System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}
	
	
}
