package singleton_pattern7;

public class Singleton {
	protected static Singleton uniqueInstance;
	int a;
	// other useful instance variables here
 
	public Singleton() {}
 
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public int getInt() {return a;}
	public void setInt(int i) {a = i;}
	// other useful methods here
}
