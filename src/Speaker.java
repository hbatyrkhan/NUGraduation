import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.Font;

public class Speaker extends Entity {
	public Speaker(String name, String path, Common common, Vector2D position) {
		super(name, path, common);
		this.state = new Stationary();
		this.state.isVisible = false;
		this.position = position;
	}
	@Override public void draw(Graphics2D g2d) {
		if(!state.isVisible) return;
		g2d.drawImage(this.image, (int)this.position.x-35, (int)this.position.y-45, 70, 90, null);
		Font fOriginal = g2d.getFont() ;
		g2d.setPaint(Color.BLACK);
		g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
		g2d.drawString(this.name, (int)this.position.x-35, (int)this.position.y-45);
		g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 12 ) ) ;
		g2d.drawString(state.toString(), (int)this.position.x-35, (int)this.position.y-45+105);
		if(name.equals("Nazarbayev")) {
			g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
			g2d.drawString("Graduation Ceremony", (int)this.position.x+35, (int)this.position.y-45+105+20);
		}
		g2d.setFont(fOriginal);
	}
}