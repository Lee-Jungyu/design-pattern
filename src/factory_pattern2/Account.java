package factory_pattern2;

public abstract class Account {
	protected int balance;
	protected String name;
	
	public int getBalance() {
		 return balance;
	}
	public String getName() {
		return name;
	}
	public abstract void deposit(int money);
	public abstract void withdraw(int money);
}
