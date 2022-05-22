package Application.classes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Clasa pentru gestionarea fisierelor
 */
public class FileManager {
	
	/**
	 * Path-ul catre fisierul in care se afla imaginile/iconitele
	 */
	private String iconFirstPath = "src/Application/resources/images/";
	private Icon icon;
	
	FileManager(){
	}
	
	/**
	 * Getter pentru preluarea iconitelor din fisier
	 * @param iconSecondPath Numele imaginii dorite
	 * @return iconita corespunzatoare numelui 
	 */
	public Icon getIcon(String iconSecondPath) {
		File iconFile = new File(iconFirstPath+iconSecondPath);
		icon =  new ImageIcon(iconFile.getAbsolutePath());
		return icon;
	}
	
	/**
	 * Getter pentru returnarea imaginii
	 * @param iconSecondPath Numele imaginii dorite
	 * @return image Imaginea returnata
	 * @throws IOException Exceptie de input/output
	 */
	public Image getImage(String iconSecondPath) throws IOException {
		File icon = new File(iconFirstPath+iconSecondPath);
		Image image = ImageIO.read(icon);
		return image;
	}
	
	/**
	 * Metoda de verificare a existentei fisierului in path
	 * @param path Path-ul ales
	 * @return true/false
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
