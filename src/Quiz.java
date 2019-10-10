import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Quiz extends Assessment {
	public Quiz(String name, Vector2D position, Common common, int points) {
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
    g2d.translate( (int) position.x-10, (int) position.y-10) ;
    g2d.setPaint( Color.BLUE);
    g2d.fillPolygon(new int[] {0, 10, 20}, new int[] {25, 0, 25}, 3) ;
    g2d.setPaint( Color.BLACK ) ; g2d.drawPolygon(new int[] {0, 10, 20}, new int[] {25, 0, 25}, 3);
    str = points + ""       ;  g2d.setPaint( Color.WHITE ) ;  g2d.drawString( str , 5,   20 ) ;
    g2d.setTransform(tOriginal);
    g2d.setFont(fOriginal);
  }
}