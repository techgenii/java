package shape;

import shape.Rectangle;
import shape.Circle;
import shape.Triangle;

public class ShapesMain {

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
