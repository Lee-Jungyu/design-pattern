package strategy_pattern2;

public class MinusInterestCalculator implements InterestCalculator {

	int balance;
	int creditLimit;
	public MinusInterestCalculator(int b, int c) {
		balance = b;
		creditLimit = c;
	}
	public int calculateInterest() {
		if(balance > 0) return 0;
		return (int) (0.7 * balance);
	}

}
