package singleton_pattern6;

public class Main {
	public static void main(String[] args)
	{
		Singleton first = Singleton.getInstance();
		Singleton second = Singleton.getInstance();
		Singleton third = Singleton.getInstance();
		Singleton fourth = Singleton.getInstance();
		Singleton fifth = Singleton.getInstance();
		Singleton sixth = Singleton.getInstance();
	}
}
