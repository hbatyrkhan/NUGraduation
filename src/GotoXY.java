import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class GotoXY extends State {
	public Vector2D gotoPos = null;
	public GotoXY() {
		super("GotoXY");
	}
	private Vector2D getRandomVector(Entity e) {

		Vector2D temp = null;
		if(!isOver) {
			temp = new Vector2D(e.common.randomInt(25, e.common.windowWidth-25),
				e.common.randomInt(45, e.common.windowHeight-45));
		} else {
			temp = new Vector2D(840, 580);
		}
		return temp;
	}
	@Override public void step(Entity e) {
		if(gotoPos == null || (!isOver && e.position.distanceTo(gotoPos) < 4)) getXY(e);
		if(e.position.distanceTo(gotoPos) > 1) {
			if(e.position.x + Math.abs(e.speed.x) < gotoPos.x) e.position.x += Math.abs(e.speed.x);
			else if(e.position.x - Math.abs(e.speed.x) > gotoPos.x) e.position.x -= Math.abs(e.speed.y);
			if(e.position.y - Math.abs(e.speed.y) > gotoPos.y) e.position.y -= Math.abs(e.speed.y);
			else if(e.position.y + Math.abs(e.speed.y) < gotoPos.y) e.position.y += Math.abs(e.speed.y);
		}
		e.changeState();
	}
	public void getXY(Entity e) {
		set(getRandomVector(e));
	}
	@Override public void set(Vector2D v) {
		gotoPos = v;
	}
}