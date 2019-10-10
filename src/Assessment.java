import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Assessment extends Entity {
	public int points;
	public Assessment(String name, Vector2D position, Common common, int points) {
		super(name, common);
		this.position = position;
		this.points = points;
    this.speed.x = 0;
    this.speed.y = 0;
	}
	@Override public void draw ( Graphics2D g2d )
  {
    Font fOriginal = g2d.getFont();
    FontMetrics fm = g2d.getFontMetrics();
    AffineTransform tOriginal = g2d.getTransform();
    String str;
    g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
    g2d.translate( (int) position.x , (int) position.y ) ;
    g2d.setPaint( Color.RED);
    g2d.fillOval( -15 , -15 , 20 , 20 ) ;
    g2d.setPaint( Color.BLACK ) ; g2d.drawOval( -15 , -15 , 20 , 20 ) ;
    str = name             ;  g2d.setPaint( Color.BLACK ) ;  g2d.drawString( str , (int) (-fm.stringWidth(str) / 2.0) + 1 , -18 ) ;
    str = points + ""       ;  g2d.setPaint( Color.BLACK ) ;  g2d.drawString( str , -10,   0 ) ;
    g2d.setTransform(tOriginal);
    g2d.setFont(fOriginal);
  }
}