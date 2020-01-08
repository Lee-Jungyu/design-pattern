package state_pattern3;

public class HighSpeedState implements State {
	CeilingFanPullChain chain;
	public HighSpeedState(CeilingFanPullChain chain) { this.chain = chain; }
	public void pull() {
		System.out.println("   high speed");
		chain.setState(chain.turningOffState);
	}
}
