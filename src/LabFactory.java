import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class LabFactory extends AssessmentFactory {
	public LabFactory(Common common) {
		super(common);
	}
	public Lab createLab(Vector2D position) {
		return new Lab("Lab", position, common, common.randomInt(2, 4));
	}
}