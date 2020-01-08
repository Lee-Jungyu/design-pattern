package observer_pattern1;

public class WeatherStation {
	
	public static void main(String[] args) {
		//subject 생성
		WeatherData weatherData = new WeatherData();
		
		//Observer 생성
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		
		//기상대 시뮬레이션
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
