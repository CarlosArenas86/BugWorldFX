package animation;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class World extends Application {

	
	/**
	 * Scene width
	 */
	private int sceneWidth = 800;
	/**
	 * Scene height
	 */
	private int sceneHeight = 580; // these may need some further changing
	
	
	/**
	 * declarando botones.
	 */
	private Button startBtn = new Button();
	private Button resetBtn = new Button();
	private Button pauseBtn = new Button();
	private Slider zoomSlide = new Slider();
	

	/**
	 * seteando el VBox
	 */
	
	
	
	private VBox leftSide = new VBox();
	private VBox rightSide = new VBox();
	private Label pauseMsg = new Label();
	private BackgroundFill backFill;
	private Rectangle recTemp = new Rectangle();


	/**
	 * ************ crear el metodo para setear botones este seria igual al initialiseUI del UI.*********
	 */
	
	
	final ArrayList <Thing> thingList = new ArrayList <>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		fillWorld(10,10,10,10,10);
		
		//Group root = new Group (thing);
		Group root = new Group (); //contenedor of thing (layout = diseño)
		
		// adding circles to the group
		for(int i=0; i<thingList.size();i++) {
			root.getChildren().add(thingList.get(i).getBody());//getbody give me the circle
		}
		//create the scene with tat parametros
		final Scene scene = new Scene(root, sceneWidth,sceneHeight);

		//"key fram class" to say how fast the animation will be
		KeyFrame frame = new KeyFrame(Duration.millis(6), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
				for(int i=0; i<thingList.size();i++) {
					Thing thing = thingList.get(i);
					Circle thingBody = thing.getBody();// get the circle = body
					
					// ********* detectar colisiones*******************

					//limites del choque de la bola, comportamiento de la bola
					//parametres of the hit ball in the scenne. 
					// marcar limites de los lados
					if(thingBody.getCenterX() + thingBody.getTranslateX() < thingBody.getRadius() || 
							thingBody.getCenterX() + thingBody.getTranslateX() + thingBody.getRadius() > scene.getWidth()) {
						//dx = - dx;
						// if is true multiply -1 to keep positive values.
						//setDx is the velocity in the x when the bug hit the frame need to change the velocity
						thing.setDx(thing.getDx()*-1);	
					}
					//marcar limites de el techo y abajo
					if(thingBody.getCenterY() + thingBody.getTranslateY() < thingBody.getRadius() || 
							thingBody.getCenterY() + thingBody.getTranslateY() + thingBody.getRadius() > scene.getHeight()) {
						//dy = - dy;
						thing.setDy(thing.getDy()*-1);	
					}
					
					//This animates teh bug
					//you set a new position for the circle
					//the new position is the current position plus the dx
					//movemos cada objeto de la lista.
					thingBody.setTranslateX(thingBody.getTranslateX() + thing.getDx());
					thing.setPosX(thingBody.getTranslateX());
					
					thingBody.setTranslateY(thingBody.getTranslateY() + thing.getDy());
					thing.setPosY(thingBody.getTranslateY());
				}
			}
		});

		final Timeline timeline=new Timeline();
		timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.getKeyFrames().add(frame);
		timeline.play();

		primaryStage.setTitle("Hello Animation");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
		private void fillWorld(int amount_spiders, int amount_ant, int amount_snake, int amount_plant, int amount_stone) {
		//fillworld llena el mundo, crea los objetos y los llena a la lista
		//declaramos amount por el monto que el usuario ingrese las bolas.	
		for(int i =0; i < amount_spiders;i++) {
			spawnThing("spider");
		}

		for(int i =0; i < amount_ant;i++) {
			spawnThing("ant");
		}
		
		for(int i =0; i < amount_ant;i++) {
			spawnThing("snake");
		}

		for(int i =0; i < amount_plant;i++) {
			spawnThing("plant");
		}
		
		for(int i =0; i < amount_stone;i++) {
			spawnThing("stone");
		}
	}

		//method to create ramdom size, x, y, dx,dy to the thing
		private void spawnThing(String kind) {
			//Next double gives us a random number between a range, first param is min, second max
			//from internet
			double size= ThreadLocalRandom.current().nextDouble(10, 26);//ramdom size
			//double x = Math.random()*width;
			double x = ThreadLocalRandom.current().nextDouble(size, sceneWidth-size);//random x
			//double y = Math.random()*height;
			double y = ThreadLocalRandom.current().nextDouble(size, sceneHeight-size);//random y
			double dx= ThreadLocalRandom.current().nextDouble(.1, .6);// random speed
			//forma de sacar metodo random de algo
			double dy= ThreadLocalRandom.current().nextDouble(.1, .6); // random speed


			//We spawn accordingly 
			switch(kind) {
			case "spider" :
				Spider spider = new Spider(x,y,size,dx,dy);
				thingList.add(spider);
				break;

			case "ant" :
				Ant ant = new Ant(x,y,size,dx,dy);
				thingList.add(ant);
				break;
				
			case "snake" :
				Snake snake = new Snake(x,y,size,dx,dy);
				thingList.add(snake);
				break;

			case "plant" :
				Plant plant = new Plant(x,y,size);		
				thingList.add(plant);
				break;	
				
			case "stone" :
			
				Stone stone = new Stone(x,y,size);		
				thingList.add(stone);
				break;

			default:
				break;
			}
		}
		
	public static void main(String[] args) {
		launch();

	}

}
