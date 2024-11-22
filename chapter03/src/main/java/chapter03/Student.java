package chapter03;

public class Student extends Person {
	public Student() {
		// 아래 명령어가 생략되어도 자식 클래스의 기본 생성자는 부모 클래스의 기본 생성자를 자동으로 호출함.
		// super();
		System.out.println("Student() called");
	}
}
