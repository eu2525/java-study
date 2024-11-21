package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		// StaticMethod.m = 10;
		
		// 같은 Class의 static 변수 접근에서 클래스 이름 생략 가능
		m = 20;
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		// StaticMethod.s1();
	
		// 같은 Class의 static 변수 접근에서 클래스 이름 생략 가능
		s1();
	}
	
	static void s1() {
		// 어떤 n을 호출하는지 static 함수에서는 알 수 없기 때문에 error가 발생함.
		// error : static method에서는 instance 변수 접근 불가.
		// n = 10;
	}
	
	static void s2() {
		// error : static method에서는 instance 메소드 접근 불가.
		// f1();
	}
	
	static void s3() {
		// 같은 Class의 static 변수 접근에서 클래스 이름 생략 가능
		// StaticMethod.m = 10;
		m = 20;
	}

	static void s4() {
		// 같은 Class의 static 변수 접근에서 클래스 이름 생략 가능
		// StaticMethod.s1();
		s1();
	}

}

