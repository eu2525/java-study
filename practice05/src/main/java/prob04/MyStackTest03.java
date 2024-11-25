package prob04;

public class MyStackTest03 {
	public static void main(String[] args) {
		try {
			MyStack03<String> stack = new MyStack03<>(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			// 1을 넣고 싶으면 Object로 해야함.
			// 이전에는 런타임 때 오류가 나서 컴파일 때 오류나는지 확인할 수 없었지만, 제네릭을 이용하면 컴파일때 오류를 확인할 수 있음.
			// stack.push(1);
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack03<>(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}
	}
}
