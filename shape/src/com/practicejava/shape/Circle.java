package com.practicejava.shape;

import java.text.MessageFormat;

public class Circle extends Shape{
	
	void SetShape(final int x, final int y) {
		super.SetShape(x, y);
	}
	
	int area(final int r, final int y) {
        // Area = 2 * PI * r
		return ((int)(2*(Math.PI)*r));
	}
		
	void PrintShapeName(final String name) {
		System.out.println("Circle Shape Name=" + name);
	}
	
	void PrintShapeArea() {
        System.out.println("Circle radius = " + getX());
		System.out.println("Circle Area = " + area(x,y));
        System.out.println();
	}
}