package shape;

import java.text.MessageFormat;

public class Rectangle extends Shape {
	
	    void SetShape(final int x, final int y) {
		    super.SetShape(x, y);
	    }
	
	    @Override
		public int area(final int x, final int y) {
			return (x*y);
		}
		
		@Override
		public void PrintShapeName(final String name) {
			System.out.println("Rectangle Shape Name=" + name);
		}
	
		@Override
		public void PrintShapeArea() {
            System.out.println("Rectangle length = " + getX());
            System.out.println("Rectangle width = " + getY());
			System.out.println(MessageFormat.format("Rectangle Area = {0}", area(getX(), getY())));
            System.out.println();
		}
}
