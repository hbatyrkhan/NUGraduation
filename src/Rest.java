import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class Rest extends State {
	public Rest() {
		super("Rest");
	}
	@Override public void step(Entity e) {
		e.changeState();
	}
}