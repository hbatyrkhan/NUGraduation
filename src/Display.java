import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Display extends JPanel {
	public Common common;
	public Display(Common common) {
		this.common = common;
	}
	public Dimension getPreferredSize() {
		return new Dimension(common.windowWidth, common.windowHeight);
	}
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.common.map.image, 0, 0, getWidth(), getHeight(), null);
		this.common.drawAllEntities(g2d);
	}
}