package prob02;

public class Duck extends Bird {

	@Override
	protected void fly() {
		System.out.println("오리(꽥꽥이)가 날지 않습니다.");
	}

	@Override
	protected void sing() {
		System.out.println("오리(꽥꽥이)가 소리내어 웁니다.");
	}
	
	public String toString() {
		return "오리의 이름은 꽥꽥이 입니다.";
	}

}
