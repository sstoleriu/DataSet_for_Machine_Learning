package Application.classes;

import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUI {
	
	private JFrame frame;
	private JButton Add_Image;
	private JButton Tag_Menu;
	private JButton Export;
	private JButton Refresh;
	private JButton Help;
	private static JComboBox<String> selectObjectVar;
	private ComboBox combobox = new ComboBox();
	
	
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		initialize();
		Add_Image imagine = new Add_Image(frame, Add_Image, selectObjectVar, Export, Tag_Menu, combobox, Refresh, Help);
		imagine.Load();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DataSet");
		frame.getContentPane().setLayout(null);
		
		Help = new JButton("Help");
		Help.setBounds(839, 49, 187, 41);
		frame.getContentPane().add(Help);
		
		Refresh = new JButton("Refresh");
		Refresh.setBounds(839, 121, 187, 41);
		frame.getContentPane().add(Refresh);
		Refresh.setEnabled(false);
		
		Add_Image = new JButton("Add image");
		Add_Image.setBounds(839, 193, 187, 41);
		frame.getContentPane().add(Add_Image);
		
		Tag_Menu = new JButton("Tag menu");
		Tag_Menu.setBounds(839, 265, 187, 41);
		frame.getContentPane().add(Tag_Menu);
		
		Export = new JButton("Export");
		Export.setBounds(839, 337, 187, 41);
		frame.getContentPane().add(Export);
		Export.setEnabled(false);
		
	}

		public JFrame getFrame() {
			return frame;
		}
}
