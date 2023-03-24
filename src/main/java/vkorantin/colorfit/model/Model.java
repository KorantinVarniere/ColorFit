package vkorantin.colorfit.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import vkorantin.colorfit.graphics.Graphics;

public abstract class Model {

	private static Random rand = new Random();
	
	public static Color generateColor() {
		return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}
	
	public static Color generateGreyFrom(Color color) {
		return Color.grayRgb((int) (((int) (color.getRed() * 255) + (int) (color.getGreen() * 255) + (int) (color.getBlue() * 255)) / 3));
	}
	
	public static List<Color> getSortedColors() {
		List<Node> nodes = Graphics.colorsBox.getChildren().subList(0, Graphics.colorsBox.getChildren().size());
		List<Color> colors = new ArrayList<Color>();
		
		for (Node node : nodes) {
			colors.add((Color) ((Rectangle) node).fillProperty().get());
		}

		colors.sort(new Comparator<Color>() {
			@Override
			public int compare(Color o1, Color o2) {
				int o1grey = (int) (((int) (o1.getRed()*255) + (int) (o1.getGreen()*255) + (int) (o1.getBlue()*255)) / 3);
				int o2grey = (int) (((int) (o2.getRed()*255) + (int) (o2.getGreen()*255) + (int) (o2.getBlue()*255)) / 3);
				
				return Integer.compare(o2grey, o1grey);			
			}
		});
		
		return colors;
	}
	
}
