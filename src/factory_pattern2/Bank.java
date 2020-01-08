package factory_pattern2;

public abstract class Bank {
	protected String name;
	
	protected abstract Account createAccount(String item);
	public String getName() { return name; }
}
