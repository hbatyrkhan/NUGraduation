import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class State {
	public boolean isOver = false;
	public boolean isVisible = true;
	public String state_name;
	public List<State> all;
	public State(String state_name) {
		this.state_name = state_name;
	}
	public void step(Entity e) {
		
	}
	public void set(Vector2D v) {

	}
	public String toString() {
		return state_name;
	}
}