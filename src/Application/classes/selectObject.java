package Application.classes;

import static marvin.MarvinPluginCollection.scale;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.sun.glass.events.*;
import com.sun.javafx.scene.paint.GradientUtils.Point;

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
								Masina m1 = new Masina(getFrame(), getAddImage(),p1,p2);
								m1.draw();
								break;
								}
				case "Bicicleta":{
								Bicicleta b1=new Bicicleta(getFrame(), getAddImage(),p1,p2);
								b1.draw();
								break;
								}
				case "Autobuz":{
								Autobuz a1 = new Autobuz(getFrame(), getAddImage(),p1,p2);
								a1.draw();
								break;
								}
				case "Motocicleta":{
								Motocicleta mot1=new Motocicleta(getFrame(), getAddImage(),p1,p2);
								mot1.draw();
								break;
								}
				case "Cladire":{
								Cladire c1=new Cladire(getFrame(), getAddImage(),p1,p2);
								c1.draw();
								break;
								}
				case "Pieton":{
								Pieton p1=new Pieton(getFrame(), getAddImage(),p1,p2);
								p1.draw();
								break;
								}
				case "Indicator":{
								Indicator i1=new Indicator(getFrame(), getAddImage(),p1,p2);
								i1.draw();
								break;
								}
				case "Semafor":{
								Semafor s1=new Semafor(getFrame(), getAddImage(),p1,p2);
								s1.draw();
								break;
								}
				default:
					throw new IllegalArgumentException("Unexpected value: " + alegere);
				}
			}
		});

	}
}
