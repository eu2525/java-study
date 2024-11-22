package com.pocodx.paint.shape;

import com.pocodx.paint.i.Drawable;
import com.pocodx.paint.point.Point;

// abastract로 추상 Class를 정의
public abstract class Shape implements Drawable {
	private Point[] points;
	private String lineColor;
	private String fillColor;

	public abstract void draw();

}
