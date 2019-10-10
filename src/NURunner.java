import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.LinkedList ;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NURunner {
	public JFrame window;
	public Display display;
	public Common common;
	private NURunner(String mapPath, int windowWidth, int windowHeight) {
		this.window = new JFrame();
		this.common = new Common(mapPath, windowWidth, windowHeight);
		this.display = new Display(this.common);
		this.window.add(this.display);
		this.window.setTitle("NU Graduation");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setResizable(false);
		this.window.pack();
		this.window.setVisible(true);
	}
	public static void main(String[] args) {
		int windowWidth = 1200, windowHeight = 700;
		final NURunner runner = new NURunner("../NUMap-Faded.jpg", windowWidth, windowHeight);
		Timer timer = new Timer(10, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
						runner.common.stepAllEntities();
						runner.display.repaint();
				}
		});
		timer.start();
	}
}