package state_pattern3;

public class TurningOffState implements State {
	CeilingFanPullChain chain;
	public TurningOffState(CeilingFanPullChain chain) { this.chain = chain; }
	public void pull() {
		System.out.println("   turning off");
		chain.setState(chain.lowSpeedState);
	}
}
