package framework;

public abstract class ATransaction implements ITransaction{
	protected AccountManager accountManager;
	public abstract void execute();
}
