package framework.transaction;

import framework.operation.IOperation;

public class ComputeTransaction extends ATransaction {
	private IOperation iOperation;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.iOperation.compute();
	}

}
