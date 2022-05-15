package Application.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Helper {
	
	private JButton help,
					btnAddImage,
					btnTagMenu,
					btnRefresh,
					btnExport,
					btnNewTag,
					btnEditColor,
					btnEditName,
					btnDeleteTag,
					btnDrawing,
					btnDelTag,
					btnExporting,
					btnWarning,
					btnCredits;
	private boolean OK=false;
	
	Helper(JButton help, JButton credits){
		this.help = help;
		btnCredits = credits;
	}
	
	public void load() {
		//Help frame//
		
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new FileGet().getIcon("helpmenu.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 601);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Helper");
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                OK=false;
	        }
	    });
		//"font-family:'Comic Sans MS'
		JEditorPane textHelp = new JEditorPane();
		textHelp.setBounds(10, 15, 364, 68);
		textHelp.setEditable(false);
		textHelp.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		textHelp.setContentType("text/html");
		textHelp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textHelp.setText("<center><span style=\"font-family:'Comic Sans MS'; color:white;\" >Welcome to the helper of DataSet!<br>"
				+ "Press the buttons to get info about them<br>"
				+ "The following buttons are for the main menu</span>");
		frame.getContentPane().add(textHelp);
		
		
		btnAddImage = new JButton("Insert image");
		btnAddImage.setFocusPainted(false);
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will be used for inserting the image that you want to use\r\n"
						+ "It is needed to enable the button [Refresh], the button [Export] and the tag list\r\n"
						+ "Inserting something other than images will display the following warning\r\n"
						+ "Warning: Please insert an image","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnAddImage.setBounds(30, 93, 143, 56);
		btnAddImage.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnAddImage);
		
		btnTagMenu = new JButton("Tag menu");
		btnTagMenu.setFocusPainted(false);
		btnTagMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will open the tag menu\r\n"
						+ "The menu has a list in which the curent existing tags are deposited\r\n"
						+ "Selecting a tag from the list will display the tag's color \r\n"
						+ "The color will be shown in a rectangle situated at the left bottom of the menu","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnTagMenu.setBounds(209, 93, 143, 56);
		btnTagMenu.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnTagMenu);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFocusPainted(false);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button is disabled until an image is added\r\n"
						+ "You can do that by pressing the button [Insert image]\r\n"
						+ "After inserting an image the button will be able to refresh the image\r\n"
						+ "You can use the button to remove all the tags and create others","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnRefresh.setBounds(30, 160, 143, 56);
		btnRefresh.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnRefresh);
		
		btnExport = new JButton("Export");
		btnExport.setFocusPainted(false);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button is disabled until an image is added\r\n"
						+ "You can do that by pressing the button [Insert image]\r\n"
						+ "After being pressed the button will export the drawn rectangles in a selected folder\r\n"
						+ "Not drawing any rectangle will display the following warning\r\n"
						+ "Warning: Please, select objects to export\r\n"
						+ "Successfully exporting the images will display the following message\r\n"
						+ "Message: Export done!","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExport.setBounds(209, 160, 143, 56);
		btnExport.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnExport);
			
		JEditorPane textHelp2 = new JEditorPane();
		textHelp2.setBounds(10, 227, 364, 25);
		textHelp2.setEditable(false);
		textHelp2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		textHelp2.setContentType("text/html");
		textHelp2.setText("<center><span style=\"font-family:'Comic Sans MS'; color:white;\";>The following buttons are for the tag menu<span>");
		frame.getContentPane().add(textHelp2);
		
		btnNewTag = new JButton("New");
		btnNewTag.setFocusPainted(false);
		btnNewTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to add another tag\r\n"
						+ "You'll have to insert the name that you want to use and choose a color\r\n"
						+ "The tag will get the preselected color in case of not choosing one\r\n"
						+ "You cannot add a tag with the same name neither with an empty name\r\n"
						+ "Otherwise the following warnings will be dysplayed accordingly\r\n"
						+ "Warning 1: This name is already used by another tag\r\n"
						+ "Warning 2: This name is invalid","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewTag.setBounds(30, 260, 143, 56);
		btnNewTag.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnNewTag);
		
		btnEditName = new JButton("Name");
		btnEditName.setFocusPainted(false);
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to rename a chosen tag from the list\r\n"
						+ "Not selecting the tag before pressing the button will display the following warning\r\n"
						+ "Warning: Please select the tag you want to rename\r\n"
						+ "You cannot rename a tag with a name already taken or an empty name\r\n"
						+ "Otherwise the following warnings will be dysplayed accordingly\r\n"
						+ "Warning 1: This name is already used by another tag\r\n"
						+ "Warning 2: This name is invalid","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditName.setBounds(209, 260, 143, 56);
		btnEditName.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnEditName);
		
		btnEditColor = new JButton("Color");
		btnEditColor.setFocusPainted(false);
		btnEditColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to change the color of a chosen tag from the list\r\n"
						+ "Not selecting the tag before pressing the button will display the following warning\r\n"
						+ "Warning: Please select the tag you want to change its color","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditColor.setBounds(30, 327, 143, 56);
		btnEditColor.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnEditColor);
		
		btnDeleteTag = new JButton("Delete");
		btnDeleteTag.setFocusPainted(false);
		btnDeleteTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to delete a chosen tag from the list\r\n"
						+ "Not selecting the tag before pressing the button will display the following warning\r\n"
						+ "Warning: Please select the tag you want to delete","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDeleteTag.setBounds(209, 327, 143, 56);
		btnDeleteTag.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnDeleteTag);
		
		JEditorPane textHelp3 = new JEditorPane();
		textHelp3.setBounds(10, 394, 364, 25);
		textHelp3.setEditable(false);
		textHelp3.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		textHelp3.setContentType("text/html");
		textHelp3.setText("<center><span style=\"font-family:'Comic Sans MS'; color:white;\"; >Other useful information<span>");
		frame.getContentPane().add(textHelp3);
		
		btnDrawing = new JButton("How to draw");
		btnDrawing.setFocusPainted(false);
		btnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"In order to draw you first need to insert a picture\r\n"
						+ "	Drawing an object will use the list situated in the right bottom of the main menu\r\n"
						+ "	Choose a tag and then draw on the image by clicking on a place on the image\r\n"
						+ "	The second click will create a rectangle between the two points drawing it\r\n"
						+ "	The rectangle will be drawn using the color of the chosen tag","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDrawing.setBounds(30, 427, 143, 56);
		btnDrawing.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnDrawing);
		
		btnDelTag = new JButton("Deleting");
		btnDelTag.setFocusPainted(false);
		btnDelTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"The tag list should have at least one item in it\r\n"
						+ "	Trying to remove it will display the following warning\r\n"
						+ "	Warning: The tag list should have at least one item in it. Do not remove the last tag\r\n","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDelTag.setBounds(209, 427, 143, 56);
		btnDelTag.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnDelTag);
		
		btnExporting = new JButton("Exporting");
		btnExporting.setFocusPainted(false);
		btnExporting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj," The export function will save in a folder the drawn rectangles of the inserted image\r\n"
						+ "	They will be saved as .jpg with the names \"Tag name (number)\"\r\n"
						+ "	The program will save the images over the existing ones\r\n"
						+ "	Therefore we sugest to save in different folders for each image\r\n","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExporting.setBounds(30, 494, 143, 56);
		btnExporting.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnExporting);
		
		btnWarning = new JButton("Warning");
		btnWarning.setFocusPainted(false);
		btnWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Notify: Do not attempt to modify the resources from outside the app\r\n"
						+ "	Otherwise the program will not work as intended and fatal errors will occur\r\n"
						+ "	The two files containing the names and the colors should always have the same number of lines\r\n"
						+ "	Please do not modify the files in order for the program to function properly\r\n","Warning info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnWarning.setBounds(209, 494, 143, 56);
		btnWarning.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnWarning);
		//////////////
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(OK) {
					frame.setVisible(false);
					OK=false;
				}
				else {
					frame.setVisible(true);
					OK=true;
				}
			}
		});
		
		btnCredits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"The program was made within the project from the second semester\r\n"
						+ "In the third year of university of the following students registered\r\n"
						+ "In Faculty of Automatic Control and Computer Engineering from Iasi:\r\n"
						+ "-Stoleriu Stefan-\r\n"
						+ "-Ignat Mihaela-Loredana-\r\n"
						+ "-Brailescu Andrei-\r\n"
						+ "-Leonte Gabriel-\r\n"
						+ "Added icons created by Icongeek26 from flaticon.com\r\n"
						+ "Added icons created by Freepik from flaticon.com\r\n"
						+ "Mascot created by MrHamster from flaticon.com\r\n","Credits",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	public void changeHelpIcons(int cont) {
		btnAddImage.setIcon(new FileGet().getIcon(cont+"insert.png"));
		btnTagMenu.setIcon(new FileGet().getIcon(cont+"tagmenu.png"));
		btnRefresh.setIcon(new FileGet().getIcon(cont+"refresh.png"));
		btnExport.setIcon(new FileGet().getIcon(cont+"export.png"));
		btnNewTag.setIcon(new FileGet().getIcon(cont+"add.png"));
		btnEditColor.setIcon(new FileGet().getIcon(cont+"color.png"));
		btnEditName.setIcon(new FileGet().getIcon(cont+"name.png"));
		btnDeleteTag.setIcon(new FileGet().getIcon(cont+"delete.png"));
		btnDrawing.setIcon(new FileGet().getIcon(cont+"draw.png"));
		btnDelTag.setIcon(new FileGet().getIcon(cont+"deltag.png"));
		btnExporting.setIcon(new FileGet().getIcon(cont+"exporting.png"));
		btnWarning.setIcon(new FileGet().getIcon(cont+"warning.png"));
		btnCredits.setIcon(new FileGet().getIcon(cont+"credits.png"));
	}

}
