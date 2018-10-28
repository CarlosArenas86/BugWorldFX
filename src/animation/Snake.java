package animation;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Snake extends Thing {
	public Snake(double posX, double posY, double size, double dx, double dy) {
		super(posX, posY, size, dx, dy);
		
		name="snake";
		//set up imagen
		imagen= new Image(getClass().getResourceAsStream("Imagen/snake.png"));
		//set the imagen into the body
		body.setFill(new ImagePattern(imagen));

	}
}
