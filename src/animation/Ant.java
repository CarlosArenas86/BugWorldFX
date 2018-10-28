package animation;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Ant extends Thing {

	public Ant(double posX, double posY, double size, double dx, double dy) {
		super(posX, posY, size, dx, dy);
		name="ant";
		imagen= new Image(getClass().getResourceAsStream("Imagen/ant.png"));
		body.setFill(new ImagePattern(imagen));
		// TODO Auto-generated constructor stub
		
		//first comment.
	}

}
