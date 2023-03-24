package vkorantin.colorfit.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import vkorantin.colorfit.graphics.Graphics;

public abstract class Model {

	public static Parent root;
	private static Random rand = new Random();
	public static List<Color> prevColors = new ArrayList<Color>();
	
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
	
	public static void export() {
		List<Color> colors = getSortedColors();
		
		FileChooser chooser = new FileChooser();
		File file = chooser.showSaveDialog(root.getScene().getWindow());
		
		List<String> toSave = new ArrayList<String>();
		for (Color color: colors) {
			toSave.add(color.toString());
		}

		try (FileWriter writer = new FileWriter(file)) {
			for (String str : toSave) {
				writer.write(str + System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void _import() {
		List<String> toImport = new ArrayList<String>();
		String line;
		
		FileChooser chooser = new FileChooser();
		File file = chooser.showOpenDialog(root.getScene().getWindow());
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				toImport.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graphics.colorSlider.setValue(toImport.size());
		
		List<Color> colors = new ArrayList<Color>();
		for (int i = 0; i < toImport.size(); i++) {
			colors.add(Color.web(toImport.get(i)));
		}
		
		Graphics.updateColors(colors);
	}
	
}
