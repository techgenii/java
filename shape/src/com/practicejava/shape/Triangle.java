package com.practicejava.shape;

public class Triangle extends Shape{
	
		void SetShape(int x, int y) {
			super.SetShape(x, y);
		}
	
		int area(int x, int y) {
			return ((x*y)/2);
		}
	
		void PrintShapeName(String name) {
			System.out.println("Triangle Shape Name=" + name);
		}
		
		void PrintShapeArea() {
			System.out.println("Tirangle Area=" + area(x,y));
		}
		
}