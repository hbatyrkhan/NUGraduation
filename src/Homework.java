import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Homework extends Assessment {
	public Homework(String name, Vector2D position, Common common, int points) {
		super(name, position, common, points);
	}
	@Override public void draw ( Graphics2D g2d )
  {
    if(!state.isVisible) return;
    Font fOriginal = g2d.getFont();
    FontMetrics fm = g2d.getFontMetrics();
    AffineTransform tOriginal = g2d.getTransform();
    String str;
    g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
    g2d.translate( (int) position.x -9, (int) position.y-9 ) ;
    g2d.setPaint( Color.GREEN);
    g2d.fillRect(0, 0, 18, 18) ;
    g2d.setPaint( Color.BLACK ) ; g2d.drawRect(0, 0, 18, 18);
    str = points + ""       ;  g2d.setPaint( Color.BLACK ) ;  g2d.drawString( str , 5,   14 ) ;
    g2d.setTransform(tOriginal);
    g2d.setFont(fOriginal);
  }
}