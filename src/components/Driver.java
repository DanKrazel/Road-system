package components;

import gui.BigBrother;

public class Driver {
	private BigBrother Big;
	
	public Driver() {
		setBig(BigBrother.getInstance());
	}

	public BigBrother getBig() {
		return Big;
	}

	public void setBig(BigBrother big) {
		Big = big;
	}
	
}
