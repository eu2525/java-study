package prob06;

public class Sub {
	private int lValue;
	private int rValue;
	
	public Sub() {
		this.lValue = 0;
		this.rValue = 0;
	}
	
	public void setValue(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public int calculate() {
		return lValue - rValue;
	}
	
}