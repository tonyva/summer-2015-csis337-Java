package lab07a;

/**
 * Java07a2 - This is an example of a basic JavaFX animation using ScaleTransition
 *   
 * For more details see:
 * http://docs.oracle.com/javase/8/javafx/graphics-tutorial/javafx-3d-graphics.htm
 */


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Java07a2 extends Application {
	
	private final String TITLE = "Java07a2: JavaFX 3D ScaleTransition Example";
	private final int SCENE_WIDTH  = 600;
	private final int SCENE_HEIGHT = 400;

	/*
	 * File for texture
	 */
	private final String directory = "file:src/lab04b/"; // where the image is
	private final String file      = "UWRFLogo.jpg"; // name of image file
	private final String filename  = directory + file;
	private Rotate rotate = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS );

	private boolean enableDepthBuffer = true;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root, SCENE_WIDTH,SCENE_HEIGHT, enableDepthBuffer );
			scene.setFill( Color.LIGHTGRAY );
			ObservableList<Node> list = root.getChildren();
			list.add( addPane() );

			if (enableDepthBuffer){
				PerspectiveCamera cam = new PerspectiveCamera();
				// Position the camera up a little and back a bit
				//  mainly so that we can see all three axes and
				//  the other objects  
				cam.setTranslateX( -50 );
				cam.setTranslateY( -10 );
				cam.setTranslateZ( -50 );
				scene.setCamera( cam );
			}
			primaryStage.setScene(scene);
			primaryStage.setTitle( TITLE );
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}

	
	
	private Pane addPane(){
		PhongMaterial rpm = new PhongMaterial();
		rpm.setDiffuseColor(Color.RED);
		PhongMaterial gpm = new PhongMaterial();
		gpm.setDiffuseColor(Color.GREEN);
		PhongMaterial bpm = new PhongMaterial();
		bpm.setDiffuseColor(Color.BLUE);

		
		Pane box = new Pane();
		ObservableList<Node> list = box.getChildren();
		
		/*
		 * Nodes in this scene
		 */
		Sphere sphere = new Sphere( 50 );
		PhongMaterial pm = new PhongMaterial();
		pm.setDiffuseColor( Color.RED );
		sphere.setMaterial( pm );
		sphere.setTranslateX( 50 );
		sphere.setTranslateY( 50 );
		sphere.setTranslateZ( 0 );

		ScaleTransition tt = new ScaleTransition( Duration.seconds( 5 ), sphere );
		tt.setByX( 5 );
		tt.setByY( 0.5 );
		tt.setByZ( 3 );
		tt.play();
		
		Image rim = new Image(filename);
		Rectangle rectangle = new Rectangle(0, 0, rim.getWidth(), rim.getHeight() );
		rectangle.setTranslateX(180);
		rectangle.setFill( new ImagePattern( rim, 0, 0, rim.getWidth(), rim.getHeight(), false ) );

		// Use 3-d boxes - long narrow ones - for each of the three axes.
		Box xaxis = new Box(300,   2,   2);
		Box yaxis = new Box(  2, 300,   2);
		Box zaxis = new Box(  2,   2, 300);
		xaxis.setMaterial( rpm );
		yaxis.setMaterial( gpm );
		zaxis.setMaterial( bpm );

		// group the elements
		Group things = new Group( rectangle, sphere, xaxis, yaxis, zaxis );
		things.getTransforms().add(rotate);
		
	    // rotate animation - timeline affects the rotation angle
	    Timeline rAnimation = new Timeline();
	    rAnimation.getKeyFrames().addAll( new KeyFrame( Duration.seconds( 20), new KeyValue( rotate.angleProperty(), 360 ) ) );
	    rAnimation.setCycleCount(Animation.INDEFINITE);
//	    rAnimation.play();

	    list.add( things );
		return box;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
