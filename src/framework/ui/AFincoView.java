/**
 * Purpose: 
 * Author: jhiolen
 * Date: Apr 23, 2014
 * Lab Number:
 */
package framework.ui;

import javax.swing.JFrame;

import framework.ui.dialog.AAddAccDialog;

public abstract class AFincoView extends JFrame{
	
	protected abstract void setTable();
	protected abstract AAddAccDialog getAccountDialog();

}
