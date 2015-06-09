package lab04a;

/**
 * Java04a - This is a simple Java FX program
 *   that checks if the computer it is run on has
 *   3D capability
 */

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Java04a extends Application {
	
	/**
	 * The start method is where the window gets set up
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);

			Text threed = new Text(50, 100, "This computer\nsupports 3D\nGraphics!");
			threed.setFont(Font.font("Arial", FontWeight.BOLD, 40));
			root.getChildren().add( threed );
			
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
		boolean good = Platform.isSupported( ConditionalFeature.SCENE3D );
		if (good)
			Application.launch(args);
		else
			System.out.println("No support for 3D graphics on this computer!!");
	}
}
