package factory_pattern2;

public abstract class MinusAccount extends Account{
	protected int creditLimit;
	
	public MinusAccount(int c) { creditLimit = c; }
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		if(money > balance + creditLimit) {
			System.out.println("출금불가");
			return;
		}
		balance -= money;
	}
}
