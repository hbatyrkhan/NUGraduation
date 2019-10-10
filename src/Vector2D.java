import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class Vector2D {
	public double x;
	public double y;
	public Vector2D() {
		x = 0;
		y = 0;
	}
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void set(Vector2D v) {
		x = v.x;
		y = v.y;
	}
	public double distanceTo(Vector2D other) {
		return Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));
	}
	public double len() {
		return Math.sqrt(x * x + y * y);
	}
	public Vector2D normalize() {
		double temp = len();
		x /= temp;
		y /= temp;
		return this;
	}
	public Vector2D plus(Vector2D other) {
		x += other.x;
		y += other.y;
		return this;
	}
	public Vector2D minus(Vector2D other) {
		x -= other.x;
		y -= other.y;
		return this;
	}
}