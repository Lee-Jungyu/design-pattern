package observer_pattern3;

import java.util.Observable;

public class WeatherData extends Observable {
	private float temperature, humidity, pressure; // 관심 정보
	
	public WeatherData() { }

	// for pulling
	public float getTemperature()	{ return temperature; }
	public float getHumidity() 		{ return humidity; }
	public float getPressure() 		{ return pressure; }

	// 관심 정보 변경 時:
	public void measurementsChanged() {
		setChanged();
		notifyObservers(this); // pull: if (hasChanged()) {for all observers, update(this, null); clearChanged();}
	}

	// 기상청이 호출함.
	public void setMeasurements(float t, float h, float p) {
		temperature = t;  humidity = h;  pressure = p;
		measurementsChanged();
	}
}
