package strategy_pattern1;

public class RubberDuck extends Duck {
	RubberDuck() { 
		flyBehavior = new FlyNoWay();
		cryBehavior = new CanNotCry();
	}
	
	void display() {
		System.out.println("I'm a Rubber duck");
	}

}
