package Application.classes;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class FileManager {
	
	private File file = new File("src/Application/resources/images/startDataSet.png");
	private MarvinImage image = MarvinImageIO.loadImage(file.toString());
	private String iconFirstPath = "src/Application/resources/images/";
	private Icon icon;
	
	FileManager(){
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
	
	public Icon getImage(JFileChooser fileChooser) {
		ImageIcon icon = new ImageIcon(fileChooser.getSelectedFile().toString());
		Image temp = icon.getImage();
		Image temp2 = temp.getScaledInstance(800, 543, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(temp2);
	}
	
	public Image getImage(String iconSecondPath) throws IOException {
		File icon = new File(iconFirstPath+iconSecondPath);
		Image image = ImageIO.read(icon);
		return image;
	}
	
	public String getPath(String iconSecondPath) {
		return iconFirstPath+iconSecondPath;
	}
	
	public boolean FileExist(String path) {
		File file = new File(path);
		if(file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public BufferedImage cropImage(BufferedImage src, Rectangle rect) {
	      //BufferedImage dest = src.getSubimage(rect.x, rect.y, rect.width, rect.height);
		BufferedImage dest = src.getSubimage(10, 10, 100, 200);
	      return dest; 
	  }
	
}
