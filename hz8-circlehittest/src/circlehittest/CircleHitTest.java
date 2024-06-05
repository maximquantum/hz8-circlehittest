package circlehittest;

abstract class CircleHitTest {
	
	abstract boolean containsPoint(Circle c, Point p);
}

class PreciseCircleHitTest extends CircleHitTest {
	
	boolean containsPoint(Circle c, Point p) {
		if ( Math.sqrt((p.x - c.centre.x)^2 + (p.x - c.centre.x)^2) == c.radius)
			return true;
		else
			return false;
	}
}

class FastCircleHitTest extends CircleHitTest {
	
	/**
	 * 
	 */
	boolean containsPoint(Circle c, Point p) {
		if ( Math.abs(p.x - c.centre.x) <= c.radius && Math.abs(p.y - c.centre.y) <= c.radius)
			return true;
		else
			return false;
	}
}

final class Point {
	
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

}

final class Circle {
	
	Point centre;
	int radius;

	public Circle(Point centre, int radius) {
		this.centre = centre;
		this.radius = radius;
		
	}
}
