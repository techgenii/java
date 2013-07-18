package com.practicejava.shape;

import java.text.MessageFormat;

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
            System.out.println("Rectangle length = " + getX());
            System.out.println("Rectangle width = " + getY());
			System.out.println(MessageFormat.format("Rectangle Area = {0}", area(x, y)));
            System.out.println();
		}
}
