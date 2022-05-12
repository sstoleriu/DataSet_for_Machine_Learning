package Application.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Application.interfaces.Obiect;
import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;

public class selectObject {

	private JFrame frame;
	private Add_Image Add_image;
	private JComboBox<String> selectObject;
	private Vector<Obiect> listOfObjects = new Vector<Obiect>();
	private static JComboBox<String> selectObjectVar;
	private Vector<String> names=new Vector<>();
	private Vector<Color> colors=new Vector<>();
	private JButton export;
	private JButton refresh;
	@SuppressWarnings("unused")
	private static MarvinImagePanel imagePanel;
	private MarvinImage cropImage;

	public selectObject(JFrame frame, Add_Image Add_Image, JComboBox<String> selectObject, JButton export, JButton refresh, MarvinImagePanel imagePanel, MarvinImage cropImage, JComboBox<String> selectObjectVar, Vector<String> names, Vector<Color> colors) {
		this.selectObject = selectObject;
		this.frame = frame;
		this.Add_image = Add_Image;
		this.export = export;
		this.refresh = refresh;
		Application.classes.selectObject.imagePanel = imagePanel;
		this.cropImage=cropImage;
		Application.classes.selectObject.selectObjectVar = selectObjectVar;
		this.names = names;
		this.colors = colors;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Add_Image getAddImage() {
		return Add_image;
	}
	
	public void setAddImage(Add_Image temp) {
		this.Add_image = temp;
	}

	public JComboBox<String> getSelectObject() {
		return selectObject;
	}

	public void createObjectAndDraw() {
		MouseClick ms1 = new MouseClick(listOfObjects, getAddImage(), selectObjectVar, names, colors);
		Add_Image.geImagePanel().addMouseListener(ms1);
		Export exportImage = new Export(frame, export, getAddImage(), this.listOfObjects, cropImage, selectObjectVar, names, colors);
		exportImage.load();
		Refresh refreshImage = new Refresh(refresh, this.listOfObjects, Add_image);
		refreshImage.load();
		
		this.selectObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String alegere = getSelectObject().getSelectedItem().toString();
				ms1.setOptiune(alegere);
				
			}
		});

	}

	public Vector<Obiect> getListOfObjects(){
		return this.listOfObjects;
	}
}
