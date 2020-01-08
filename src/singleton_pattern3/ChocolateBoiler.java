package singleton_pattern3;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
  
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
  
	private static class Holder {
		public static final ChocolateBoiler INSTANCE = new ChocolateBoiler();
	}
	
	public static ChocolateBoiler getInstance()
	{
		return Holder.INSTANCE;
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