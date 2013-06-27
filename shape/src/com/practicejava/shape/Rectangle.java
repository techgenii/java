package com.practicejava.shape;

public class Rectangle extends Shape{
	
	void SetShape(int x, int y) {
		super.SetShape(x, y);
	}
	
		int area(int x, int y) {
			return (x*y);
		}
		
		void PrintShapeName(String name) {
			System.out.println("Rectangle Shape Name=" + name);
		}
		
		void PrintShapeArea() {
			System.out.println("Rectangle Area=" + area(x,y));
		}
}
