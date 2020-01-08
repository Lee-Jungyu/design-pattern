package abstract_factory_pattern1;

public class Client {
	public static void main(String[] args) {
		GUIFactory myfact = new WinFactory();
		Button button = myfact.createButton();
		button.paint();
	}
}
