package animation;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Plant extends Thing {

	public Plant(double posX, double posY, double size) {
		super(posX, posY, size);
		//System.out.println("A plant was created at pos " + this.getPosX());
		name="plant";
		imagen= new Image(getClass().getResourceAsStream("Imagen/plant.png"));
		body.setFill(new ImagePattern(imagen));
	}

}
