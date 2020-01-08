package singleton_pattern7;

public class SingletonTestDrive {
	public static void main(String[] args) {
		Singleton foo = CoolerSingleton.getInstance();
		Singleton bar = HotterSingleton.getInstance();
		
		//Singleton foo = new CoolerSingleton();
		//Singleton bar = new HotterSingleton();
		System.out.println(foo + " " + foo.getInt());
		System.out.println(bar + " " + bar.getInt());
		
		foo.setInt(1);
		bar.setInt(2);
		
		System.out.println(foo + " " + foo.getInt());
		System.out.println(bar + " " + bar.getInt());
 	}
}
