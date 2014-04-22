package framework.account.entry;

import java.util.Date;

public interface IEntry {

	public double getAmount();
	public Date getDate();
	public String getEntryType();
}
