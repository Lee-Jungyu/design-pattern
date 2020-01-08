package strategy_pattern2;

import java.util.Date;

public class SavingWithdrawer implements Withdrawer {

	int balance;
	Date expirationDate;
	public SavingWithdrawer(int b, Date d) {
		balance = b;
		expirationDate = d;
	}
	
	public void withdraw(int money) {
		if(new Date().before(expirationDate)) {
			System.out.println("계약만료일에만 출금이 가능합니다.");
			return;
		}
		if(money > balance) {
			System.out.println(balance + "이하의 금액만 출금 할 수 있습니다.");
			return;
		}
		balance -= money;
	}

}
