package factory_pattern2;

public class BankC extends Bank {
	public BankC() { name = "BankC"; }
	public Account createAccount(String item)
	{
		if(item.equals("normal")) {
			return new NormalAccountC();
		} else if (item.equals("minus")) {
			return new MinusAccountC(100);
		} else return null;
	}
}
