package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass(); //reflection
		System.out.println(klass); 
		// 현재 Hash Code는 부모 클래스의 해시 값인건가?
		System.out.println(point.hashCode()); // Address 기반의 Hashing 값.
											  // Address도 아니고, Reference 값도 아니다. 오해X 
		// 그래서 Point 클래스에 hashCode를 override해서 넣으면 Point 기반의 해시 값이 생성
		
		System.out.println(point.toString()); // override 안했을 때 return 결과 : 
											  // getClass().toString() + "@" + hashcode()
		
		System.out.println(point);
		
	}
	
}
