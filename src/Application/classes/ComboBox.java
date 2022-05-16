package Application.classes;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ComboBox {
	private JFrame frame;
	private JComboBox<String> selectObjectVar = new JComboBox<String>();
	
	ComboBox(){
		frame=null;
		selectObjectVar=null;
	}
	
	public void modComboBox(JFrame frame, Vector<String> names){
		this.frame = frame;
		selectObjectVar = new JComboBox<String>(names);
		selectObjectVar.setBounds(839, 389, 187, 41);
		this.frame.getContentPane().add(selectObjectVar);
		SwingUtilities.updateComponentTreeUI(this.frame);
	}
	
	public JComboBox<String> getcomboBox(){
		return selectObjectVar;
	}
}
