package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1 = "Hello " + "World " + "Java" + 21;
		
//		String s1 = new StringBuilder("Hello ")
//						.append("World ")
//						.append("Java")
//						.append(21)
//						.toString();

		String s1 = new StringBuffer("Hello ")
				.append("World ")
				.append("Java")
				.append(21)
				.toString();
		
		System.out.println(s1);
		
//		String s2 = "";
//		for(int i = 0; i < 1000000; i++) {
//			 s2 = s2 + "h";
			// 위의 코드는 아래 코드와 동치인데, 실행을 시키면 끝나지 않음.
			// 왜냐하면 100만번의 new를 할당하고 해제하고 하는 과정에서 시간이 오래 걸리기 때문!
			// 따라서 뭔가 문자열을 반복해서 더하는 작업이 있을 경우 명시적으로 Stringbuffer 나 StringBuilder를 명시적으로 해야함.
			// s2 = new StringBuffer(s2).append("h").toString()
//		}
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			 sb.append("h");
		}
		String s3 = sb.toString();
		
		// String Method들...
		String s4 = "abcABCabcABC";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "        ab      cd    ";
		String s6 = "abc,def,ghi";
		String s7 = s5.concat(s6);
		System.out.println(s7);
		// 시작부분의 공백과 끝부분의 공백 제거
		System.out.println("---" + s5.trim() + "---");
		System.out.println("---" + s5.replaceAll(" ", "") + "---");
		
		s6.split(",");
		
		String[] tokens = s6.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
		for(String s : tokens2) {
			System.out.println(s);
		}
		
	}
}