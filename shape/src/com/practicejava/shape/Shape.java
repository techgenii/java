package com.practicejava.shape;

	
public abstract class Shape{
		int x;
		int y;

		void SetShape(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int getX() { return x; }
		int getY() { return y; }
		
		int area(int x, int y) {
			return 1;
		}
		
		void PrintShapeName(String name) {
			System.out.println("Shape Name=" + name);
		}
		
		void PrintShapeArea() {
			System.out.println("Area=" + area(x,y));
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		Circle c = new Circle();
		
		r.SetShape(1, 2);
		r.PrintShapeArea();
		
		t.SetShape(1, 2);
		t.PrintShapeArea();
		
		c.SetShape(1, 2);
		c.PrintShapeArea();
		
		

	}

}
