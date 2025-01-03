package prob02;

import java.util.Scanner;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] info = line.split(" ");
			
			goods[i] = new Goods();			
			goods[i].setName(info[0]);
			goods[i].setPrice(info[1]);
			goods[i].setCnt(info[2]);
		}
		
		// 상품 출력
		for(int i = 0; i < COUNT_GOODS; i++) {
			goods[i].printInfo();
		}
		
		scanner.close();
	}
}