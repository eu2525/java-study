package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		this.buffer = new String[capacity];
		this.top = 0;
	}

	public void push(String s) {
		/* 구현하기 */
		if(buffer.length == top) {
			resize();
		}
		top += 1;
		buffer[top - 1] = s;
	}

	public String pop() throws MyStackException {
		if (top < 1) {
			throw new MyStackException();
		}
		
		String result = "";
		top -= 1;	
		result = buffer[top];
		return result;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	private void resize() {
		int nowLength = buffer.length;
		String[] newBuffer = new String[nowLength * 2];
		
		for(int i = 0; i < nowLength; i++) {
			newBuffer[i] = this.buffer[i];
		}
		
		this.buffer = newBuffer;
	}	
	
}