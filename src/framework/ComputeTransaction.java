package framework;

public class ComputeTransaction extends ATransaction {
	private IOperation iOperation;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.iOperation.compute();
	}

}
