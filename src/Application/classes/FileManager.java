package Application.classes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FileManager {
	
	private String iconFirstPath = "src/Application/resources/images/";
	private Icon icon;
	
	FileManager(){
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
	
	public boolean FileExist(String path) {
		File file = new File(path);
		if(file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
