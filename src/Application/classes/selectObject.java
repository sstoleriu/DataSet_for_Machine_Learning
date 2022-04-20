package Application.classes;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class selectObject {
	
	private static JFrame frame;
	private static Add_Image Add_image;
	private static JComboBox<String> selectObject;
//	static boolean isPressed = false;
	
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
//		this.selectObject.addMouseListener(new MouseAdapter() {
//		    public void mousePressed(MouseEvent e) {
//			      System.out.println(e.getX() + "," + e.getY());
//			    }
//			  });
		this.selectObject.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
//				isPressed=true;
				String alegere = getSelectObject().getSelectedItem().toString();
				switch (alegere) {
				case "Masina": {
								MouseClick ms1=new MouseClick();
								getFrame().addMouseListener(ms1);
								Masina m1 = new Masina(getFrame(), getAddImage());
								m1.draw();
								break;
								}
				case "Bicicleta":{
								Bicicleta b1=new Bicicleta(getFrame(), getAddImage());
								b1.draw();
								break;
								}
				case "Autobuz":{
								Autobuz a1 = new Autobuz(getFrame(), getAddImage());
								a1.draw();
								break;
								}
				case "Motocicleta":{
								Motocicleta mot1=new Motocicleta(getFrame(), getAddImage());
								mot1.draw();
								break;
								}
				case "Cladire":{
								Cladire c1=new Cladire(getFrame(), getAddImage());
								c1.draw();
								break;
								}
				case "Pieton":{
								Pieton p1=new Pieton(getFrame(), getAddImage());
								p1.draw();
								break;
								}
				case "Indicator":{
								Indicator i1=new Indicator(getFrame(), getAddImage());
								i1.draw();
								break;
								}
				case "Semafor":{
								Semafor s1=new Semafor(getFrame(), getAddImage());
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
