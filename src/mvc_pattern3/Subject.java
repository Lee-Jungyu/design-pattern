package mvc_pattern3;

public interface Subject {
	public void registerObservers(Observer o);
	public void removeObservers(Observer o);
	public void notifyObservers();
}