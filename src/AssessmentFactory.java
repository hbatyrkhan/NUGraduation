import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.* ;
import javax.imageio.*      ;

public class AssessmentFactory {
	public Common common;
	public AssessmentFactory(Common common) {
		this.common = common;
	}
	public Assessment createAssessment(Vector2D position) {
		LabFactory lab = new LabFactory(common);
		QuizFactory quiz = new QuizFactory(common);
		HomeworkFactory homework = new HomeworkFactory(common);
		List<Assessment> take = Arrays.asList(lab.createLab(position),
		quiz.createQuiz(position), homework.createHomework(position));
		return take.get(common.randomInt(1, 3) - 1);
	}
}