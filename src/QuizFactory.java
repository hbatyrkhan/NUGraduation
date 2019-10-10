import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class QuizFactory extends AssessmentFactory {
	public QuizFactory(Common common) {
		super(common);
	}
	public Quiz createQuiz(Vector2D position) {
		return new Quiz("Quiz", position, common, common.randomInt(3, 4));
	}
}