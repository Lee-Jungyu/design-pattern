package observer_pattern3;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	Observable observable;			 // subject
	private float temperature, humidity;	 // 관심 정보
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this); // 생성시 subject에 등록.
	}
	
	public void update(Observable o, Object arg) {
		if (arg instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)arg;
			this.temperature = weatherData.getTemperature();	 // pulling
			this.humidity = weatherData.getHumidity();		 // pulling
			display();
		}
	}
	
	public void display() {
		System.out.println(temperature 	+ "F and " + humidity + "% humidity");
	}
}
