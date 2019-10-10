import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.Font;
import java.awt.geom.Point2D;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Entity {
	public String name;
	public Vector2D position;
	public Vector2D speed;
	public State state;
	public Common common;
	public BufferedImage image;
	public List<State> allStates;
	public int curId;
	private long lastTime;
	private long interval;
	public Entity(String name, Common common) {
		this.name = name;
		this.common = common;
		this.state = new ZigZag();
		this.position = new Vector2D((double)common.windowWidth / 2.0, (double)common.windowHeight / 2.0);
		this.speed = new Vector2D((double)common.randomInt(10, 30),
		(double)common.randomInt(10, 35));
		if(common.randomInt(1, 2) == 1) speed.x *= -1;
		if(common.randomInt(1, 2) == 1) speed.y *= -1;
		this.speed.normalize();
		this.curId = 0;
		List<Long> times = Arrays.asList((long)4e9, (long)1e10, (long)5e9, (long)20e9, (long)10e9, (long)7e9, (long)15e9);
		this.interval = times.get(common.randomInt(0, 6));
		this.lastTime = System.nanoTime();
	}
	public Entity(String name, String path, Common common) {
		this(name, common);
		try {
			this.image = ImageIO.read(new File(path));
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	public State getNextState() {
		curId = (curId + 1) % allStates.size();
		if(state.isOver) curId = 1;
		return allStates.get(curId);
	}
	public void changeState() {
		long curTime = System.nanoTime();
		if(curTime - lastTime < interval || state.isOver) return;
		if(this.state.toString().equals("Stationary")) return;
		this.lastTime = curTime;
		this.state = getNextState();
	}
	public void draw(Graphics2D g2d) {
	}
	public void step() {
	}
}