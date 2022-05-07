package Application.classes;

import static marvin.MarvinPluginCollection.scale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Add_Image {
	
	private static MarvinImagePanel imagePanel; 
	private static MarvinImage	image;  
	private MarvinImage backupImage;
	private JButton Add_Image;
	private JFrame frame;
	private static File file;
	private static JComboBox<String> selectObjectVar;
	private JButton export;
	
	public Add_Image(JFrame frame, JButton Add_Image, JComboBox<String> selectObject, JButton export) {
		this.frame = frame;
		this.Add_Image = Add_Image;
		this.selectObjectVar = selectObject;
		this.export = export;
	}
	
	public File getFileAdd_image(){
		return this.file;
	}
	
	public static MarvinImage getImage() {
		return image;
	}
	
	public static MarvinImagePanel geImagePanel() {
		return imagePanel;
	}
	
	public void Load() {
		Add_Image add_imageTemp = this;
		Add_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
				
				if (response == JFileChooser.APPROVE_OPTION) {
					file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					System.out.println(file.toString());
					imagePanel = new MarvinImagePanel();
					imagePanel.setBounds(10, 10, 800, 543);
					frame.getContentPane().add(imagePanel);
					image = MarvinImageIO.loadImage(file.toString());
			        backupImage = image.clone();
			        scale(backupImage, image, 800, 543);
			        MarvinImage cropImage=image.clone();
			        imagePanel.setImage(image);
			        selectObject selectObject = new selectObject(frame, add_imageTemp, selectObjectVar, export,cropImage);
					selectObject.createObjectAndDraw();
				}
			}
		});
	}

}
