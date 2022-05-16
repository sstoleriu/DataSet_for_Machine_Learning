package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import Application.interfaces.Obiect;
import static marvin.MarvinPluginCollection.*;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Export{
	
	private JButton Export;
	private static Add_Image Add_image;
	private Vector<Obiect> listOfObjects;
	private MarvinImage cropImage;
	
	/**
	 * Constructor de initializare cu parametri pentru clasa Export
	 * @param Export Butonul de export
	 * @param Add_image Imaginea adaugata
	 * @param listOfObjects Lista de obiecte care contine obiectele create prin selectarea optiunii din DropBox
	 *        Aceasta lista include pentru fiecare element:
	 *        culoarea, imaginea adaugata, punctul initial, punctul final si chenarul(dreptunghiul)
	 * @param cropImage Imaginea decupata
	 */
	public Export(JButton Export, Add_Image Add_image, Vector<Obiect> listOfObjects, MarvinImage cropImage){
		Application.classes.Export.Add_image = Add_image;
		this.Export=Export;
		this.listOfObjects = listOfObjects;
		this.cropImage=cropImage;
	}

	/**
	 * Getter de tip Add_Image pentru preluarea imaginii adaugate
	 * @return Add_image Imagine adaugata
	 */
	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	/**
	 * Metoda pentru incarcarea exportarii de imagini decupate
	 *  cu posibilitatea de alegere a folderului in care vor fi salvate imaginile decupate,
	 *  cu redenumirea imaginilor in functie de numele tipului de obiect ales
	 *  si vector cu indecsi pentru redenumirea imaginilor decupate in ordine 
	 */
	public void Load2() {		
		Export.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MarvinImage imageOut = new MarvinImage();
				JFileChooser fileChooser2 = new JFileChooser();
				fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int response = fileChooser2.showOpenDialog(null);
				File file2 = fileChooser2.getSelectedFile();

				if (response == JFileChooser.APPROVE_OPTION) {
					VctCrop vct1=new VctCrop(listOfObjects);
				 	Vector<String> allvct=vct1.getvct();
				 	VctFreq vct2=new VctFreq(allvct);
				 	String namevct[]=vct2.getName_VctFreq();
				 	Integer contorvct[]=vct2.getContor_VctFreq();
				 	Integer aux[]=Arrays.copyOf(contorvct, contorvct.length);
				 	int conti;
					 	for(int i=0;i<allvct.size();i++){
					 		for(int j=0;j<namevct.length;j++){
					 			if(allvct.get(i).equals(namevct[j])){
					 				java.awt.Rectangle rect=listOfObjects.get(i).getReact();
					 				crop(cropImage,imageOut,rect.x,rect.y,rect.width,rect.height);
					 				conti=contorvct[j]-aux[j];
					 				aux[j]=aux[j]-1;
					 				MarvinImageIO.saveImage(imageOut, file2.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg");
					 			}
					 		}
					 	}
				}
			}
		});
	}
	
}