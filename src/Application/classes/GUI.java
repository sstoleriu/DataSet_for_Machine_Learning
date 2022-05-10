package Application.classes;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUI {
	
	private JFrame frame;
	private JButton Add_Image;
	private JButton Select_Object;
	private JButton Export;
	private static JComboBox<String> selectObjectVar;
	
	
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		Add_Image imagine = new Add_Image(frame, Add_Image, selectObjectVar, Export);
		imagine.Load();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Adaugare frame
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 600);
		
		/**
		 *  Optiunea de EXIT
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DataSet");
		frame.getContentPane().setLayout(null);
		
		/**
		 * Buton de adaugare imagine
		 */
		Add_Image = new JButton("Add Image");
		Add_Image.setBounds(839, 152, 187, 41);
		frame.getContentPane().add(Add_Image);
		
		/**
		 * Buton de selectare obiect
		 */
		Select_Object = new JButton("Select Object");
		Select_Object.setBounds(839, 220, 187, 41);
		frame.getContentPane().add(Select_Object);
		
		/**
		 * Buton de export
		 */
		Export = new JButton("Export");
		Export.setBounds(839, 288, 187, 41);
		frame.getContentPane().add(Export);		
		
		/**
		 * Optiuni de selectare
		 */
		String[] optionsToChoose = {"Masina", "Bicicleta", "Motocicleta", "Cladire","Pieton","Indicator","Semafor"};
		selectObjectVar = new JComboBox<>(optionsToChoose);
		selectObjectVar.setBounds(839, 400, 187, 41);
		frame.getContentPane().add(selectObjectVar);
	}

		public JFrame getFrame() {
			return frame;
		}
		
		/**
		 * Getter pentru preluarea obiectului selectat
		 * @return selectObjectVar Obiect selectat
		 */
		public static JComboBox<String> getSelectObjectVar(){
			return selectObjectVar;
		}
}
