package vkorantin.colorfit.model;

import java.util.Random;

import javafx.scene.paint.Color;

public abstract class Model {

	private static Random rand = new Random();
	
	public static Color generateColor() {
		return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}
	
	public static Color generateGreyFrom(Color color) {
		return Color.grayRgb((int) (((int) (color.getRed() * 255) + (int) (color.getGreen() * 255) + (int) (color.getBlue() * 255)) / 3));
	}
	
}
