package framework.ui;

public class AmountDialog extends javax.swing.JDialog {

	protected String accnr;
	protected String amount;

	public AmountDialog(String accnr) {
		this.accnr = accnr;
	}

	public String getAmount() {
		return amount;
	}

}
