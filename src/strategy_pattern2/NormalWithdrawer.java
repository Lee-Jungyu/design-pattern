package strategy_pattern2;

public class NormalWithdrawer implements Withdrawer {
	
	int balance;
	
	public NormalWithdrawer(int b) { balance = b; }
	
	public void withdraw(int money) {
		if(money > balance) {
			System.out.println(balance + "이하의 금액만 출금할 수 있습니다.");
			return;
		}
		balance -= money;
	}

}
