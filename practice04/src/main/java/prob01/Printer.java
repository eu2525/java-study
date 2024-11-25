package prob01;

public class Printer {
/*
	// 함수 오버로딩 문제
	public void println(int num) {
		System.out.println(num);
	}
	public void println(boolean boo) {
		System.out.println(boo);
	}
	public void println(double num) {
		System.out.println(num);
	}
	public void println(String noun) {
		System.out.println(noun);
	}
*/
	// 제네릭
	public <T> void println(T t) {
		System.out.println(t);
	}

	// 제네릭 + 가변 파라미터
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t + " ");			
		}
		System.out.println();
	}
	
	// 가변 파라미터
	public int sum(Integer... nums) {
		// 입력 값을 배열로 받아 줌.
		int s = 0;
		for(int n : nums) {
			s += n;
		}
		return s;
	}	
}
