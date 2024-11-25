package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	public MyStack03(int capacity) {
		this.buffer = (T[])new Object[capacity];
		this.top = 0;
	}

	public void push(T s) {
		/* 구현하기 */
		if(buffer.length == top) {
			resize();
		}
		top += 1;
		buffer[top - 1] = s;
	}

	public T pop() throws MyStackException {
		if (top < 1) {
			throw new MyStackException();
		}
		
		T result = (T)"";
		top -= 1;	
		result = buffer[top];
		return result;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	private void resize() {
		int nowLength = buffer.length;
		T[] newBuffer = (T[])new Object[nowLength * 2];
		
		for(int i = 0; i < nowLength; i++) {
			newBuffer[i] = this.buffer[i];
		}
		
		this.buffer = newBuffer;
	}	
	
}
