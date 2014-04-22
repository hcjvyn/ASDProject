package framework.transaction;

import java.util.ArrayList;

public class TransactionManager {
	private ArrayList<ITransaction> iTransactionList=new ArrayList<ITransaction>();
	
	public void submit(ITransaction iTransaction)
	{
		iTransaction.execute();
		iTransactionList.add(iTransaction);
	}
}
