package factory_pattern1;

public class NYStyleClamPizza extends Pizza {
	public NYStyleClamPizza() {
		name = "NY Style Sauce and Clam Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		
		toppings.add("Clam");
	}
}
