package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;

import Application.interfaces.Obiect;

public class Refresh {

	private JButton refresh;
	private static Vector<Obiect> listOfObjects;
	private static ActionListener refreshAction;
	private static boolean createdBooleanRefresh = false;
	private static JDrawPanel drawPanel;
	
	public Refresh(JButton refresh, Vector<Obiect> listOfObjects, JDrawPanel drawPanel) {
		this.refresh = refresh;
		Refresh.listOfObjects = listOfObjects;
		Refresh.drawPanel = drawPanel;
	}
	
	public void giveList(Vector<Obiect> listOfObjects) {
		Refresh.listOfObjects = listOfObjects;
	}
	
	public void load() {
		refreshAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					drawPanel.clear();
				} catch (IOException e1) {}
				listOfObjects.clear();
			}
		};
		if(createdBooleanRefresh == false) {
			refresh.addActionListener(refreshAction);
			createdBooleanRefresh = true;
		}
	}
	
}
