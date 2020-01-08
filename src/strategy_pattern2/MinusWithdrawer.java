package strategy_pattern2;

public class MinusWithdrawer implements Withdrawer {

	int balance;
	int creditLimit;
	
	public MinusWithdrawer(int b, int c) {
		balance = b;
		creditLimit = c;
	}
	
	public void withdraw(int money) {
		if(money > balance + creditLimit) {
			System.out.println( balance + creditLimit + "이하의 금액만 출금할 수 있습니다.");
			return;
		}
		balance -= money;
	}
	
}
