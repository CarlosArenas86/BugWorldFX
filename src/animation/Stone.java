package animation;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Stone extends Thing {
	
	public Stone (double posX, double posY, double size) {
		super(posX, posY, size);
		//System.out.println("A plant was created at pos " + this.getPosX());
		name="stone";
		imagen= new Image(getClass().getResourceAsStream("Imagen/stone.png"));
		body.setFill(new ImagePattern(imagen));
	}

}
