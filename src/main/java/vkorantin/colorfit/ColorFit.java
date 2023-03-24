package vkorantin.colorfit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vkorantin.colorfit.graphics.Graphics;
import vkorantin.colorfit.model.Model;

public class ColorFit extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
		Scene scene = new Scene(root, 1280, 720);
		
		Graphics.setupListeners(root);
		Model.root = root;
		
		stage.setTitle("ColorFit");
		stage.setResizable(false);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
		stage.setScene(scene);
		stage.show();
	}
	
}
