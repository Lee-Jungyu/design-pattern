package strategy_pattern2;

import java.util.Date;

public class Main {
	public static void main(String[] args)
	{
		NormalAccount na = new NormalAccount(10000);
		MinusAccount ma = new MinusAccount(10000, 10000);
		SavingAccount sa = new SavingAccount(10000, new Date());
		
		System.out.println("Normal Account interest is " + na.calculateInterest());
		System.out.println("Normal Account current balance: " + na.getBalance());
		na.withdraw(5000);
		System.out.println("Normal Account current balance: " + na.getBalance());
		na.withdraw(3000);
		System.out.println("Normal Account current balance: " + na.getBalance());
		na.withdraw(6000);
		System.out.println("Normal Account current balance: " + na.getBalance());
		

		System.out.println("Minus Account interest is " + ma.calculateInterest());
		System.out.println("Minus Account current balance: " + ma.getBalance());
		ma.withdraw(10000);
		System.out.println("Minus Account current balance: " + ma.getBalance());
		ma.withdraw(5000);
		System.out.println("Minus Account current balance: " + ma.getBalance());
		System.out.println("Minus Account interest is " + ma.calculateInterest());
		ma.withdraw(20000);
		System.out.println("Minus Account current balance: " + ma.getBalance());

		System.out.println("Saving Account interest is " + sa.calculateInterest());
		System.out.println("Saving Account current balance: " + sa.getBalance());
		sa.withdraw(5000);
		System.out.println("Saving Account current balance: " + sa.getBalance());
		sa.withdraw(2000);
		System.out.println("Saving Account current balance: " + sa.getBalance());
		sa.withdraw(5000);
		System.out.println("Saving Account current balance: " + sa.getBalance());
	}

}
