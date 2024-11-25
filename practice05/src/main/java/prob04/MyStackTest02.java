package prob04;

public class MyStackTest02 {

	public static void main(String[] args) {
		try {
			MyStack02 stack = new MyStack02(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			// java 값을 넣을 때 현재 사이즈를 resizing 하는게 중요. 
			// stack.push(1);
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = (String)stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack02(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}
	}
}
