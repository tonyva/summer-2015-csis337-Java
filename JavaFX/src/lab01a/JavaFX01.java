package lab01a;

/**
 * JavaFX01 - This is an example of a basic Java FX program
 *   that creates a window where we can draw things.
 * Note the use of the Application class and the use of 
 * the Stage and Scene classes.
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class JavaFX01 extends Application {
	
	/**
	 * The start method is where the window gets set up
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);

			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * main - this is where the program begins
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
