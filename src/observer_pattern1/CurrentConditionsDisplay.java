package observer_pattern1;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature, humidity, pressure;	//관심 정보
	private Subject weatherData;					//탈퇴시 필요함
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);	// subject에 등록함
	}
	
	//Observer 인터페이스 구현:
	public void update(float t, float h, float p) {
		temperature = t; humidity = h; pressure = p;
		display();
	}
	
	//DisplayElemeent 인터페이스 구현:
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}
