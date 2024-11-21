package prob02;

public class Goods {
	private String name;
	private String price;
	private String cnt;
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public void printInfo() {
		System.out.println(this.name +
				"(가격:" + this.price + "원)이 " +
				this.cnt +"개 입고 되었습니다."
				);
	}
}