package vkorantin.colorfit.graphics;

import java.util.List;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import vkorantin.colorfit.controllers.UpdateController;
import vkorantin.colorfit.model.Model;

public abstract class Graphics {
	
	public static Slider colorSlider;
	public static Label colorLabel;
	public static HBox colorsBox, codesBox, greysBox;
	public static Button generateButton;
	
	public static void setupListeners(Parent root) {
		colorSlider = (Slider) root.lookup("#color_slider");
		colorLabel = (Label) root.lookup("#color_label");
		colorsBox = (HBox) root.lookup("#hbox_colors");
		codesBox = (HBox) root.lookup("#hbox_codes");
		greysBox = (HBox) root.lookup("#hbox_greys");
		generateButton = (Button) root.lookup("#generate_btn");
		
		colorSlider.valueProperty().addListener(UpdateController.ColorSliderListener);
		initialSetup(root);
	}
	
	private static void initialSetup(Parent root) {
		updateColors();
		generateButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			updateColors();
		});
	}
	
	public static void updateColors() {
		colorsBox.getChildren().clear();
		codesBox.getChildren().clear();
		greysBox.getChildren().clear();
		
		for(int i = 0; i < (int) colorSlider.getValue(); ++i) {
			Color color = Model.generateColor();
			Color grey = Model.generateGreyFrom(color);
			colorsBox.getChildren().add(new Rectangle(100, 100, color));
			codesBox.getChildren().add(new Label(String.format("(%d, %d, %d)", (int) (color.getRed()*255), (int) (color.getGreen()*255), (int) (color.getBlue()*255))));
			greysBox.getChildren().add(new Rectangle(100, 100, grey));
		}
		
		sortColors();
	}

	private static void sortColors() {
		List<Color> colors = Model.getSortedColors();
		
		colorsBox.getChildren().clear();
		codesBox.getChildren().clear();
		greysBox.getChildren().clear();
		
		for(Color color : colors) {
			colorsBox.getChildren().add(new Rectangle(100, 100, color));
			codesBox.getChildren().add(new Label(String.format("(%d, %d, %d)", (int) (color.getRed()*255), (int) (color.getGreen()*255), (int) (color.getBlue()*255))));
			greysBox.getChildren().add(new Rectangle(100, 100, Model.generateGreyFrom(color)));
		}
	}
	
}
