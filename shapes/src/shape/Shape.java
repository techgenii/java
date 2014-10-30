package shape;

	
public abstract class Shape{
		private int x;
		private int y;

		void SetShape(final int x, final int y) {
			this.x = x;
			this.y = y;
		}
		
		int getX() { return x; }
		int getY() { return y; }
		
		public abstract int area(final int x, final int y);
		
		public abstract void PrintShapeName(final String name);
		
		public abstract void PrintShapeArea();

}
