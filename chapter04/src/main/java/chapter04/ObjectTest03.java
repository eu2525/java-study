package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1 == s2); 		// False
		System.out.println(s1.equals(s2));  // True 
		System.out.println(s1.hashCode() + ":" + s2.hashCode()); // 동일! (Hashcode는 내용을 기반으로 만듬) 
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2)); // 다름

		
		System.out.println("=========================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s4); 		// True
		System.out.println(s3.equals(s4));  // True 
		System.out.println(s3.hashCode() + ":" + s4.hashCode()); // 동일! (Hashcode는 내용을 기반으로 만듬) 
		// 주소 기반의 해쉬 값을 확인해보기
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4)); // 같음
		
		
		System.out.println("=========================");
		
		int i1 = 1;
		int i2 = 1;
		System.out.println(i1 == i2); 		// True
		System.out.println(System.identityHashCode(i1) + ":" + System.identityHashCode(i2)); // 같음
		i1 += 1 ;
		System.out.println(i1 == i2); 		// False
		System.out.println(System.identityHashCode(i1) + ":" + System.identityHashCode(i2)); // 같음

	}

}
