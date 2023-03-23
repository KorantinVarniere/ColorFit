package vkorantin.colorfit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ColorFit extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ColorFit");
		
		StackPane root = new StackPane();
		Label helloLabel = new Label("Hello World !");
		root.getChildren().add(helloLabel);
		
		stage.setScene(new Scene(root, 1280, 720));
		
		stage.show();
	}
	
}
