package Application.classes;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Application.interfaces.Obiect;

/**
 * Clasa pentru exportarea imaginilor decupate
 */
public class Export{
	
	private JButton export;
	private static Add_Image Add_imageTemp;
	private static Vector<Obiect> listOfObjects;
	private static ActionListener exportAction;
	private static boolean createdBooleanExport = false;
	private BufferedImage image;
	
	/**
	 * Constructor de initializare cu parametri
	 * @param export Butonul de exportare a imaginilor decupate
	 * @param listOfObjects Lista cu obiectele pentru care s-a creat chenar si care vor fi exportate
	 */
	public Export(JButton export, Vector<Obiect> listOfObjects){
		Export.Add_imageTemp = Application.classes.Add_Image.add_imageTemp;
		this.export=export;
		Export.listOfObjects = listOfObjects;
	}

	
	/**
	 * Metoda pentru decuparea imaginilor
	 * @param src Imaginea sursa din buffer
	 * @param rect Chenarul/Dreptunghiul creat
	 * @return dest Imaginea finala decupata
	 */
	public BufferedImage cropImage(BufferedImage src, Rectangle rect) {
	      BufferedImage dest = src.getSubimage(rect.x, rect.y, rect.width, rect.height);
	      return dest; 
	   }
	
	/**
	 * Metoda de incarcare a exportarii imaginilor decupate
	 * Daca desenarea chenarului nu a fost realizata se afiseaza un mesaj de eroare
	 * Daca desenarea a fost realizata:
	 * - se deschide un pop-ul de alegere a folderului in care sa fie facuta exportarea
	 * - se adauga pentru fiecare imagine nume si numarul ordinii in care a fost creat chenarul corespunzator acesteia
	 * - se salveaza in folderul local si se afiseaza un mesaj de exportare cu succes.
	 */
	public void load() {
		exportAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listOfObjects.isEmpty()) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please draw rectangles to export", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int response = fileChooser.showOpenDialog(Add_imageTemp.getFrame());
					File file = fileChooser.getSelectedFile();
					if (response == JFileChooser.APPROVE_OPTION) {
						VctCrop vct1=new VctCrop(listOfObjects);
					 	Vector<String> allvct=vct1.getvct();
					 	VctFreq vct2=new VctFreq(allvct);
					 	String namevct[]=vct2.getName_VctFreq();
					 	Integer contorvct[]=vct2.getContor_VctFreq();
					 	Integer aux[]=Arrays.copyOf(contorvct, contorvct.length);
					 	int conti;
					 	boolean OK = false;
						 for(int i=0;i<allvct.size();i++){	
						 	for(int j=0;j<namevct.length;j++){	 		
						 		if(allvct.get(i).equals(namevct[j])){
						 			java.awt.Rectangle rect=listOfObjects.get(i).getRect();
						 			try {
						 				image = Application.classes.JDrawPanel.getImageToCrop();
						 				image = Application.classes.DrawStart.resizeImage(image, 800, 543);
						 				try {
						 				image = cropImage(image, rect);
						 				} catch (RasterFormatException e1) {}
									} catch (IOException e1) {
										e1.printStackTrace();
									}
						 				String path = file.getAbsolutePath()+'/'+allvct.get(i)+".jpg";
						 				if(new FileManager().FileExist(path) == false) {
											try {
												ImageIO.write(image , "png", new File(path));
											} catch (IOException e1) {}
						 					aux[j] = aux[j]-1;
						 					OK = true;
						 				} else {
						 					if(OK) {
						 						conti = contorvct[j]-aux[j];
						 					} else {
						 						conti = contorvct[j]-aux[j]+1;
						 					}		
						 					path = file.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg";
						 					while(new FileManager().FileExist(path)) {
						 						conti++;
						 						path = file.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg";
						 					}
						 					try {
												ImageIO.write(image , "png", new File(path));
											} catch (IOException e1) {}
						 					aux[j] = aux[j]-1;
						 				}					 				
						 		}
						 	}
						 }
						 	if(allvct.size()!=0){
						 		JFrame mesaj = new JFrame();
						 		JOptionPane.showMessageDialog(mesaj,"Export done!","Info",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("done.png"));
						 		mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 		
						 	}
						}
					}
				}
			};
			if(createdBooleanExport == false) {
				export.addActionListener(exportAction);
				createdBooleanExport = true;
			}
	}
}