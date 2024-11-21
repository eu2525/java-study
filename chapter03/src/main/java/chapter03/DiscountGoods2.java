package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
//	long l = 11123456789L;
	private float discountRate = 0.5f;
	
	public float getDiscountPirce() {
		// protected는 자식에서 접근이 가능.
		return discountRate * price;
	}
	
}
