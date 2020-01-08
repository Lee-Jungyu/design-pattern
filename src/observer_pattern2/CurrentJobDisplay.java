package observer_pattern2;

public class CurrentJobDisplay implements Observer, DisplayElement {
	private String companyName, task;
	private int annualIncome;
	private Subject jobData;
	
	public CurrentJobDisplay(Subject jobData)
	{
		this.jobData = jobData;
		jobData.registerObserver(this);
	}
	
	public void update(String n, String t, int i)
	{
		companyName = n; task = t; annualIncome = i;
		display();
	}
	
	public void display()
	{
		System.out.println("Company Name: " + companyName + "  Task: " + task + "  Annual Income: " + annualIncome);
	}
}
