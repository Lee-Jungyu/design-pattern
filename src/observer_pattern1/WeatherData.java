package observer_pattern1;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private float 온도, 습도, 기압;				//관심 정보
	private ArrayList<Observer> observers;	//observer list
	
	public WeatherData() {observers = new ArrayList<Observer>();}
	
	//Subject 인터페이스 구현
	public void registerObserver(Observer o) {observers.add(o);}
	public void removeObserver(Observer o) {observers.remove(o);}
	public void notifyObservers() {
		for (Observer o : observers) o.update(온도, 습도, 기압);
	}
	
	public void setMeasurements(float t, float h, float p) {
		온도 = t; 습도 = h; 기압 = p;
		measurementsChanged();
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
}
