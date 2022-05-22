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

/**
 * Clasa pentru desenarea chenarelor
 */
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
	
	/**
	 * Getter pentru preluarea listei de selectare cu numele obiectelor de tip JComboBox
	 * @return selectObjectVar obiectul ales
	 */
	public static JComboBox<String> getComboBox(){
		return selectObjectVar;
	}
	
	/**
	 * Getter pentru returnarea vectorului de nume ale obiectelor pentru care se deseneaza chenar
	 * @return names Vectorul cu numele obiectelor
	 */
	public static Vector<String> getNames(){
		return names;
	}
	
	/**
	 * Getter pentru returnarea culorilor obiectelor pentru care se deseneaza chenar
	 * @return colors Culorile chenarului
	 */
	public static Vector<Color> getColor(){
		return colors;
	}
	
	/**
	 * Constructor de initializare cu parametri
	 * @param panel JPanel cu imaginea importata
	 * @param refresh Buton de reincarcare a aplicatiei
	 * @param export Buton de exportare a imaginilor decupate
	 * @param names Vectorul care contine numele obiectelor create
	 * @param colors Vectorul care contine culorile chenarelor create
	 * @param image Imaginea din buffer
	 */
	DrawStart(JPanel panel, JButton refresh, JButton export, Vector<String> names, Vector<Color> colors, Image image){
		this.panel = panel;
		this.refresh = refresh;
		this.export = export;
		DrawStart.selectObjectVar = Application.classes.Add_Image.getComboBox();
		DrawStart.names = names;
		DrawStart.colors = colors;
		this.image = (BufferedImage) image;
	}

	/**
	 * Metoda pentru redimensionarea imaginii
	 * @param originalImage Imaginea originala
	 * @param targetWidth Valoarea latimii
	 * @param targetHeight Valoarea lungimii
	 * @return outputImage Imaginea finala
	 */
	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
	    BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
	    return outputImage;
	}
	
	/**
	 * Metoda pentru inceperea desenarii chenarelor
	 * Initializeaza panoul in care se va desena
	 * Reimprospateaza Panoul si lista de obiecte
	 */
	public void StartDrawing() throws IOException {
		drawPanel =  new JDrawPanel(resizeImage(image, 800, 543), image);
		panel.add(drawPanel);
		Refresh clean = new Refresh(refresh , new JDrawPanel().getList(), drawPanel);
		clean.load();
		Export crop = new Export(export, new JDrawPanel().getList());
		crop.load();
	}
	
	/**
	 * Getter pentru vectorul listei de obiecte pentru care se deseneaza chenar
	 * @return listOfObjects Lista de obiecte create
	 */
	public Vector<Obiect> getList() {
		listOfObjects = drawPanel.getList();
		System.out.println("DrawStart: "+listOfObjects);
		return listOfObjects;
	}
}
