package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "12345";
		int i = Integer.parseInt(s);
		
		// cf1. 반대로 (int -> String)
		String s2 = String.valueOf(i);
		
		// cf2. 반대로 (int -> String)
		String s3 = "" + i; // StringBuilder를 만들어서 toString()으로 바꾸는 방법이라고 보면 됌.
		
		System.out.println(s + ":" + s2 + ":" + s3);
		
		// Uni code 값으로 변경
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		//Ascii code 값을 찍는 법
		System.out.println((int)'A');

		// 2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		//16진수로 변경
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}

}