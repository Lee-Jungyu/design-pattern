package mvc_pattern2;

public class Calculator {
	public static void main(String[] args)
	{
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		model.registerObserver(view);
		CalculatorControl control = new CalculatorControl(model, view);
		view.setVisible(true);
	}
}
