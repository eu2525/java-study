package prob04;

@SuppressWarnings("serial")
public class MyStackException extends Exception {
	
	public MyStackException() {
		super("Stack is Empty");	
	}
	
	public MyStackException(String message) {
		super(message);
	}
}
