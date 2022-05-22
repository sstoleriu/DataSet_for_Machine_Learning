package Application.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Clasa pentru adaugarea imaginii
 */
public class Add_Image {
	
	private JButton Add_Image,
					export,
					tagmenu,
					refresh,
					help,
					icons,
					credits;
	private JFrame frame;
	private JPanel panel;
	private Image imageDraw;
	private File file;
	private static JComboBox<String> selectObjectVar;
	private ComboBox combobox;
	private static Vector<String> names=new Vector<>();
	private static Vector<Color> colors=new Vector<>();
	private static boolean drawEnabled = false;
	static Add_Image add_imageTemp;
	
	/**
	 * Metoda de adaugare imagine si initializare parametri
	 * @param frame Frame-ul setat
	 * @param panel Panou de tip JPanel in care va fi inserata imaginea
	 * @param Add_Image Butonul de adaugare de imagini
	 * @param selectObject JComboBox pentru selectare optiune obiect
	 * @param export Butonul de export
	 * @param tagmenu Butonul pentru adaugarea/editarea/stergerea de taguri
	 * @param combobox Lista care contine vectorul names - numele obiectelor
	 * @param refresh Butonul prntru reincarcarea programului
	 * @param help Butonul pentru ajutor/informatii suplimentare
	 * @param icons Butonul pentru schimbarea design-ului iconitelor de pe butoane,
	 * @param credits Butonul pentru informatii contribuitori
	 */
	public Add_Image(JFrame frame, JPanel panel, JButton Add_Image, JComboBox<String> selectObject, JButton export, JButton tagmenu, ComboBox combobox, JButton refresh, JButton help, JButton icons, JButton credits) {
		this.frame = frame;
		this.panel = panel;
		this.Add_Image = Add_Image;
		Application.classes.Add_Image.selectObjectVar = selectObject;
		this.export = export;
		this.tagmenu = tagmenu;
		this.combobox = combobox;
		this.refresh = refresh;
		this.help = help;
		this.icons = icons;
		this.credits = credits;
	}
	
	/**
	 * Metoda de incarcare a imaginii
	 * Initializare imagine, TagMenu, Helper
	 * Optiunea de selectare a obiectului din lista de obiecte
	 * Adaugarea imaginii: alegerea dintr-un folder local si inserarea in aplicatie
	 * Desenare chenar
	 * Optiunea de exportare a imaginilor din chenare
	 * @throws IOException Exceptie de input/output
	 * 
	 */
	public void load() throws IOException {
		add_imageTemp = this;
		TagMenu menuTag = new TagMenu(tagmenu, combobox, frame, selectObjectVar, frame.getX(), frame.getY());
		Helper help = new Helper(this.help, credits, frame.getX()+frame.getWidth(), frame.getY());
		ChangeIcons cIcons = new ChangeIcons(icons, add_imageTemp, menuTag, help);
		menuTag.initialize_tags();
		menuTag.initialize_tagbtn();
		menuTag.initialize_menubuttons();
		help.load();
		cIcons.load();
		selectObjectVar = TagMenu.getSelectObjectVar();
		selectObjectVar.setEnabled(false);
		names = TagMenu.getVectorName();
		colors = TagMenu.getVectorColor();
		JLabel StartMenu = new JLabel(new FileManager().getIcon("startDataSet.png"));
		panel.add(StartMenu, BorderLayout.WEST);
		Add_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(frame);
				if(response == JFileChooser.APPROVE_OPTION) {
					file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					try {
						imageDraw = ImageIO.read(fileChooser.getSelectedFile().getAbsoluteFile());
					} catch (IOException e1) {
						System.out.println(e1);
					}	
					DrawStart startDrawing = new DrawStart(panel, refresh, export, names, colors, imageDraw);
					try {	
						startDrawing.StartDrawing();
						panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
						panel.remove(StartMenu);
						export.setEnabled(true);
						refresh.setEnabled(true);
						selectObjectVar.setEnabled(true);
						if(drawEnabled == false) {
							moveDataSet(drawEnabled);
							drawEnabled = true;
						}
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (NullPointerException e1) {
						JFrame mesaj = new JFrame();
						JOptionPane.showMessageDialog(mesaj,"Please insert an image", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
						mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					} catch (IOException e1) {
						System.out.println(e1);
					}
				}
			}
		});
	}
	
	/**
	 * Getter pentru preluarea imaginii pe care se vor selecta portiuni de decupare
	 * @return imagineDraw imaginea pe care se vor desena chenare
	 */
	public Image getImageDraw() {
		return imageDraw;
	}
	
	/**
	 * Getter pentru preluarea numelor obiectelor care se creeaza
	 * @return names numele obiectelor alese din lista de obiecte 
	 */
	public Vector<String> getNames() {
		return names;
	}
	
	/**
	 * Getter pentru returnarea culorilor chenarelor
	 * @return colors culorile chenarelor atribuite in functie de tag-ul selectat
	 */
	public Vector<Color> getColors() {
		return colors;
	}
	
	/**
	 * Getter pentru preluarea imaginii adaugate de tip File 
	 * @return file Fisierul cu imaginea adaugata
	 */
	public File getFileAdd_image(){
		return this.file;
	}
	
	/**
	 * Getter pentru returnarea listei cu optiunile de selectare a obiectelor
	 * @return obiectul selectat 
	 */
	public static JComboBox<String> getComboBox() {
		return selectObjectVar;
	}
	
	/**
	 * Getter pentru preluarea frame-ului
	 * @return frame Frame-ul setat
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Metoda pentru schimbarea design-ului iconitelor butoanelor la apasarea butonului Icons
	 * @param cont parametru de tip contor al numarului de apasari
	 */
	public void changeMainIcons(int cont) {
		Add_Image.setIcon(new FileManager().getIcon(cont+"insert.png"));
		export.setIcon(new FileManager().getIcon(cont+"export.png"));
		tagmenu.setIcon(new FileManager().getIcon(cont+"tagmenu.png"));
		refresh.setIcon(new FileManager().getIcon(cont+"refresh.png"));
		help.setIcon(new FileManager().getIcon(cont+"help.png"));
		icons.setIcon(new FileManager().getIcon(cont+"icons.png"));
	}
	
	/**
	 * Metoda de mutare a imaginii de intampinare deasupra butonului Helper
	 * @param ok Flag care indica daca mutarea va fi sau nu facuta
	 */
	public void moveDataSet(boolean ok) {
		JLabel panel = new JLabel(new FileManager().getIcon("moveDataSet.png"));
		panel.setBounds(865, 5, 64, 64);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
	}
}
