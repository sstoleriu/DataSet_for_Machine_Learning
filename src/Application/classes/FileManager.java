package Application.classes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 */
public class FileManager {
	
	private String iconFirstPath = "src/Application/resources/images/";
	private Icon icon;
	
	FileManager(){
	}
	/**
	 * Getter pentru preluarea path-ului iconitelor
	 * @param iconSecondPath
	 * @return
	 */
	public Icon getIcon(String iconSecondPath) {
		File iconFile = new File(iconFirstPath+iconSecondPath);
		icon =  new ImageIcon(iconFile.getAbsolutePath());
		return icon;
	}
	
	/**
	 * Getter pentru returnarea imaginii
	 * @param iconSecondPath Path-ul imaginii
	 * @return image Imaginea returnata
	 * @throws IOException
	 */
	public Image getImage(String iconSecondPath) throws IOException {
		File icon = new File(iconFirstPath+iconSecondPath);
		Image image = ImageIO.read(icon);
		return image;
	}
	
	/**
	 * Metoda de verificare a existentei fisierului in path
	 * @param path Path-ul ales
	 */
	public boolean FileExist(String path) {
		File file = new File(path);
		if(file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
