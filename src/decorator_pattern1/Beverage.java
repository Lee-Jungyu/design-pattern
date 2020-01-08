package decorator_pattern1;

public abstract class Beverage {
	String description = "Unknown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
