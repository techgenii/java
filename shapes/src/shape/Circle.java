package shape;

public class Circle extends Shape{
	
	void SetShape(final int x, final int y) {
		super.SetShape(x, y);
	}
	
	@Override
	public int area(final int r, final int y) {
        // Area = 2 * PI * r
		return ((int)(2*(Math.PI)*r));
	}
	
	@Override
	public void PrintShapeName(final String name) {
		System.out.println("Circle Shape Name=" + name);
	}
	
	@Override
	public void PrintShapeArea() {
        System.out.println("Circle radius = " + getX());
		System.out.println("Circle Area = " + area(getX(),getY()));
        System.out.println();
	}
	
}