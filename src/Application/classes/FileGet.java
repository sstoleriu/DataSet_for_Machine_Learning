package Application.classes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class FileGet {
	
	private File file = new File("src/Application/resources/images/startDataSet.png");
	private MarvinImage image = MarvinImageIO.loadImage(file.toString());
	private String iconFirstPath = "src/Application/resources/images/";
	private Icon icon;
	
	FileGet(){
	}
	
	public MarvinImage getBackground() {
		return image;
	}
	
	public MarvinImage getMovedDataSet(String iconSecondPath) {
		File iconFile = new File(iconFirstPath+iconSecondPath);
		return MarvinImageIO.loadImage(iconFile.toString());
	}
	
	public Icon getIcon(String iconSecondPath) {
		File iconFile = new File(iconFirstPath+iconSecondPath);
		icon =  new ImageIcon(iconFile.getAbsolutePath());
		return icon;
	}
	
	public Image getImage(String iconSecondPath) throws IOException {
		File icon = new File(iconFirstPath+iconSecondPath);
		Image image = ImageIO.read(icon);
		return image;
	}
}
