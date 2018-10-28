package animation;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Spider extends Thing {
	public Spider(double posX, double posY, double size,double dx, double dy) {
		super(posX, posY, size, dx, dy);

		name="spider";
		imagen= new Image(getClass().getResourceAsStream("Imagen/spider.png"));
		body.setFill(new ImagePattern(imagen));
	}

}
