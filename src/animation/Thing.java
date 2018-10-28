package animation;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

public class Thing {
	String name;
	double posX;
	double posY;
	double dx;
	double dy;
	double size;
	Circle body;
	Image imagen;
	double energy;


	public Thing(double posX, double posY, double size,double dx,double dy) {
		body= new Circle(posX,posY,size);
		this.posX=posX;
		this.posY=posY;
		this.dx=dx;
		this.dy=dy;
	}
	
	//For things that won't move planta
	public Thing(double posX, double posY, double size) {
		body= new Circle(posX,posY,size);
		this.posX=posX;
		this.posY=posY;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}


	public double getDx() {
		return dx;
	}


	public void setDx(double dx) {
		this.dx = dx;
	}


	public double getDy() {
		return dy;
	}


	public void setDy(double dy) {
		this.dy = dy;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double size) {
		this.size = size;
	}


	public Circle getBody() {
		return body;
	}


	public void setBody(Circle body) {
		this.body = body;
	}


	public Image getImagen() {
		return imagen;
	}


	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}


	public double getEnergy() {
		return energy;
	}


	public void setEnergy(double energy) {
		this.energy = energy;
	}
}

