package Application.classes;

import static marvin.MarvinPluginCollection.scale;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Add_Image {
	
	private JButton Add_Image;
	private JButton export;
	private JButton tagmenu;
	private JButton refresh;
	private JButton help;
	private static MarvinImagePanel imagePanel; 
	private static MarvinImage	image;  
	private MarvinImage backupImage;
	private MarvinImage rcImage;
	private JFrame frame;
	private File file;
	private static JComboBox<String> selectObjectVar;
	private Vector<String> names=new Vector<>();
	private Vector<Color> colors=new Vector<>();
	private static boolean remessage=true;
	private ComboBox combobox;
	
	public Add_Image(JFrame frame, JButton Add_Image, JComboBox<String> selectObject, JButton export, JButton tagmenu, ComboBox combobox, JButton refresh, JButton help) {
		this.frame = frame;
		this.Add_Image = Add_Image;
		Application.classes.Add_Image.selectObjectVar = selectObject;
		this.export = export;
		this.tagmenu = tagmenu;
		this.combobox = combobox;
		this.refresh = refresh;
		this.help = help;
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
	
	public void remessage() {
		remessage = false;
	}
	
	public static MarvinImagePanel geImagePanel() {
		return imagePanel;
	}
	public void Load() throws IOException {
		TagMenu menuTag = new TagMenu(tagmenu,combobox,frame,selectObjectVar);
		menuTag.initialize_tags();
		menuTag.initialize_tagbtn();
		menuTag.initialize_menubuttons();
		Add_Image add_imageTemp = this;
		Help helpMsg = new Help( help, export, refresh);
		helpMsg.load(remessage);
		selectObjectVar = TagMenu.getSelectObjectVar();
		names = TagMenu.getVectorName();
		colors = TagMenu.getVectorColor();
		Add_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser;
				int response;
				try {
					fileChooser = new JFileChooser();
					response = fileChooser.showOpenDialog(null);
					if(response == JFileChooser.APPROVE_OPTION) {
						file = new File(fileChooser.getSelectedFile().getAbsolutePath());
						System.out.println(file.toString());
						imagePanel = new MarvinImagePanel();
						imagePanel.setBounds(10, 10, 800, 543);
						frame.getContentPane().add(imagePanel);
						image = MarvinImageIO.loadImage(file.toString());
				        backupImage = image.clone();
				        scale(backupImage, image, 800, 543);
				        rcImage=image.clone();
				        imagePanel.setImage(image);
				        selectObject selectObject = new selectObject(frame, add_imageTemp, selectObjectVar, export, refresh, imagePanel, rcImage, selectObjectVar, names, colors);
						selectObject.createObjectAndDraw();
						helpMsg.load(remessage);
					}
				} catch (NoSuchElementException e1) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please insert an image", "Warning", JOptionPane.WARNING_MESSAGE);
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
	}
}
