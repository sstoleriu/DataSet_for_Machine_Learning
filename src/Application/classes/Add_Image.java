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
	
	public Image getImageDraw() {
		return imageDraw;
	}
	public Vector<String> getNames() {
		return names;
	}
	public Vector<Color> getColors() {
		return colors;
	}
	public File getFileAdd_image(){
		return this.file;
	}
	public static JComboBox<String> getComboBox() {
		return selectObjectVar;
	}
	public JFrame getFrame() {
		return frame;
	}
	
	public void changeMainIcons(int cont) {
		Add_Image.setIcon(new FileManager().getIcon(cont+"insert.png"));
		export.setIcon(new FileManager().getIcon(cont+"export.png"));
		tagmenu.setIcon(new FileManager().getIcon(cont+"tagmenu.png"));
		refresh.setIcon(new FileManager().getIcon(cont+"refresh.png"));
		help.setIcon(new FileManager().getIcon(cont+"help.png"));
		icons.setIcon(new FileManager().getIcon(cont+"icons.png"));
	}
	
	public void moveDataSet(boolean ok) {
		JLabel panel = new JLabel(new FileManager().getIcon("moveDataSet.png"));
		panel.setBounds(865, 5, 64, 64);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
	}
}
