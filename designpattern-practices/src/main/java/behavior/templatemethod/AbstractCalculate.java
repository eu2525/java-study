package behavior.templatemethod;

import java.util.Scanner;

public abstract class AbstractCalculate {
	public void templateMethod() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(val1, val2) > ");
		int val1 = scanner.nextInt();
		int val2 = scanner.nextInt();
		// 구체적인 구현을 자식에서 진행!
		int result = calculate(val1, val2);
		
		System.out.println(result);
	}

	protected abstract int calculate(int val1, int val2) ;
}
