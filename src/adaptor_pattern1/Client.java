package adaptor_pattern1;

public class Client {
	public static void main(String[] args) {
		Turkey turkey = new WildTurkey();
		
		Duck duck = new RedDuck(turkey);
		
		duck.quack();
		duck.fly();
	}
}
