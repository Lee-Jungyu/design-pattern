package strategy_pattern2;

public class MinusAccount extends Account{

	int creditLimit;
	
	MinusAccount(int b, int c)
	{
		super(b);
		creditLimit = c;
		withdrawer = new MinusWithdrawer(b, c);
		ic = new MinusInterestCalculator(b, c);
	}
	
	public void withdraw(int money) {
		withdrawer.withdraw(money);
		balance = ((MinusWithdrawer)withdrawer).balance;
		
	}

	public int calculateInterest() {
		ic = new MinusInterestCalculator(balance, creditLimit);
		return ic.calculateInterest();
	}

}
