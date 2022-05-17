package Application.classes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Application.interfaces.Obiect;

public class DrawStart {

	private JPanel panel;
	private JButton refresh;
	private JButton export;
	private static Vector<Obiect> listOfObjects;
	private static JComboBox<String> selectObjectVar;
	private static Vector<String> names=new Vector<>();
	private static Vector<Color> colors=new Vector<>();
	private JDrawPanel drawPanel;
	private BufferedImage image;
	
	public static JComboBox<String> getComboBox(){
		return selectObjectVar;
	}
	
	public static Vector<String> getNames(){
		return names;
	}
	
	public static Vector<Color> getColor(){
		return colors;
	}
	
	DrawStart(JPanel panel, JButton refresh, JButton export, Vector<String> names, Vector<Color> colors, Image image){
		this.panel = panel;
		this.refresh = refresh;
		this.export = export;
		DrawStart.selectObjectVar = Application.classes.Add_Image.getComboBox();
		DrawStart.names = names;
		DrawStart.colors = colors;
		this.image = (BufferedImage) image;
	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
	    BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
	    return outputImage;
	}
	
	public void StartDrawing() throws IOException {
		drawPanel =  new JDrawPanel(resizeImage(image, 800, 543), image);
		panel.add(drawPanel);
		Refresh clean = new Refresh(refresh , new JDrawPanel().getList(), drawPanel);
		clean.load();
		Export crop = new Export(export, new JDrawPanel().getList());
		crop.load();
	}
	
	public Vector<Obiect> getList() {
		listOfObjects = drawPanel.getList();
		System.out.println("DrawStart: "+listOfObjects);
		return listOfObjects;
	}
}
