package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p1;
		
		// == : 두 객체의 동일성;
		System.out.println(p1 == p2); // 결과 : False
		System.out.println(p1 == p3); // 결과 : True
		
		// equals : 두 객체의 동질성 (내용 비교);
		// 		  : 부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다. -> 왜냐면 사용자가 만드는 객체에 어떤 변수가 저장될지 알 수 없기 때문.
		System.out.println(p1.equals(p2)); // 
		System.out.println(p1.equals(p3)); // 결과 : True
		
		
	}

}
