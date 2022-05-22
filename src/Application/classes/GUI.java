package Application.classes;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clasa pentru crearea interfata grafica
 *
 */
public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	private JButton Add_Image,
					Tag_Menu,
					Export,
					Refresh,
					Help,
					Icons,
					Credits;
	private static JComboBox<String> selectObjectVar;
	private ComboBox combobox = new ComboBox();
	
	/**
	 * Crearea aplicatiei
	 * @throws IOException Exceptie de input/output
	 */
	public GUI() throws IOException {
		initialize();
		Add_Image imagine = new Add_Image(frame, panel, Add_Image, selectObjectVar, Export, Tag_Menu, combobox, Refresh, Help, Icons, Credits);
		
		imagine.load();
	}
	
	/**
	 * Initializarea continutului frame-ului
	 * Creare si initializare: 
	 * frame setat,
	 * JPannel in care va fi adaugata imaginea
	 * Buton de ajutor/informatii suplimentare,
	 * Buton de reincarcare a programului,
	 * Buton pentru inserare imagine,
	 * Buton pentru adaugarea/editarea/stergerea de taguri,
	 * Buton pentru exportarea imaginilor decupate,
	 * Buton pentru schimbarea design-ului iconitelor de pe butoane,
	 * Buton pentru informatii contribuitori
	 * @throws IOException Exceptie de input/output
	 */
	private void initialize() throws IOException {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setContentPane(new JLabel(new FileManager().getIcon("mainmenu.png")));
		frame.setBounds(100, 100, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DataSet");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(new FileManager().getImage("iconDataSet.png"));
		
		panel = new JPanel();
		panel.setBounds(10, 10, 800, 543);
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);
		
		Help = new JButton("Helper");
		Help.setBounds(839, 49, 187, 41);
		Help.setFocusPainted(false);
		frame.getContentPane().add(Help);
		
		Refresh = new JButton("Refresh");
		Refresh.setBounds(839, 265, 187, 41);
		Refresh.setFocusPainted(false);
		frame.getContentPane().add(Refresh);
		Refresh.setEnabled(false);
		
		Add_Image = new JButton("Insert image");
		Add_Image.setBounds(839, 121, 187, 41);
		Add_Image.setFocusPainted(false);
		frame.getContentPane().add(Add_Image);
		
		Tag_Menu = new JButton("Tag menu");
		Tag_Menu.setBounds(839, 193, 187, 41);
		Tag_Menu.setFocusPainted(false);
		frame.getContentPane().add(Tag_Menu);
		
		Export = new JButton("Export");
		Export.setBounds(839, 337, 187, 41);
		Export.setFocusPainted(false);
		frame.getContentPane().add(Export);
		Export.setEnabled(false);
		
		Icons = new JButton();
		Icons.setFocusPainted(false);
		Icons.setBounds(839, 481, 90, 41);
		frame.getContentPane().add(Icons);
		
		Credits = new JButton();
		Credits.setFocusPainted(false);
		Credits.setBounds(936, 481, 90, 41);
		frame.getContentPane().add(Credits);
		
	}

		/**
		 * Getter pentru returnarea frame-ului
		 * @return frame Frame
		 */
		public JFrame getFrame() {
			return frame;
		}
}
