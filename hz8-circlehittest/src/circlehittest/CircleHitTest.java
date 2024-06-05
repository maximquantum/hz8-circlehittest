package circlehittest;

abstract class CircleHitTest {
	/**
	 * @pre | c != null
	 * @post Als het punt binnen de cirkel ligt, is `result` gelijk aan `true`
	 *       | !(c.centre.squareDistanceTo(p) <= c.radius * c.radius) || result == true
	 * @post Als het punt buiten de omschreven rechthoek ligt, is `result` gelijk aan `false`
	 *       | !(c.centre.x - c.radius <= p.x && p.x <= c.centre.x + c.radius &&
		     | c.centre.y - c.radius <= p.y && p.y <= c.centre.y + c.radius) || result == false
	 */
	abstract boolean containsPoint(Circle c, Point p);
}

class PreciseCircleHitTest extends CircleHitTest {
	/**
	 * @throws IllegalArgumentException | c == null
	 * @post | result == (c.centre.squareDistanceTo(p) <= c.radius * c.radius)
	 */
	
	@Override
	boolean containsPoint(Circle c, Point p) {
		return c.centre.squareDistanceTo(p) <= c.radius * c.radius;
	}
}

class FastCircleHitTest extends CircleHitTest {
	/**
	 * @pre | c != null
	 * @post | result == (c.centre.x - c.radius <= p.x && p.x <= c.centre.x + c.radius &&
			 | c.centre.y - c.radius <= p.y && p.y <= c.centre.y + c.radius)
	 */
	@Override
	boolean containsPoint(Circle c, Point p) {
		return c.centre.x - c.radius <= p.x && p.x <= c.centre.x + c.radius &&
				c.centre.y - c.radius <= p.y && p.y <= c.centre.y + c.radius;
	}
}

final class Point {
	
	int x, y;
	int squareDistanceTo(Point other) {
		return (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y);
	}

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
