package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 goods2 = new Goods2();
		
		// public : 접근 제한 X
		goods2.name= "nikon";
		// protected : 같은 패키지에서 접근 가능
		// 더 중요한 것은 자식 Class에서 접근이 가능.
//		goods2.price = 400000;
		// default : 같은 패키지에서 접근 가능
//		goods2.countStock = 10;
		
		// private : 클래스 내부에서만 접근 가능 -> 따라서 여기서는 X.
		// goods2.countStock = 10;

		
//		System.out.println("상품이름:" + goods2.name); + 
//				", 가격:" + goods2.price + 
//				", 재고량:" + goods2.countStock );	
	
	}
}
