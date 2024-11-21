package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		
//		goods.name= "nikon";
//		goods.price = 400000;
//		goods.countSold= 10;
//		goods.countStock = 20;
		// setter를 이용.
		goods.setName("nikon");
		goods.setPrice(400000);
		goods.setCountSold(10);
		goods.setCountStock(20);
		
//		System.out.println("상품이름:" + goods.name + 
//				", 가격:" + goods.price + 
//				", 판매량:" + goods.countSold + 
//				", 재고량:" + goods.countStock );	
		
		// getter를 이용
//		System.out.println("상품이름:" + goods.getName() + 
//				", 가격:" + goods.getPrice() + 
//				", 판매량:" + goods.getCountSold() + 
//				", 재고량:" + goods.getCountStock() );
		
		goods.printInfo();

		// 정보은닉(객체의 상태를 보호)
		// public으로 해두고 정보은닉을 안해서 외부에서 음수 값이 되도록 설정하는 경우가 생길 수 있음
//		goods.price = -1000;
		// 아래와 같이 하면 setPrice 안에 조건문을 설정해서 음수 값이 입력되는 걸 막을 수 있음.
		goods.setPrice(-1000);
		
		// static 변수(클래스 변수)
		Goods goods2 = new Goods();
		System.out.println(goods2.countOfGoods);
		Goods goods3 = new Goods();
		System.out.println(goods3.countOfGoods);
		
		goods.setPrice(400000);
		System.out.println(goods.calcDiscountPrice(0.5f));
		
	}
}
