import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class HomeworkFactory extends AssessmentFactory {
	public HomeworkFactory(Common common) {
		super(common);
	}
	public Homework createHomework(Vector2D position) {
		return new Homework("Homework", position, common, common.randomInt(1, 3));
	}
}