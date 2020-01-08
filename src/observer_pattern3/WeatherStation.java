package observer_pattern3;

public class WeatherStation {

	public static void main(String[] args) {

		// observable (or subject) 생성.
		WeatherData weatherData = new WeatherData();

		// observers 생성.
		CurrentConditionsDisplay 	cc = new CurrentConditionsDisplay(weatherData);

		// 기상청이 subject 생태 변경.
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
