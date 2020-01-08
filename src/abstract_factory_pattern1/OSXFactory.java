package abstract_factory_pattern1;

public class OSXFactory implements GUIFactory{
	
	public Button createButton() {
		Button button = new OSXButton();
		return button;
	}

}
