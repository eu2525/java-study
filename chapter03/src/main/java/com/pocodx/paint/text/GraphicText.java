package com.pocodx.paint.text;

import com.pocodx.paint.i.Drawable;

public class GraphicText implements Drawable {
	private String text;
	
	public GraphicText(String text) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		System.out.println("테스트 '" + text + "'를 그렸습니다.");
	}

}