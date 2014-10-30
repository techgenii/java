package com.practicejava.shape;

	
public abstract class Shape{
		private int x;
		private int y;

		void SetShape(final int x, final int y) {
			this.x = x;
			this.y = y;
		}
		
		int getX() { return x; }
		int getY() { return y; }
		
		int area(final int x, final int y) {
			return 1;
		}
		
		public abstract void PrintShapeName(final String name) {
		}
		
		public abstract void PrintShapeArea() {
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
