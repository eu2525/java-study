package chapter03;

public class Goods {
	// static의 의미 : 객체를 생성하지 않고도 '클래스이름.메소드명' 으로 호출이 가능해짐.
	public static int countOfGoods = 0;

	private String name;
	private int price;
	private int countStock;
	private int countSold;	
	
	// 생성자
	public Goods() {
		// static 변수는 Class 내부에서 Class 이름을 생략 가능!
		countOfGoods++;
	}
	
	// 객체에 값을 세팅할 때는 특정 규약(Bean 규약)을 따라야함.
	// setter(setField), getter(getField) ...를 따라야한다. 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price <= 0) {
			price = 0;
		}
		
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public void printInfo() {
		// self reference를 하기 위해서 this라는 키워드를 이용 (Python의 self 같은 거인듯) 
		// this를 안써도 큰 문제는 없지만, 구분하기 위해서 this를 이용 (parameter 변수명과 instance 변수가 이름이 동일할 수 있어서)
		System.out.println("상품이름:" + name + 
				", 가격:" + price + 
				", 판매량:" + countSold + 
				", 재고량:" + countStock );	
	}
	public int calcDiscountPrice(float discountRate) {
		// int result; 로 선언하면 result가 쓰레기 값을 가질 수 있음
		int result = price - (int)(price * discountRate);
		
		return result;
	}
	
}
