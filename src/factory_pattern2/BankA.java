package factory_pattern2;


public class BankA extends Bank {
	public BankA() { name = "BankA"; }
	public Account createAccount(String item)
	{
		if(item.equals("normal")) {
			return new NormalAccountA();
		} else if (item.equals("minus")) {
			return new MinusAccountA(100);
		} else if (item.equals("stock")) {
			return new StockAccountA();
		} else return null;
	}
}
