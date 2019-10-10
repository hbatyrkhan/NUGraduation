import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class Student extends Entity {
	public int grade;
	public Student(String name, Common common) {
		super(name, common);
    this.grade = 0;
    this.allStates = Arrays.asList(new ZigZag(), new GotoXY(), new Rest(), new Closest());
	}
	@Override public void draw ( Graphics2D g2d )
  {
    Font fOriginal = g2d.getFont();
    FontMetrics fm = g2d.getFontMetrics();
    AffineTransform tOriginal = g2d.getTransform();
    String str;
    g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
    g2d.translate( (int) position.x , (int) position.y ) ;
    if( grade >= 100 ) {
      g2d.setPaint( Color.MAGENTA);
    } else {
      g2d.setPaint( Color.CYAN);
    }
    g2d.fillOval( -15 , -15 , 30 , 30 ) ;
    g2d.setPaint( Color.BLACK ) ; g2d.drawOval( -15 , -15 , 30 , 30 ) ;
    str = name             ;  g2d.setPaint( Color.BLACK ) ;  g2d.drawString( str , (int) (-fm.stringWidth(str) / 2.0) + 1 , -18 ) ;
    str = grade + ""       ;  g2d.setPaint( Color.BLACK ) ;  g2d.drawString( str , (int) (-fm.stringWidth(str) / 2.0) + 1 ,   6 ) ;
    g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 12 ) ) ;
    str = state.toString() ;  g2d.setPaint( Color.BLACK ) ;  g2d.drawString( str , (int) (-fm.stringWidth(str) / 2.0) + 1 ,  30 ) ;
    g2d.setTransform(tOriginal);
    g2d.setFont(fOriginal);
  }
  @Override public void step() {
    this.state.step(this);
    for(Assessment a: common.assessments) {
      if(!a.state.isVisible) continue;
      if(position.distanceTo(a.position) <= 25.0) {
        grade += a.points;
        a.state.isVisible = false;
      }
    }
    if(grade >= 100 && !this.state.isOver) {
      this.state = new GotoXY();
      this.state.isOver = true;
    }
		if(this.position.x <= 20 || this.position.x + 32 >= this.common.windowWidth) this.speed.x *= -1.0;
		if(this.position.y <= 25 || this.position.y + 32 >= this.common.windowHeight) this.speed.y *= -1.0;
	}
}