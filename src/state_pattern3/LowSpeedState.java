package state_pattern3;

public class LowSpeedState implements State {
	CeilingFanPullChain chain;
	public LowSpeedState(CeilingFanPullChain chain) { this.chain = chain; }
	public void pull() {
		System.out.println("   low speed");
		chain.setState(chain.mediumSpeedState);
	}
}
