package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import Application.interfaces.Obiect;

public class Refresh {

	private Add_Image Add_image;
	private JButton refresh;
	private Vector<Obiect> listOfObjects = new Vector<Obiect>();
	
	public Refresh(JButton refresh, Vector<Obiect> listOfObjects, Add_Image Add_image) {
		this.refresh = refresh;
		this.listOfObjects = listOfObjects;
		this.Add_image = Add_image;
	}
	
	public void load() {
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listOfObjects.clear();
				Add_image.refreshImage();
			}
		});
		
	}
	
}
