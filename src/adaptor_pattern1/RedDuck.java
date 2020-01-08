package adaptor_pattern1;

public class RedDuck implements Duck {
	Turkey turkey;
	public RedDuck(Turkey t) {turkey = t;}
	
	public void quack() {turkey.gobble();}
	public void fly() {turkey.fly();}
}
