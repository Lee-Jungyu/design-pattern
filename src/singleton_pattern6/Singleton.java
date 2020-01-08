package singleton_pattern6;

public class Singleton {
	private volatile static Singleton[] uniqueInstance = new Singleton[5];
	static int cnt = 0;
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (cnt < 5) {
			synchronized (Singleton.class) {
				if (cnt < 5) {
					uniqueInstance[cnt] = new Singleton();
					cnt++;
					System.out.println("count: " + cnt);
					return uniqueInstance[cnt - 1];
				}
				else {
					System.out.println("max is 5");;
					return null;
				}
			}
		}
		else {
			System.out.println("max is 5");
			return null;
		}
	}
}