package factory_pattern2;

public abstract class NormalAccount extends Account {
	
	public NormalAccount() {}
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		if(money > balance) {
			System.out.println("출금 불가");
			return;
		}
		balance -= money;
	}

}
