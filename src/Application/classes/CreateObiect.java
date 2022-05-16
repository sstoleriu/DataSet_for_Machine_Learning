package Application.classes;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Application.interfaces.Obiect;

public class CreateObiect {

	private JFrame frame;
	private Add_Image Add_ImageTemp;
	private JComboBox<String> selectObject;
	private Vector<Obiect> listOfObjects = new Vector<Obiect>();
	private Vector<String> names=new Vector<>();
	private Vector<Color> colors=new Vector<>();
	private JButton export,
					refresh;
	private CreateObiect CreateObiectTemp = this;
	
	CreateObiect(){	
	}
	
	public void createObjectDraw() {
		
		
		
		//Export exportImage = new Export(frame, export, Add_ImageTemp, CreateObiectTemp);
		//exportImage.load();
		Refresh refreshImage = new Refresh(refresh, listOfObjects, Add_ImageTemp);
		refreshImage.load();
	}
	
	public Vector<Obiect> getListOfObjects(){
		return this.listOfObjects;
	}
	
	public boolean listNotEmpty() {
		if(listOfObjects.isEmpty())
			return false;
		return true;
	}
	
	public void listEmpty() {
		listOfObjects.clear();
	}
	
}
