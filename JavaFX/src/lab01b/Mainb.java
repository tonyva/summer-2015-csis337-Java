package lab01b;

/**
 * JavaFX02 - This is an example of a basic Java FX program
 *   that creates a window where we draw things.
 *   
 * Note the use of the Application class and the use of 
 * the Stage and Scene classes.
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Mainb extends Application {

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

	public static void main(String[] args) {
		launch(args);
	}
}
