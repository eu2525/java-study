package prob04;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	public MyStack02(int capacity) {
		this.buffer = new String[capacity];
		this.top = 0;
	}

	public void push(Object s) {
		/* 구현하기 */
		if(buffer.length == top) {
			resize();
		}
		top += 1;
		buffer[top - 1] = s;
	}

	public Object pop() throws MyStackException {
		if (top < 1) {
			throw new MyStackException();
		}
		
		Object result = "";
		top -= 1;	
		result = buffer[top];
		return result;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	private void resize() {
		int nowLength = buffer.length;
		Object[] newBuffer = new String[nowLength * 2];
		
		for(int i = 0; i < nowLength; i++) {
			newBuffer[i] = this.buffer[i];
		}
		
		this.buffer = newBuffer;
	}	
	
}