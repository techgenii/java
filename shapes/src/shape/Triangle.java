package shape;

public class Triangle extends Shape{
	
		void SetShape( final int x, final int y ) {
			super.SetShape(x, y);
		}
	
		@Override
		public int area(final int x, final int y) {
			return ((x*y)/2);
		}
	
		@Override
		public void PrintShapeName( final String name ) {
			System.out.println("Triangle Shape Name=" + name);
		}
		
		@Override
		public void PrintShapeArea() {
            System.out.println("Triangle base length = " + getX());
            System.out.println("Triangle height = " + getY());
			System.out.println("Triangle Area=" + area(getX(),getY()));
            System.out.println();
		}
		
}