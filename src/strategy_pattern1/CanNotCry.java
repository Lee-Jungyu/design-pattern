package strategy_pattern1;

public class CanNotCry implements CryBehavior {

	public void quack() {
		System.out.println("I can't cry");
	}

}
