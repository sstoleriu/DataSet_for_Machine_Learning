package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Help {
	
	private JButton help;
	private JButton export;
	private JButton refresh;
	private boolean OK=false;
	
	Help(JButton help, JButton export, JButton refresh){
		this.help = help;
		this.export = export;
		this.refresh = refresh;
	}
	
	public void load(boolean remessage) {
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
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setWrapStyleWord(true);
		txtrWelcome.setEditable(false);
		txtrWelcome.setLineWrap(true);
		txtrWelcome.setText("Welcome to the help of DataSet!\r\n"
				+ "Here you will get a little guide on how to use the program.\r\n"
				+ "Press the buttons to get some info about them\r\n"
				+ "The following buttons are for the principal menu");
		txtrWelcome.setBounds(10, 11, 364, 71);
		frame.getContentPane().add(txtrWelcome);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button is disabled until you'll add an image first\r\n"
						+ "You can do that by using the button [Add image]\r\n"
						+ "Hovering the mouse over the button in this state will display a warning\r\n"
						+ "Warning: \"Insert image first\"\r\n"
						+ "After inserting an image the button will be able to refresh the image\r\n"
						+ "You can use the button to remove all the tags and create others");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnRefresh.setBounds(60, 93, 113, 56);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button is disabled until you'll add an image first\r\n"
						+ "You can do that by using the button [Add image]\r\n"
						+ "Hovering the mouse over the button in this state will display a warning\r\n"
						+ "Warning: \"Insert image first\"\r\n"
						+ "After being pressed the button will export the drawn rectangles in a selected folder\r\n"
						+ "Not drawing any rectangle will display another warning\r\n"
						+ "Warning: \"Please, select objects to export\"\r\n"
						+ "Successfully exporting the wanted images will display the following message\r\n"
						+ "Message: \"Export done!\"");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExport.setBounds(209, 160, 113, 56);
		frame.getContentPane().add(btnExport);
		
		JButton btnTagMenu = new JButton("Tag menu");
		btnTagMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will open the menu for the tags that you can use\r\n"
						+ "Opening the menu will give you access to the tags that you already have\r\n"
						+ "The tags will be presented in a list\r\n"
						+ "Selecting a tag from the list will display the tag's color \r\n"
						+ "The color will be shown in a rectangle placed at the left bottom of the menu");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnTagMenu.setBounds(60, 160, 113, 56);
		frame.getContentPane().add(btnTagMenu);
		
		JButton btnAddImage = new JButton("Add image");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will be used for adding the image that you want to use\r\n"
						+ "It is needed to enable the button [Refresh] and the button [Export]\r\n"
						+ "Inserting something other than images will display a warning\r\n"
						+ "Warning: \"Please insert an image\"");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnAddImage.setBounds(209, 93, 113, 56);
		frame.getContentPane().add(btnAddImage);
		
		JTextArea txtrWelcome2 = new JTextArea();
		txtrWelcome2.setWrapStyleWord(true);
		txtrWelcome2.setText("The following buttons are for the tag's menu");
		txtrWelcome2.setLineWrap(true);
		txtrWelcome2.setEditable(false);
		txtrWelcome2.setBounds(10, 227, 364, 22);
		frame.getContentPane().add(txtrWelcome2);
		
		JButton btnNewTag = new JButton("New tag");
		btnNewTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to add another tag\r\n"
						+ "You'll have to insert the name that you want to use and choose a color\r\n"
						+ "The tag will get the attributed color even though you did not choose a color\r\n"
						+ "You cannot add a tag with the same name neither with an empty name\r\n"
						+ "Otherwise a warning will be shown for each case\r\n"
						+ "Warning 1: \"This name is already used by another tag\"\r\n"
						+ "Warning 2: \"This name is invalid\"");
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
						+ "Not selecting the tag before pressing the button will display a warning\r\n"
						+ "Warning: \"Please select the tag you want to rename\"\r\n"
						+ "You cannot rename a tag with a name already taken or an empty name\r\n"
						+ "Otherwise  a warning will be shown for each case\r\n"
						+ "Warning 1: \"This name is already used by another tag. Insert new name:\"\r\n"
						+ "Warning 2: \"This name is invalid. Insert new name:\"");
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
						+ "Not selecting the tag before pressing the button will display a warning\r\n"
						+ "Warning: \"Please select the tag you want to change its color\"");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditColor.setBounds(60, 327, 113, 56);
		frame.getContentPane().add(btnEditColor);
		
		JButton btnDeleteTag = new JButton("Delete Tag");
		btnDeleteTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button will permit you to delete a chosen tag from the list\r\n"
						+ "Not selecting the tag before pressing the button will display a warning\r\n"
						+ "Warning: \"Please select the tag you want to delete\";");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDeleteTag.setBounds(209, 327, 113, 56);
		frame.getContentPane().add(btnDeleteTag);
		
		JTextArea txtrWelcome3 = new JTextArea();
		txtrWelcome3.setWrapStyleWord(true);
		txtrWelcome3.setText("Other useful information");
		txtrWelcome3.setLineWrap(true);
		txtrWelcome3.setEditable(false);
		txtrWelcome3.setBounds(10, 394, 364, 22);
		frame.getContentPane().add(txtrWelcome3);
		
		JButton btnDrawing = new JButton("Drawing");
		btnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"In order to draw you first need to insert a picture\r\n"
						+ "	Drawing an object will use the list situated in the bottom right of the principal menu\r\n"
						+ "	Choose a tag and then draw on the image by clicking on a place on the image\r\n"
						+ "	The second click will create a rectangle between the two points drawing the wanted rectangle\r\n"
						+ "	The rectangle will be drawn using the color of the chosen tag");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDrawing.setBounds(60, 427, 113, 56);
		frame.getContentPane().add(btnDrawing);
		
		JButton btnNewTag_2 = new JButton("Warnings");
		btnNewTag_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"The tag list should have at least one item in it\r\n"
						+ "	Trying to remove all the items will display a warning\r\n"
						+ "	Warning: \"The tag list should have at least one item in it. Do not remove the last tag\"\r\n"
						+ "	Please do not try and modify the files outside from the tag's menu\r\n"
						+ "	Leave at least on line in each file, both should have the same number of lines\r\n"
						+ "	Otherwise the program will most likely not work as intended and other errors will occur\r\n");
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
		
		refresh.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(remessage) {
				refresh.setToolTipText("Insert image first");
				} else {
					refresh.setToolTipText(null);
				}
			}
		});
		export.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(remessage) {
				export.setToolTipText("Insert image first");
				} else {
					export.setToolTipText(null);
				}
			}
		});	
	}

}
