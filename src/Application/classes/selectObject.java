package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Application.interfaces.Obiect;
import marvin.image.MarvinImage;

public class selectObject {

	private JFrame frame;
	private Add_Image Add_image;
	private JComboBox<String> selectObject;
	private Vector<Obiect> listOfObjects = new Vector<Obiect>();
	private JButton export;
	private MarvinImage cropImage;
	
	/**
	 * Constructorul clasei selectObject care initializeaza urmatorii parametri:
	 * @param frame Frame-ul in care este adaugata imaginea
	 * @param Add_Image Butonul de adaugare imagine
	 * @param selectObject Obiectul selectat dintr-o lista cu tipuri (clase existente)
	 * @param export Butonul de exportare imagini decupate
	 * @param cropImage MarvinImage
	 */
	public selectObject(JFrame frame, Add_Image Add_Image, JComboBox<String> selectObject, JButton export,MarvinImage cropImage) {
		this.selectObject = selectObject;
		this.frame = frame;
		this.Add_image = Add_Image;
		this.export = export;
		this.cropImage=cropImage;
	}

	/**
	 * Getter pentru returnarea Frame-ului
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Getter pentru returnarea imaginii adaugate
	 * @return Add_image
	 */
	public Add_Image getAddImage() {
		return Add_image;
	}
	
	/**
	 * Setter pentru initializarea imaginii adaugate
	 * @param temp Instantierea clasei Add_Image
	 */
	public void setAddImage(Add_Image temp) {
		this.Add_image = temp;
	}
	
	/**
	 * Getter de tip JComboBox care returneaza obiectul selectat din lista
	 *  -(Autobuz/Bicicleta/Cladire/Indicator/Masina/Motocicleta/Semafor/Pieton);
	 * @return selectObject Optiunea aleasa din lista
	 */
	public JComboBox<String> getSelectObject() {
		return selectObject;
	}

	/**
	 * Metoda pentru adaugarea unei imagini, selectarea optiunii si exportarea imaginilor decupate
	 */
	public void createObjectAndDraw() {
		MouseClick ms1 = new MouseClick(listOfObjects, getAddImage());
		getAddImage().geImagePanel().addMouseListener(ms1);
		Export exportImage = new Export(export, getAddImage(), this.listOfObjects,cropImage);
		exportImage.Load2();
		
		
		this.selectObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String alegere = getSelectObject().getSelectedItem().toString();
				ms1.setOptiune(alegere);
				
			}
		});

	}
	
	/**
	 * Getter pentru returnarea unui vector care contine obiectele selectate
	 * @return listOfObjects Vectorul cu obiectele alese
	 */
	public Vector<Obiect> getListOfObjects(){
		return this.listOfObjects;
	}
}
