package strategy_pattern1;

public class Main {
	public static void main(String[] args)
	{
		MallardDuck md = new MallardDuck();
		md.display();
		md.fly();
		md.quack();
		
		RubberDuck rd = new RubberDuck();
		rd.display();
		rd.fly();
		rd.quack();
	}
}
