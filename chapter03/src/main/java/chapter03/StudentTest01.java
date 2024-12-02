package chapter03;

public class StudentTest01 {
	
	public static void main(String[] args) {
		
		Student a = new Student();
		Person b = a;
		Animal c = b;
		
		System.out.println("Student a가 메소드를 호출합니다");
		a.a();
		a.aa();
		a.aaa();
		a.bark();
		System.out.println("###########################");

		System.out.println("Person b가 메소드를 호출합니다");
		b.a();
		b.aa();
		// b.aaa(); // 얘는 오류를 발생시킴
		b.bark();
		System.out.println("###########################");

		System.out.println("Animal c가 메소드를 호출합니다");
		c.a();
		// c.aa(); // 얘는 오류를 발생시킴.
		// c.aaa(); // 얘는 오류를 발생시킴
		c.bark();
		System.out.println("###########################");

//		Person p = new Student();
//		p.b() 는 접근이 안된다!!
//		
//		Student pp = (Student)p;
//		
//		pp.b(); // 얘는 됌!!
		
	}
}
