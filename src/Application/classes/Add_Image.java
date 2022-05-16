package Application.classes;

import static marvin.MarvinPluginCollection.scale;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Add_Image {
	
	private JButton Add_Image,
					export,
					tagmenu,
					refresh,
					help,
					icons,
					credits;
	private JFrame frame;
	private File file;
	private static MarvinImagePanel imagePanel;
	private static MarvinImage	image;  
	private MarvinImage backupImage;
	private MarvinImage rcImage;
	private static JComboBox<String> selectObjectVar;
	private ComboBox combobox;
	private static Vector<String> names=new Vector<>();
	private static Vector<Color> colors=new Vector<>();
	private static boolean drawEnabled = false;
	
	public Add_Image() {
	}
	
	public Add_Image(JFrame frame, JButton Add_Image, JComboBox<String> selectObject, JButton export, JButton tagmenu, ComboBox combobox, JButton refresh, JButton help, JButton icons, JButton credits) {
		this.frame = frame;
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
		image = new FileManager().getBackground();
		imagePanel = new MarvinImagePanel();
		imagePanel.setBounds(10, 10, 800, 543);
		imagePanel.setOpaque(false);
		frame.getContentPane().add(imagePanel);
		imagePanel.setImage(new FileManager().getBackground());
		Add_Image add_imageTemp = this;
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
		selectObject selectObject = new selectObject(frame, add_imageTemp, export, refresh);
		Add_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(selectObject.listNotEmpty()) {
						selectObject.listEmpty();
					}
					JFileChooser fileChooser = new JFileChooser();
					int response = fileChooser.showOpenDialog(frame);
					if(response == JFileChooser.APPROVE_OPTION) {
						file = new File(fileChooser.getSelectedFile().getAbsolutePath());
						image.clear();
						image = MarvinImageIO.loadImage(file.toString());
				        backupImage = image.clone();
				        scale(backupImage, image, 800, 543);
				        rcImage=image.clone();
				        imagePanel.setImage(image);
				        imagePanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
						export.setEnabled(true);
						refresh.setEnabled(true);
						selectObjectVar.setEnabled(true);
						if(drawEnabled == false) {
							moveDataSet(drawEnabled);
							selectObject.createObjectAndDraw();
							drawEnabled = true;
						}
					}
				} catch (NoSuchElementException e1) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please insert an image", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
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
	public static MarvinImage getImage() {
		return image;
	}
	public void refreshImage() {
		imagePanel.setImage(rcImage);
		image = rcImage.clone();
	}
	public static MarvinImagePanel geImagePanel() {
		return imagePanel;
	}
	public static JComboBox<String> getComboBox() {
		return selectObjectVar;
	}
	public MarvinImage getrcImage() {
		return rcImage;
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
		MarvinImagePanel panel = new MarvinImagePanel();
		panel.setBounds(865, 5, 64, 64);
		panel.setImage(new FileManager().getMovedDataSet("moveDataSet.png"));
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
	}
}
