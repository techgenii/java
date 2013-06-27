package com.practicejava.shape;

public class Circle extends Shape{
	
	void SetShape(int x, int y) {
		super.SetShape(x, y);
	}
	
	int area(int r, int y) {
		int ret = (int)(2*(Math.PI)*r);
		return (ret);
	}
		
	void PrintShapeName(String name) {
		System.out.println("Circle Shape Name=" + name);
	}
	
	void PrintShapeArea() {
		System.out.println("Circle Area=" + area(x,y));
	}
}