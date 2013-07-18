package com.practicejava.shape;

import java.text.MessageFormat;

public class Circle extends Shape{
	
	void SetShape(int x, int y) {
		super.SetShape(x, y);
	}
	
	int area(int r, int y) {
        // Area = 2 * PI * r
		int ret = (int)(2*(Math.PI)*r);
		return (ret);
	}
		
	void PrintShapeName(String name) {
		System.out.println("Circle Shape Name=" + name);
	}
	
	void PrintShapeArea() {
        System.out.println("Circle radius = " + getX());
		System.out.println("Circle Area = " + area(x,y));
        System.out.println();
	}
}