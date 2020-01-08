package singleton_pattern2;


public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance = null;
  
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
  
	static {
		try {
			uniqueInstance = new ChocolateBoiler();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ChocolateBoiler getInstance()
	{
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			System.out.println("fill");
			// fill the boiler with a milk/chocolate mixture
		}
	}
 
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// drain the boiled milk and chocolate
			System.out.println("drain");
			empty = true;
		}
	}
 
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			// bring the contents to a boil
			System.out.println("boil");
			boiled = true;
		}
	}
  
	public boolean isEmpty() {
		return empty;
	}
 
	public boolean isBoiled() {
		return boiled;
	}
}