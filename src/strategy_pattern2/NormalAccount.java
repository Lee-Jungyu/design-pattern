package strategy_pattern2;

public class NormalAccount extends Account {

	NormalAccount(int b) {
		super(b);
		withdrawer = new NormalWithdrawer(b);
		ic = new NormalInterestCalculator(b);
	}
	
	public void withdraw(int money) {
		withdrawer.withdraw(money);
		balance = ((NormalWithdrawer)withdrawer).balance;
	}
	
	public int calculateInterest() {
		ic = new NormalInterestCalculator(balance);
		return ic.calculateInterest();
	}

}
