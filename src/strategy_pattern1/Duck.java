package strategy_pattern1;

public abstract class Duck {
	FlyBehavior flyBehavior;
	CryBehavior cryBehavior;
	
	abstract void display();
	public void swim() { System.out.println("All ducks float, even decoys!"); }
	public void fly() { flyBehavior.fly(); }
	public void quack() { cryBehavior.quack(); }
	
	public void setFlyBehavior(FlyBehavior fb) { flyBehavior = fb; }
}
