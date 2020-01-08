package strategy_pattern2;

public class SavingInterestCalculator implements InterestCalculator {

	int balance;
	public SavingInterestCalculator(int b) { balance = b;}
	public int calculateInterest() {
		int interest = (int) (balance * 0.5);
		return interest;
	}

}
