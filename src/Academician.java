import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;
import java.awt.Font;

public class Academician extends Entity {
	public AssessmentFactory fac;
	public Academician(String name, String path, Common common) {
		super(name, path, common);
		fac = new AssessmentFactory(common);
		this.allStates = Arrays.asList(new ZigZag(), new GotoXY(), new Rest());
	}
	public Academician(String name, Common common) {
		super(name, common);
		fac = new AssessmentFactory(common);
	}
	public Assessment createAssessment() {
		Vector2D cur_position = new Vector2D(position.x, position.y);
		// cur_position.set(position);
		return fac.createAssessment(cur_position);
	}
	public void step() {
		if(!this.state.isOver && !this.state.toString().equals("Rest") && common.randomInt(1, 1000) < 15) common.assessments.add(createAssessment());
		this.state.step(this);
		if(this.position.x <= 35+14 || this.position.x -35 + 70 >= this.common.windowWidth) this.speed.x *= -1.0;
		if(this.position.y <= 14+45 || this.position.y -45 + 105 >= this.common.windowHeight) this.speed.y *= -1.0;
	}
	@Override public void draw(Graphics2D g2d) {
		g2d.drawImage(this.image, (int)this.position.x-35, (int)this.position.y-45, 70, 90, null);
		Font fOriginal = g2d.getFont() ;
		g2d.setPaint(Color.BLACK);
		g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
		g2d.drawString(this.name, (int)this.position.x-35, (int)this.position.y-45);
		g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 12 ) ) ;
		g2d.drawString(state.toString(), (int)this.position.x-35, (int)this.position.y-45+105);
		g2d.setFont(fOriginal);
	}
}