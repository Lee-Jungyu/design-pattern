package singleton_pattern5;

public class Singleton {
	private volatile static Singleton uniqueInstance;
	private String text = "dcl";
 
	private Singleton() {}
	
	public String getText() {return text;}
 
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}