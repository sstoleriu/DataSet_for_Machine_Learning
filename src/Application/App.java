package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import static marvin.MarvinPluginCollection.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frame;
	private MarvinImagePanel imagePanel; 
	private MarvinImage	image;  
	private MarvinImage backupImage;
	private JButton Add_Image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		Add_Image();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DataSet");
		frame.getContentPane().setLayout(null);
		
		Add_Image = new JButton("Add Image");
		Add_Image.setBounds(839, 152, 187, 41);
		frame.getContentPane().add(Add_Image);
		
		JButton Select_Object = new JButton("Select Object");
		Select_Object.setBounds(839, 220, 187, 41);
		frame.getContentPane().add(Select_Object);
		
		JButton Export = new JButton("Export");
		Export.setBounds(839, 288, 187, 41);
		frame.getContentPane().add(Export);
	}
	
	
	public void Add_Image() {
		Add_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
				
				if (response == JFileChooser.APPROVE_OPTION) {
					File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
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
	
	
}
