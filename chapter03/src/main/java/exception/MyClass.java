package exception;

import java.io.IOException;

public class MyClass {
	
	public void danger() throws IOException, MyException {
		System.out.println("some code1... ");
		System.out.println("some code2... ");
		
		if(1 - 1 == 0) {
			throw new MyException();
		}
		
		// Exception을 던지는 구문이 있으면 함수 이름에 throws IOException을 적어줘야한다.
		if (2 - 2 == 0) {
			throw new IOException();
		}
	
		System.out.println("some code3... ");
		System.out.println("some code4... ");
		
	}
}

