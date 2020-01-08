package strategy_pattern2;

public abstract class Account {
	int balance;
	Withdrawer withdrawer;
	InterestCalculator ic;
	
	public Account(int b) {balance = b;}
	public int getBalance() { return balance; }
	public void deposit(int money) { balance += money; }
	public abstract void withdraw(int money);
	public abstract int calculateInterest();
}
