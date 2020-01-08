package observer_pattern2;

public class JobSite {
	public static void main(String[] args)
	{
		JobData jobData = new JobData();
		
		CurrentJobDisplay currentDisplay = new CurrentJobDisplay(jobData);
		
		jobData.setJobData("삼성전자", "네트워크 사업부", 5000);
		jobData.setJobData("LG전자", "디스플레이 사업부", 4500);
		jobData.setJobData("금오공대", "사무직", 2500);
	}
}
