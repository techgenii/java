package com.practicejava.shape;

public class Triangle extends Shape{
	
		void SetShape( final int x, final int y ) {
			super.SetShape(x, y);
		}
	
		int area(final int x, final int y) {
			return ((x*y)/2);
		}
	
		void PrintShapeName( final String name ) {
			System.out.println("Triangle Shape Name=" + name);
		}
		
		void PrintShapeArea() {
            System.out.println("Triangle length = " + getX());
            System.out.println("Triangle = " + getY());
			System.out.println("Triangle Area=" + area(x,y));
            System.out.println();
		}
		
}