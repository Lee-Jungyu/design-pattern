package singleton_pattern4;

public class Main {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getText());
	}
}
