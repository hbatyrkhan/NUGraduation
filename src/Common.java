import javax.swing.*        ;
import java.awt.Color       ;
import java.awt.Graphics    ;
import java.awt.Dimension   ;
import java.awt.Graphics2D  ;
import java.util.*          ;
import javax.imageio.*      ;
import java.awt.image.*     ;
import java.util.concurrent.ThreadLocalRandom;

public class Common {
	public int windowWidth;
	public int windowHeight;
	public UniversityMap map;
	public List<Academician> academicians;
	public List<Speaker> speakers;
	public List<Student> students;
	public List<Assessment> assessments;
	private final String [] csci235StudentNames =
  {
    "Abay" , "Abilda" , "Abilkhaiyr" , "Ablan" , "Abylaikhan" , "Adil" , "Adilzhan" , "Adlet" , "Aidana" , "Aidyn" , "Aigerim" , "Aisana" ,
    "Akhmed" , "Akmyrza" , "Alan" , "Aldamzhar" , "Alexandra" , "Ali" , "Alibek" , "Alim" , "Alisher" , "Allan" , "Altair" , "Altynay" ,
    "Altynbek" , "Amangeldy" , "Amina" , "Anel" , "Angsar" , "Anuar" , "Ardan" , "Arman" , "Askhat" , "Assanali" , "Assem" , "Ayazhan" ,
    "Azamat" , "Azizkhan" , "Bagdat" , "Baglan" , "Bakdaulet" , "Bakdauren" , "Bakyt" , "Batyrbek" , "Batyrkhan" , "Bauyrzhan" , "Beibarys" ,
    "Bekzat" , "Bota" , "Damir" , "Dana" , "Danel" , "Daniyar" , "Darina" , "Dastan" , "Daulet" , "Dauren" , "Dnislam" , "Dulat" , "Eldar" ,
    "Emir" , "Galym" , "Gulnaz" , "Islam" , "Kamila" , "Kamilla" , "Karim" , "Kassym" , "Khadisha" , "Khafiz" , "Kuanysh" , "Kyran" , "Madi" ,
    "Madiyar" , "Magzhan" , "Makhambet" , "Mansur" , "Margulan" , "Maxim" , "Medet" , "Meirzhan" , "Miras" , "Mokhira" , "Murat" , "Nargiza" ,
    "Nartay" , "Nuradil" , "Nurbolat" , "Nurdaulet" , "Nurlan" , "Nursultan" , "Nurtileu" , "Olzhas" , "Rabbani" , "Raiymbek" , "Rakhat" ,
    "Ramazan" , "Ramilya" , "Rauan" , "Rollan" , "Rustem" , "Sabyr" , "Sagi" , "Saidgaffor" , "Saken" , "Salavat" , "Sandugash" , "Sanzhar" ,
    "Shapagat" , "Sherkhan" , "Shynggys" , "Shyngys" , "Tatyana" , "Temirlan" , "Temirzhan" , "Timur" , "Togzhan" , "Tomiris" , "Turgankhan" ,
    "Vladislav" , "Yeldos" , "Yerkali" , "Yerkhan" , "Yermek" , "Yernar" , "Yerzhan" , "Yussup" , "Zarina" , "Zhalgas" , "Zhanarys" , "Zhandos" ,
    "Zhangeldi" , "Zhannur" , "Zhansaya" , "Zhassulan" , "Zhibek" , "Zhuldyz"
  } ;
	public Common(String mapPath, int windowWidth, int windowHeight) {
		this.map = new UniversityMap(mapPath, this);
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.academicians  = Arrays.asList(new Academician("Temizer", "../SelimTemizer.gif", this), 
			new Academician("Katsu", "../ShigeoKatsu.gif", this), 
			new Academician("Tourassis", "../VassiliosTourassis.gif", this),
			new Academician("HansDeNivelle", "../HansDeNivelle.gif", this));
		this.speakers = Arrays.asList(new Speaker("Nazarbayev", "../NursultanNazarbayev.gif", this, new Vector2D(740, 580)),
			new Speaker("Tokayev", "../KassymJomartTokayev.gif", this, new Vector2D(940, 580))
		);
		shuffleArray(csci235StudentNames);
		this.students = new ArrayList<Student>();
		for(int i = 0; i < 10; ++i) {
			this.students.add(new Student(csci235StudentNames[i], this));
		}
		this.assessments = new ArrayList<Assessment>();
	}
	public void shuffleArray(String[] ar) {
    for (int i = ar.length - 1; i > 0; i--) {
			int index = randomInt(1, i) - 1;
      String a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
	public int randomInt(int from, int to) {
		int temp = ThreadLocalRandom.current().nextInt(from, to + 1);
		if(temp != 0) return temp;
		return randomInt(from, to);
	}
	public void stepAllEntities() {
		Boolean end = true, doneBefore = true;
		for(Student s: students) end &= s.state.isOver;
		for(Academician a: academicians) doneBefore &= a.state.isOver;
		if(end && !doneBefore) {
			assessments.clear();
			Vector2D temp = new Vector2D(670, 450), step = new Vector2D(130, 0);
			for(Academician a: academicians) {
				a.position.set(temp);
				a.state = new Stationary();
				a.state.isOver = true;
				temp.plus(step);
			}
			for(Speaker s: speakers)
				s.state.isVisible = true;
		}
		for(Academician a: academicians) a.step();
		for(Student s: students) s.step();
	}
	public void drawAllEntities(Graphics2D g2d) {
		for(Academician a: academicians) a.draw(g2d);
		for(Student s: students) s.draw(g2d);
		for(Assessment a: assessments) a.draw(g2d);
		for(Speaker s: speakers) s.draw(g2d);
	}
}