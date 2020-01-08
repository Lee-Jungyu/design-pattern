package abstract_factory_pattern1;

public class WinFactory implements GUIFactory{
	public Button createButton() {
		Button button = new WinButton();
		return button;
	}
}
