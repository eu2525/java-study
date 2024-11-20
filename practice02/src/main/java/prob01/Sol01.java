package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		// final이면 불변한다는 뜻 -> 항상 같은 값을 가짐 const랑 동일한 의미 Class, 변수 등 다양하게 사용할 수 있음
		// 아래와 같이 final 변수의 값을 바꾸려고 하면 오류가 발생함 -> 더 이상 확장시키려고 하지 말아라!
		// final int i = 10;   i = 20;
		
		// int[] as = new int[5];
		// int[] as = {10, 20, 30, 40};
		// int[] as = new int[] {10,20,30,40} 도 가능
		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		System.out.print("금액:");
		int num = scanner.nextInt();
		
		
		for(int i = 0; i < MONEYS.length; i++) {
			int money =  MONEYS[i];
			int cnt = num / money;
			System.out.println(money + "원 : "  + cnt + "개");
			num %= money;
		}
		
		
		scanner.close();
 	}
}