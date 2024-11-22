package com.pocodx.paint.main;

import com.pocodx.paint.i.Drawable;
import com.pocodx.paint.point.ColorPoint;
import com.pocodx.paint.point.Point;
import com.pocodx.paint.shape.Circle;
import com.pocodx.paint.shape.Rectangle;
import com.pocodx.paint.shape.Shape;
import com.pocodx.paint.shape.Triangle;
import com.pocodx.paint.text.GraphicText;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		// point1.show();
		// drawPoint(point1);
		draw(point1);
		
		
		Point point2 = new Point(100, 200);
		// point2.show(true);
		// drawPoint(point2);
		draw(point2);
		point2.show(false);
		
		ColorPoint point3 = new ColorPoint(50, 100, "red");	
//		point3.setX(50);
//		point3.setY(100);
//		point3.setColor("red");
		// drawColorPoint(point3);
		// 다형성이라는 조건이 있기 때문에 Override의 효과가 나타날 수 있음.
		// drawPoint(point3);
		draw(point3);
		
//		drawTriangle(new Triangle());
//		drawRectangle(new Rectangle());
		
		// 추상 클래스를 정의해서 Shape라는 클래스로 알아서...
//		drawShape(new Triangle());
//		drawShape(new Rectangle());
//		drawShape(new Circle());
		
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		
		draw(new GraphicText("안녕"));

		// instanceof 연산자
		Circle c = new Circle();
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		
		// 오류 발생: 연산자 우측항이 클래스인 경우 좌측 레퍼런스 타입의 Hierachy의 상하위만 사용할 수 있음.
		// System.out.println(c instanceof Rectangle);
		
		Shape s = new Circle();
		// 얘는 오류가 안나는 이유는 레퍼러스 타입이 Shape이기 때문!
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rectangle);
		
		// 연산자 우측항이 인터페이스인 경우
		// hierachy 상관없이 사용 가능
		System.out.println(s instanceof Drawable);
		System.out.println(c instanceof Runnable);
		
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//  	colorPoint.show();
//	}
	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
	
}

