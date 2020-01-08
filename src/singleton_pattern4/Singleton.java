package singleton_pattern4;

//threadsafe
public class Singleton {
	private static Singleton uniqueInstance;
	private String text = "thread safe";
	// other useful instance variables here
 
	private Singleton() {}
	
	public String getText() {
		return text;
	}
 
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}
