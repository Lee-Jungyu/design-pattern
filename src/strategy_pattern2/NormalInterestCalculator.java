package strategy_pattern2;

public class NormalInterestCalculator implements InterestCalculator{
	int balance;
	public NormalInterestCalculator(int b) { balance = b; }
	public int calculateInterest() {
		int interest = (int) (balance * 0.3);
		return interest;
	}

}
