package strategy_pattern2;

import java.util.Date;

public class SavingAccount extends Account {

	Date expirationDate;
	public SavingAccount(int b, Date d) {
		super(b);
		expirationDate = d;
		withdrawer = new SavingWithdrawer(b, d);
		ic = new SavingInterestCalculator(b);
	}

	public void withdraw(int money) {
		withdrawer.withdraw(money);
		balance = ((SavingWithdrawer)withdrawer).balance;
	}

	public int calculateInterest() {
		ic = new SavingInterestCalculator(balance);
		return ic.calculateInterest();
	}

}
