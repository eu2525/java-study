package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		Person p1 = s1; 	// Upcasting : 암시적
		// Student s2 = p1; 	// Downcasting : 아래와 같이 명시적으로 Type을 적어줘야 오류가 발생하지 않음
		Student s2 = (Student)p1; 
			
	}
}
