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

public class selectObject {
	
	private static JFrame frame;
	private static Add_Image Add_image;
	private static JComboBox<String> selectObject;
	
	
	public selectObject(JFrame frame, Add_Image Add_Image, JComboBox<String> selectObject) {
		this.selectObject = selectObject;
		this.frame = frame;
		this.Add_image = Add_Image;
	}

	public static JFrame getFrame() {
		return frame;
	}
	
	public static Add_Image getAddImage() {
		return Add_image;
	}
	
	public static JComboBox<String> getSelectObject() {
		return selectObject;
	}
	
	public void createObjectAndDraw() {
		
		this.selectObject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String alegere = getSelectObject().getSelectedItem().toString();
				//System.out.println(alegere);
				switch (alegere) {
				case "Masina": {
								Masina m1 = new Masina(getFrame(), getAddImage());
								m1.draw();
								break;
								}
				case "Bicicleta":{
								//System.out.println("biciletaaaa");
								break;
								}
				default:
					throw new IllegalArgumentException("Unexpected value: " + alegere);
				}
			}
		});

	}
}
