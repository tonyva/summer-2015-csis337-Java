package lab01a;

/**
 * JavaFX02 - This is an example of a basic Java FX program
 *   that creates a window with a scene where we can do our
 *   drawing.
 *   
 * In this program we see how to set the title and width/height
 * of the "Scene" object.
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFX02 extends Application {
	/**
	 * Data members of the class
	 */
	private static final long serialVersionUID = 1L;
	private final String TITLE = "Simple JavaFX Example";
	private final int SCENE_WIDTH = 400;
	private final int SCENE_HEIGHT = 300;


	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,SCENE_WIDTH,SCENE_HEIGHT);

			primaryStage.setScene(scene);
			primaryStage.setTitle( TITLE );
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
