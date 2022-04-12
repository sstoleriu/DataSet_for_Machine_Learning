package Application;

import static marvin.MarvinPluginCollection.scale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Add_Image {
	
	private MarvinImagePanel imagePanel; 
	private MarvinImage	image;  
	private MarvinImage backupImage;
	private JButton Add_Image;
	private JFrame frame;
	protected static File file;
	
	public Add_Image(JFrame frame, JButton Add_Image) {
		this.frame = frame;
		this.Add_Image = Add_Image;
	}
	
	
	public void Load() {
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
			        imagePanel.setImage(image); 
				}
			}
		});
	}

	public static void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

}
