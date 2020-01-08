package state_pattern3;

class CeilingFanPullChain {
	private State m_current_state;
	LowSpeedState lowSpeedState = new LowSpeedState(this);
	MediumSpeedState mediumSpeedState = new MediumSpeedState(this);
	HighSpeedState highSpeedState = new HighSpeedState(this);
	TurningOffState turningOffState = new TurningOffState(this);

	public CeilingFanPullChain() { m_current_state = lowSpeedState; }

	public void pull() {
		m_current_state.pull();
	}
	
	public void setState(State s) {
		m_current_state = s;
	}
	
}