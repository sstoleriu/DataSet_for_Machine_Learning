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
	private static ActionListener refreshAction;
	private static boolean createdBooleanRefresh = false;
	
	Refresh(){
	}
	
	public Refresh(JButton refresh, Vector<Obiect> listOfObjects, Add_Image Add_image) {
		this.refresh = refresh;
		this.listOfObjects = listOfObjects;
		this.Add_image = Add_image;
	}
	
	public void load() {
		refreshAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listOfObjects.clear();
				Add_image.refreshImage();
				new MouseClick().refresh();
			}
		};
		if(createdBooleanRefresh == false) {
			refresh.addActionListener(refreshAction);
			createdBooleanRefresh = true;
		}
	}
	
}
