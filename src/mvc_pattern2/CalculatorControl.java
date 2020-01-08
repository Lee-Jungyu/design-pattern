package mvc_pattern2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorControl implements ActionListener{
	CalculatorView view;
	CalculatorModel model;
	CalculatorControl(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		this.view.setCalculatorListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
		if(e.getSource().equals(view.plusBtn)) {
			int num1 = Integer.parseInt(view.operator1.getText());
			int num2 = Integer.parseInt(view.operator2.getText());
			model.plus(num1, num2);
		}
		else {
			int num1 = Integer.parseInt(view.operator1.getText());
			int num2 = Integer.parseInt(view.operator2.getText());
			model.minus(num1, num2);
		}
	}
}
