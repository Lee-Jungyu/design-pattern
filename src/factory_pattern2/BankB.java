package factory_pattern2;

public class BankB extends Bank {
	public BankB() { name = "BankB"; }
	public Account createAccount(String item)
	{
		if(item.equals("normal")) {
			return new NormalAccountB();
		} else if (item.equals("minus")) {
			return new MinusAccountB(100);
		} else if (item.equals("stock")) {
			return new StockAccountB();
		} else return null;
	}
}
