package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Help {
	
	private JButton help;
	private boolean OK=false;
	
	Help(JButton help){
		this.help = help;
	}
	
	public void load() {
		//Help frame//
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 400, 533);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("HELP");
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                OK=false;
	        }
	    });
		
		JEditorPane textHelp = new JEditorPane();
		textHelp.setBounds(10, 15, 364, 65);
		textHelp.setEditable(false);
		textHelp.setContentType("text/html");
		textHelp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textHelp.setText("<center>Welcome to the help of DataSet!<br>"
				+ "Press the buttons to get info about them<br>"
				+ "The following buttons are for the principal menu");
		frame.getContentPane().add(textHelp);
		
		JButton btnAddImage = new JButton("Add image");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will be used for adding the image that you want to use\r\n"
						+ "It is needed to enable the button [Refresh] and the button [Export]\r\n"
						+ "Inserting something other than images will display the following warning\r\n"
						+ "Warning: Please insert an image","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnAddImage.setBounds(60, 93, 113, 56);
		frame.getContentPane().add(btnAddImage);
		
		JButton btnTagMenu = new JButton("Tag menu");
		btnTagMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will open the menu for the tags that you can use\r\n"
						+ "Opening the menu will give you access to the tags that you already have\r\n"
						+ "The tags will be presented in a list\r\n"
						+ "Selecting a tag from the list will display the tag's color \r\n"
						+ "The color will be shown in a rectangle placed at the left bottom of the menu","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnTagMenu.setBounds(209, 93, 113, 56);
		frame.getContentPane().add(btnTagMenu);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button is not visible until you will add an image first\r\n"
						+ "You can do that by using the button [Add image]\r\n"
						+ "After inserting an image the button will be able to refresh the image\r\n"
						+ "You can use the button to remove all the tags and create others","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnRefresh.setBounds(60, 160, 113, 56);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button is not visible until you will add an image first\r\n"
						+ "You can do that by using the button [Add image]\r\n"
						+ "After being pressed the button will export the drawn rectangles in a selected folder\r\n"
						+ "Not drawing any rectangle will display the following warning\r\n"
						+ "Warning: Please, select objects to export\r\n"
						+ "Successfully exporting the images will display the following message\r\n"
						+ "Message: Export done!","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExport.setBounds(209, 160, 113, 56);
		frame.getContentPane().add(btnExport);
			
		JEditorPane textHelp2 = new JEditorPane();
		textHelp2.setBounds(10, 227, 364, 22);
		textHelp2.setEditable(false);
		textHelp2.setContentType("text/html");
		textHelp2.setText("<center>The following buttons are for the tag's menu");
		frame.getContentPane().add(textHelp2);
		
		JButton btnNewTag = new JButton("New tag");
		btnNewTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to add another tag\r\n"
						+ "You'll have to insert the name that you want to use and choose a color\r\n"
						+ "The tag will get the preselected color in case of not choosing one\r\n"
						+ "You cannot add a tag with the same name neither with an empty name\r\n"
						+ "Otherwise the following warnings will be dysplayed accordingly\r\n"
						+ "Warning 1: This name is already used by another tag\r\n"
						+ "Warning 2: This name is invalid","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewTag.setBounds(60, 260, 113, 56);
		frame.getContentPane().add(btnNewTag);
		
		JButton btnEditName = new JButton("Edit name");
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to rename a chosen tag from the list\r\n"
						+ "Not selecting the tag before pressing the button will display the following warning\r\n"
						+ "Warning: Please select the tag you want to rename\r\n"
						+ "You cannot rename a tag with a name already taken or an empty name\r\n"
						+ "Otherwise the following warnings will be dysplayed accordingly\r\n"
						+ "Warning 1: This name is already used by another tag\r\n"
						+ "Warning 2: This name is invalid","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditName.setBounds(209, 260, 113, 56);
		frame.getContentPane().add(btnEditName);
		
		JButton btnEditColor = new JButton("Edit color");
		btnEditColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to change the color of a tag chosen from the list\r\n"
						+ "Not selecting the tag before pressing the button will display the following warning\r\n"
						+ "Warning: Please select the tag you want to change its color","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditColor.setBounds(60, 327, 113, 56);
		frame.getContentPane().add(btnEditColor);
		
		JButton btnDeleteTag = new JButton("Delete tag");
		btnDeleteTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to delete a chosen tag from the list\r\n"
						+ "Not selecting the tag before pressing the button will display the following warning\r\n"
						+ "Warning: Please select the tag you want to delete","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDeleteTag.setBounds(209, 327, 113, 56);
		frame.getContentPane().add(btnDeleteTag);
		
		JEditorPane textHelp3 = new JEditorPane();
		textHelp3.setBounds(10, 394, 364, 22);
		textHelp3.setEditable(false);
		textHelp3.setContentType("text/html");
		textHelp3.setText("<center>Other useful information");
		frame.getContentPane().add(textHelp3);
		
		JButton btnDrawing = new JButton("How to draw");
		btnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"In order to draw you first need to insert a picture\r\n"
						+ "	Drawing an object will use the list situated in the bottom right of the principal menu\r\n"
						+ "	Choose a tag and then draw on the image by clicking on a place on the image\r\n"
						+ "	The second click will create a rectangle between the two points drawing it\r\n"
						+ "	The rectangle will be drawn using the color of the chosen tag","Info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDrawing.setBounds(60, 427, 113, 56);
		frame.getContentPane().add(btnDrawing);
		
		JButton btnNewTag_2 = new JButton("Warning");
		btnNewTag_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"The tag list should have at least one item in it\r\n"
						+ "	Trying to remove all the items will display the following warning\r\n"
						+ "	Warning: The tag list should have at least one item in it. Do not remove the last tag\r\n"
						+ "	Please do not try and modify the files outside from the tag's menu\r\n"
						+ "	Leave at least on line in each file, both should have the same number of lines\r\n"
						+ "	Otherwise the program will most likely not work as intended and other errors will occur\r\n","Warning info",JOptionPane.INFORMATION_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewTag_2.setBounds(209, 427, 113, 56);
		frame.getContentPane().add(btnNewTag_2);
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
	}

}
