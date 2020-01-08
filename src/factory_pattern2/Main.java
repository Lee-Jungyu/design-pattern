package factory_pattern2;


public class Main {
	public static void main(String[] args) {
		Bank bankA = new BankA();
		Bank bankB = new BankB();
		Bank bankC = new BankC();
		
		Account normalAccountC = bankC.createAccount("normal");
		Account minusAccountB = bankB.createAccount("minus");
		Account stockAccountA = bankA.createAccount("stock");
		
		System.out.println("first is " + normalAccountC.getName());
		System.out.println("second is " + minusAccountB.getName());
		System.out.println("third is " + stockAccountA.getName());
	}
}
 