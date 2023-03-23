package vkorantin.colorfit.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import vkorantin.colorfit.graphics.Graphics;

public abstract class UpdateController {

	public static ChangeListener<Number> ColorSliderListener = new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			if (newValue.intValue() != oldValue.intValue()) {
				Graphics.colorLabel.setText(newValue.intValue() + "");
			}
		}
		
	};

}
