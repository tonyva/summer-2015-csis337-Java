package lab01b;

/**
 * JavaFXb01 - This is an example of a basic Java FX program
 *   that creates a window with a button.
 *   
 * For more details see:
 * https://docs.oracle.com/javase/8/javafx/get-started-tutorial/get_start_apps.htm
 * 
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXb01 extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			StackPane  root = new StackPane();
			Scene scene = new Scene(root,400,400);
			ObservableList<Node> list = root.getChildren();
			
			Button btn = new Button("Click me!");
			list.add( btn );
			/*
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Hello!!!!!!");
	            }
	        });
			*/
			
			
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
