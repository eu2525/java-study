package creational.singleton;

public class Singleton {
	private static Singleton instance = null;
	
	// 이렇게 만들면 밖에서 생성을 못함
	private Singleton() {
	}

	// static method는 static 변수 사용.
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
	
	
	
}
