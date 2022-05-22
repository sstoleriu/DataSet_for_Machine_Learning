package Application.classes;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Clasa pentru crearea listei care contine vectorul cu numele obiectelor
 */
public class ComboBox {
	private JFrame frame;
	private JComboBox<String> selectObjectVar = new JComboBox<String>();
	
	/**
	 * Constructorul clasei
	 * Initializeaza cu null frame-ul setat inainte de adaugare imagine 
	 * Initializeaza cu null lista de obiecte selectate inainte de alegere
	 */
	ComboBox(){
		frame=null;
		selectObjectVar=null;
	}
	
	/**
	 * Metoda pentru modificare ComboBox
	 * @param frame Frame-ul setat
	 * @param names numele obiectelor selectate
	 */
	public void modComboBox(JFrame frame, Vector<String> names){
		this.frame = frame;
		selectObjectVar = new JComboBox<String>(names);
		selectObjectVar.setBounds(839, 409, 187, 41);
		this.frame.getContentPane().add(selectObjectVar);
		SwingUtilities.updateComponentTreeUI(this.frame);
	}
	
	/**
	 * Getter pentru preluarea obiectelor alese din lista existenta
	 * @return selectObjectVar obiectele selectate
	 */
	public JComboBox<String> getcomboBox(){
		return selectObjectVar;
	}
}
