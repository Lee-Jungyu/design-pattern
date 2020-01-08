package mvc_pattern2;

import java.util.ArrayList;

public class CalculatorModel {
	private int data;
	private ArrayList<Observer> list = new ArrayList<Observer>();
	
	public void registerObserver(Observer o) {
		list.add(o);
	}
	
	public void notifyObservers() {
		for(Observer o : list) {
			o.update(data);
		}
	}
	
	public void plus(int num1, int num2) {
		data = num1 + num2;
		notifyObservers();
	}
	
	public void minus(int num1, int num2) {
		data = num1 - num2;
		notifyObservers();
	}
}
