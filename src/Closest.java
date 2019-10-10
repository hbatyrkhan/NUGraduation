import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class Closest extends State {
	public Vector2D gotoPos;
	public Closest() {
		super("Closest");
		gotoPos = new Vector2D();
	}
	private void getClosest(Entity e) {
		double dist = -1.0;
		Assessment opt = null;
		for(Assessment a: e.common.assessments) {
			if(!a.state.isVisible) continue;
			double temp = e.position.distanceTo(a.position);
			if(dist == -1.0 || temp < dist) {
				dist = temp;
				opt = a;
			}
		}
		if(opt != null) {
			set(opt.position); 
		}
	}
	@Override public void step(Entity e) {
		getClosest(e);
		if(e.position.x < gotoPos.x) e.position.x += Math.abs(e.speed.x);
		else if(e.position.x > gotoPos.x) e.position.x -= Math.abs(e.speed.y);
		if(e.position.y > gotoPos.y) e.position.y -= Math.abs(e.speed.y);
		else if(e.position.y < gotoPos.y) e.position.y += Math.abs(e.speed.y);
		e.changeState();
	}
	@Override public void set(Vector2D v) {
		gotoPos.x = v.x;
		gotoPos.y = v.y;
	}
}