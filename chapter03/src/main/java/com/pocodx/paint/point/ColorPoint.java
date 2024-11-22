package com.pocodx.paint.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
		// x가 private이기 때문에 아래와 같이 호출 불가능
		// this.x = x;
		
		// 방법 1) Library 이용
//		setX(x);
//		setY(y);
//		this.color = color;
		// 방법 2) 상속받았으니깐 부모의 기본 생성자에 넣기.
		super(x, y);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void show() {
		System.out.println("Point[x="+ getX() + ", y=" + getY() + ", color=" + color + "]를 그렸습니다.");
	}

	@Override
	public void draw() {
		show();
	}
	

}
