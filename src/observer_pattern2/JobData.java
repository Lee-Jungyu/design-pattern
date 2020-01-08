package observer_pattern2;

import java.util.ArrayList;

public class JobData implements Subject{
	private String 기업이름;
	private String 업무내용;
	private int 연봉;
	private ArrayList<Observer> observers;
	
	public JobData() { observers = new ArrayList<Observer>(); }
	
	public void registerObserver(Observer o) { observers.add(o); }
	public void removeObserver(Observer o) { observers.remove(o); }
	public void notifyObservers() {for(Observer o : observers) o.update(기업이름, 업무내용, 연봉); }
	
	public void setJobData(String n, String t, int i)
	{
		기업이름 = n; 업무내용 = t;	연봉 = i;
		jobChanged();
	}
	public  void jobChanged() {	notifyObservers(); }
}
