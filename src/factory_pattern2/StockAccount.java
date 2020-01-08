package factory_pattern2;

public abstract class StockAccount extends Account{
	
	public StockAccount() {}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		if(money > balance) {
			System.out.println("출금불가");
			return;
		}
		balance -= money;
	}
	
}
