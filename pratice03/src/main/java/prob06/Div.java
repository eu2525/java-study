package prob06;

public class Div {
	private int lValue;
	private int rValue;
	
	public Div() {
		this.lValue = 1;
		this.rValue = 1;
	}
	
	public void setValue(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public int calculate() {
		return lValue / rValue;
	}

}
