package vkorantin.colorfit.graphics;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import vkorantin.colorfit.controllers.UpdateController;

public abstract class Graphics {
	
	public static Slider colorSlider;
	public static Label colorLabel;
	
	public static void setup(Parent root) {
		colorSlider = (Slider) root.lookup("#color_slider");
		colorLabel = (Label) root.lookup("#color_label");
		
		colorSlider.valueProperty().addListener(UpdateController.ColorSliderListener);
	}

}
