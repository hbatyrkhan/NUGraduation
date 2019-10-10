import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class ZigZag extends State {
	public ZigZag() {
		super("Zig-Zag");
	}
	@Override public void step(Entity e) {
		e.position.plus(e.speed);
		e.changeState();
	}
}