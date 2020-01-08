package strategy_pattern1;

public class MallardDuck extends Duck {
	public MallardDuck() { 
		flyBehavior = new FlyWithWings();
		cryBehavior = new CanCry();
	}
	
	public void display() { System.out.println("I'm a real Mallard duck"); }
}
