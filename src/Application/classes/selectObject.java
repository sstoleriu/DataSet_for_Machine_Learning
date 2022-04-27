package Application.classes;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class selectObject {
	
	private  JFrame frame;
	private  Add_Image Add_image;
	private  JComboBox<String> selectObject;
//	static boolean isPressed = false;
	
	public selectObject(JFrame frame, Add_Image Add_Image, JComboBox<String> selectObject) {
		this.selectObject = selectObject;
		this.frame = frame;
		this.Add_image = Add_Image;
	}

	public  JFrame getFrame() {
		return frame;
	}
	
	public  Add_Image getAddImage() {
		return Add_image;
	}
	
	public  JComboBox<String> getSelectObject() {
		return selectObject;
	}
	
	
	public void createObjectAndDraw() {
//		this.selectObject.addMouseListener(new MouseAdapter() {
//		    public void mousePressed(MouseEvent e) {
//			      System.out.println(e.getX() + "," + e.getY());
//			    }
//			  });
		MouseClick ms1=new MouseClick();
		getFrame().addMouseListener(ms1);
		this.selectObject.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
			
//				isPressed=true;
				//Masina m1 = new Masina();
				String alegere = getSelectObject().getSelectedItem().toString();
				switch (alegere) {
				case "Masina": {
								
								Masina m1 = new Masina(getFrame(), getAddImage());
								m1.p1=ms1.p1;
								m1.p2=ms1.p2;
								//m1.setImage(getAddImage());
								m1.draw();
								break;
								}
				case "Bicicleta":{
								Bicicleta b1=new Bicicleta(getFrame(), getAddImage());
								b1.p1=ms1.p1;
								b1.p2=ms1.p2;
								b1.draw();
								break;
								}
				case "Autobuz":{
								Autobuz a1 = new Autobuz(getFrame(), getAddImage());
								a1.p1=ms1.p1;
								a1.p2=ms1.p2;
								a1.draw();
								break;
								}
				case "Motocicleta":{
								Motocicleta mot1=new Motocicleta(getFrame(), getAddImage());
								mot1.p1=ms1.p1;
								mot1.p2=ms1.p2;
								mot1.draw();
								break;
								}
				case "Cladire":{
								Cladire c1=new Cladire(getFrame(), getAddImage());
								c1.p1=ms1.p1;
								c1.p2=ms1.p2;
								c1.draw();
								break;
								}
				case "Pieton":{
								Pieton p1=new Pieton(getFrame(), getAddImage());
								p1.p1=ms1.p1;
								p1.p2=ms1.p2;
								p1.draw();
								break;
								}
				case "Indicator":{
								Indicator i1=new Indicator(getFrame(), getAddImage());
								i1.p1=ms1.p1;
								i1.p2=ms1.p2;
								i1.draw();
								break;
								}
				case "Semafor":{
								Semafor s1=new Semafor(getFrame(), getAddImage());
								s1.p1=ms1.p1;
								s1.p2=ms1.p2;
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
