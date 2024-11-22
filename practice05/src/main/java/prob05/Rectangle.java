package prob05;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(int x, int y) {
		this.width = x;
		this.height = y;
	}

	@Override
	protected double getArea() {
		return width * height;
	}

	@Override
	protected double getPerimeter() {
		return (width + height) * 2;
	}

	@Override
	public void resize(double d) {
		this.width *= d;
		this.height *= d;
	}

}
