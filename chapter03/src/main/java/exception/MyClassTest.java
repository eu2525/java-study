package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		try {
			new MyClass().danger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error:" + e);
		}
		
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("error:" + e);
//		} catch (MyException e) {
//			// TODO Auto-generated catch block
//			System.out.println("error:" + e);
//		}

	}

}
