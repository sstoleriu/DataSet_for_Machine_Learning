package Application.classes;

import static marvin.MarvinPluginCollection.scale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Add_Image {
	
	/**
	 * Image Panel din framework-ul de procesare de imagini Marvin
	 */
	private static MarvinImagePanel imagePanel; 
	private static MarvinImage	image;  
	private MarvinImage backupImage;
	private JButton Add_Image;
	private JFrame frame;
	private static File file;
	private static JComboBox<String> selectObjectVar;
	private JButton export;
	
	/**
	 *  Metoda de adaugare imagine
	 * @param frame Frame-ul setat
	 * @param Add_Image Butonul de adaugare de imagini
	 * @param selectObject JComboBox pentru selectare optiune
	 * @param export Butonul de export
	 */
	public Add_Image(JFrame frame, JButton Add_Image, JComboBox<String> selectObject, JButton export) {
		this.frame = frame;
		this.Add_Image = Add_Image;
		this.selectObjectVar = selectObject;
		this.export = export;
	}
	
	/**
	 * Getter pentru preluarea imaginii adaugate de tip File //TO DO
	 */
	public File getFileAdd_image(){
		return this.file;
	}
	
	/**
	 * Getter pentru preluarea imaginii adaugate de tip MarvinImage
	 * @return image Imagine //TO DO
	 */
	public static MarvinImage getImage() {
		return image;
	}
	// geImagePanel(?)
	/**
	 * Getter de tip MarvinImagePanel pentru returnarea imagePanel
	 * @return imagePanel Panou de imagine
	 */
	public static MarvinImagePanel geImagePanel() {
		return imagePanel;
	}
	
	/**
	 * Metoda de incarcare a imaginii
	 */
	public void Load() {
		Add_Image add_imageTemp = this;
		Add_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
				
				if (response == JFileChooser.APPROVE_OPTION) {
					file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					System.out.println(file.toString());
					imagePanel = new MarvinImagePanel();
					imagePanel.setBounds(10, 10, 800, 543);
					frame.getContentPane().add(imagePanel);
					image = MarvinImageIO.loadImage(file.toString());
					
					/**
					 * Adaugarea imaginii de backup prin clonarea imaginii adaugate
					 */
			        backupImage = image.clone();
			        scale(backupImage, image, 800, 543);
			        MarvinImage cropImage=image.clone();
			        imagePanel.setImage(image);
			        
			        /**
			         * Crearea obiectului de tip selectObject si initializarea lui
			         */
			        selectObject selectObject = new selectObject(frame, add_imageTemp, selectObjectVar, export,cropImage);
			        
			        /**
			         * Apelarea metodei de creare obiect si desenare chenar pentru obiectul de tip selectObject
			         */
					selectObject.createObjectAndDraw();
				}
			}
		});
	}

}
