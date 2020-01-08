package state_pattern3;

public class MediumSpeedState implements State{
	CeilingFanPullChain chain;
	public MediumSpeedState(CeilingFanPullChain chain) { this.chain = chain; }
	public void pull() {
		System.out.println("   medium speed");
		chain.setState(chain.highSpeedState);
	}
}
