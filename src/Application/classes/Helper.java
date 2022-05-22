package Application.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Clasa pentru afisarea de informatii ajutatoare la apasare butonului Helper si Credits
 */
public class Helper {
	
	/**
	 * Declararea tuturor butoanelor existente pentru care vor fi afisate informatii ajutatoare
	 */
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
	private int X,
				Y;
	
	/**
	 * Constructor de initializare cu parametri
	 * @param help Buton pentru afisarea de informatii despre butoanele existente
	 * @param credits Buton pentru afisarea de informatii despre contribuitori
	 * @param X
	 * @param Y
	 */
	Helper(JButton help, JButton credits, int X, int Y){
		this.help = help;
		btnCredits = credits;
		this.X = X;
		this.Y = Y;
	}
	
	/**
	 * Metoda de incarcare pentru initializarea frame-ului Helper
	 * Adaugarea de imagine de tip icons pe buton
	 * Inserarea de text explicativ in frame
	 * Adaugarea de actiune la apasarea mouse-ului pentru toate butoanele existente:
	 * - contine informatii de utilizare pentru toate butoanele existene
	 * Adaugarea de actiune la apasarea mouse-ului pentru butonul Credits
	 *  - contine informatii despre contribuitori
	 */
	public void load() throws IOException {

		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new FileManager().getIcon("helpmenu.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 601);
		frame.setLocation(X,Y);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Helper");
		frame.setIconImage(new FileManager().getImage("iconDataSet.png"));
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                OK=false;
	                frame.setLocation(X,Y);
	        }
	    });
		JEditorPane textHelp = new JEditorPane();
		textHelp.setBounds(10, 15, 364, 68);
		textHelp.setEditable(false);
		textHelp.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		textHelp.setContentType("text/html");
		textHelp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textHelp.setText("<center><span style=\"font-family:'Comic Sans MS'; color:white;\" >Welcome to the helper of DataSet!<br>"
				+ "Press the buttons to get info about them from DataSet's brother, DataHelp<br>"
				+ "The following buttons are for the main menu</span>");
		frame.getContentPane().add(textHelp);
		
		btnAddImage = new JButton("Insert image");
		btnAddImage.setFocusable(false);
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhuhu, with this button you will\r\n"
						+ "Insert an image in the program.\r\n"
						+ "It will also enable the other functions\r\n","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE,new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAddImage.setBounds(30, 93, 143, 56);
		btnAddImage.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnAddImage);
		
		btnTagMenu = new JButton("Tag menu");
		btnTagMenu.setFocusable(false);
		btnTagMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhu, this button will open the tag menu\r\n"
						+ "In this menu you can add/edit/delete tags\r\n","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
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
				JOptionPane.showMessageDialog(mesaj,"Buhu, this button will clean the image\r\n"
						+ "So that you can draw other rectangles","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnRefresh.setBounds(30, 160, 143, 56);
		btnRefresh.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnRefresh);
		
		btnExport = new JButton("Export");
		btnExport.setFocusable(false);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"With this button you will export\r\n"
						+ "All drawn rectangles on the image\r\n"
						+ "Simply choose a folder, buhuhu\r\n"
						+ "And we will save them there","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
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
		btnNewTag.setFocusable(false);
		btnNewTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This button creates a new tag\r\n"
						+ "Buhuhu, but keep this in mind\r\n"
						+ "No null name nor an existing one\r\n","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewTag.setBounds(30, 260, 143, 56);
		btnNewTag.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnNewTag);
		
		btnEditName = new JButton("Name");
		btnEditName.setFocusable(false);
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhuhu, with this button you change\r\n"
						+ "The names of your existing tags","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditName.setBounds(209, 260, 143, 56);
		btnEditName.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnEditName);
		
		btnEditColor = new JButton("Color");
		btnEditColor.setFocusable(false);
		btnEditColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhuhu, with this button you change\r\n"
						+ "The colors of your existing tags","Info bufufu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnEditColor.setBounds(30, 327, 143, 56);
		btnEditColor.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnEditColor);
		
		btnDeleteTag = new JButton("Delete");
		btnDeleteTag.setFocusable(false);
		btnDeleteTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhu, unwanted tag in your list?\r\n"
						+ "Fear not, my user! This button!\r\n"
						+ "Will delete it for you, buhuhu!","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
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
		btnDrawing.setFocusable(false);
		btnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhuhu, first you will need to add an image\r\n"
						+ "Then draw an rectangle with two clicks\r\n"
						+ "Surround the wanted object with your rectangle","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDrawing.setBounds(30, 427, 143, 56);
		btnDrawing.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnDrawing);
		
		btnDelTag = new JButton("Deleting");
		btnDelTag.setFocusable(false);
		btnDelTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhu, this is a little info\r\n"
						+ "You cannot delete your last tag","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDelTag.setBounds(209, 427, 143, 56);
		btnDelTag.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnDelTag);
		
		btnExporting = new JButton("Exporting");
		btnExporting.setFocusable(false);
		btnExporting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Buhu, your wanted cropped images?\r\n"
						+ "Properly saved in your chosen folder\r\n"
						+ "With correct names and numbers ","Info buhuhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExporting.setBounds(30, 494, 143, 56);
		btnExporting.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnExporting);
		
		btnWarning = new JButton("Warning");
		btnWarning.setFocusable(false);
		btnWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Please, do not attempt this\r\n"
						+ "Trying to modify our files\r\n","Warning info buhu!",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("DataHelp.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnWarning.setBounds(209, 494, 143, 56);
		btnWarning.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(btnWarning);
		
		help.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(OK) {
					frame.setVisible(false);
					frame.setLocation(X,Y);
					OK=false;
				}
				else {
					frame.setVisible(true);
					OK=true;
				}
			}
		});
		
		btnCredits.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Students from AC Iasi\r\n"
						+ "-Stoleriu Stefan-\r\n"
						+ "-Ignat Mihaela-Loredana-\r\n"
						+ "-Brailescu Andrei-\r\n"
						+ "-Leonte Gabriel-\r\n"
						+ "Icons by Icongeek26 on flaticon.com\r\n"
						+ "Icons by Freepik on flaticon.com\r\n"
						+ "Mascots by MrHamster on flaticon.com\r\n","Credits",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("info.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	
	/**
	 * Metoda pentru schimbarea design-ului Butonului Helper in functie de numarul de apasari ale butonului Icons
	 * @param cont Numarul de apasari ale butonului Icons
	 */
	public void changeHelpIcons(int cont) {
		btnAddImage.setIcon(new FileManager().getIcon(cont+"insert.png"));
		btnTagMenu.setIcon(new FileManager().getIcon(cont+"tagmenu.png"));
		btnRefresh.setIcon(new FileManager().getIcon(cont+"refresh.png"));
		btnExport.setIcon(new FileManager().getIcon(cont+"export.png"));
		btnNewTag.setIcon(new FileManager().getIcon(cont+"add.png"));
		btnEditColor.setIcon(new FileManager().getIcon(cont+"color.png"));
		btnEditName.setIcon(new FileManager().getIcon(cont+"name.png"));
		btnDeleteTag.setIcon(new FileManager().getIcon(cont+"delete.png"));
		btnDrawing.setIcon(new FileManager().getIcon(cont+"draw.png"));
		btnDelTag.setIcon(new FileManager().getIcon(cont+"deltag.png"));
		btnExporting.setIcon(new FileManager().getIcon(cont+"exporting.png"));
		btnWarning.setIcon(new FileManager().getIcon(cont+"warning.png"));
		btnCredits.setIcon(new FileManager().getIcon(cont+"credits.png"));
	}

}
