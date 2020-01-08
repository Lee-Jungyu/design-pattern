package singleton_pattern1;

public class Singleton {
	private static final Singleton INSTANCE = new Singleton();
	private String text;
	private Singleton() 
	{
		text = "Singleton";
	}
	
	public static Singleton getInstance() {
		return INSTANCE;
	}
	public String getText()
	{
		return text;
	}
}
