package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("some code1 ...");
		// Error : / by zero
		try {
			System.out.println("some code2 ...");
			System.out.println("some code3 ...");
			int result = a / b;
			System.out.println("some code4 ...");
			System.out.println("some code5 ...");
		}
		// 어떤 Exception을 잡을 건지 괄호 안에 적어야함.
		catch(ArithmeticException e) {
			/* 예외처리 */
			// 1. 로깅
			System.out.println("Error : " + e);
			
			// 2. 사과
			System.out.println("미안합니다.");
			
			// 3. 정상종료						
			return;
			
		} finally {
			System.out.println("자원정리 : ex) close file, close socket, close db connection");
		}
		System.out.println("some code6 ...");
		System.out.println("some code7 ...");

	}

}
