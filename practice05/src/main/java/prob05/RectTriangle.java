package prob05;

public class RectTriangle extends Shape {

	public RectTriangle(int x, int y) {
		this.width = x;
		this.height = y;
	}
	
	@Override
	protected double getArea() {
		return width * height * 0.5;
	}

	@Override
	protected double getPerimeter() {
		return width + height + Math.sqrt(width * width + height * height);
	}

}
