package Application.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TagMenu {
	
	private JButton TagMenu,
					newtag,
					editname,
					editcolor,
					deltag,
					Add,
					cchoose;
	private static Vector<String> names=new Vector<>();
	private static Vector<Color> colors=new Vector<>();
	private Vector<Tag> tags = new Vector<>();
	private boolean OKtagm = false;
	private boolean OKaddt = false;
	private static JFrame frame_tagmenu;
	private static JFrame frame_addtag;
	private JFrame frame;
	private ComboBox combobox;
	private JTextField colortag;
	private static JComboBox<String> selectObjectVar;
	private FileName fn;
	private FileColor fc;
	private static int X;
	private static int Y;
	
	public TagMenu(JButton TagMenu, ComboBox combobox, JFrame frame,JComboBox<String> selectObjectVar, int X, int Y) {
		this.TagMenu = TagMenu;
		this.combobox = combobox;
		this.frame = frame;
		Application.classes.TagMenu.selectObjectVar = selectObjectVar;
		Application.classes.TagMenu.X = X;
		Application.classes.TagMenu.Y = Y;
	}
	
	void initialize_tags() throws IOException{
		//Initialization of Tag menu
		frame.setResizable(false);
		
		fn = new FileName();
		fc = new FileColor();
		names=fn.getlistname();
		colors=fc.getlistcolor();
		for(int i=0; i<names.size(); i++) {
			tags.add(new Tag(names.get(i),colors.get(i)));
		}
		
		combobox.modComboBox(frame, names);
		selectObjectVar = combobox.getcomboBox();
		JFrame newtagf = new JFrame();
		newtagf.setResizable(false);
		newtagf.setContentPane(new JLabel(new FileManager().getIcon("tagmenu.png")));
		newtagf.setBounds(100, 100, 293, 270);;
		newtagf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newtagf.setTitle("Tag menu");
		newtagf.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                OKtagm = false;
	        }
	    });
		
		newtagf.getContentPane().setLayout(null);
		newtagf.setVisible(false);
		
		newtag = new JButton("New");
		newtag.setFocusPainted(false);
		newtag.setBounds(146, 11, 121, 44);
		newtagf.getContentPane().add(newtag);
		
		editname = new JButton("Name");
		editname.setFocusPainted(false);
		editname.setBounds(146, 66, 121, 44);
		newtagf.getContentPane().add(editname);
		
		editcolor = new JButton("Color");
		editcolor.setFocusPainted(false);
		editcolor.setBounds(146, 121, 121, 44);
		newtagf.getContentPane().add(editcolor);
		
		deltag = new JButton("Delete");
		deltag.setFocusPainted(false);
		deltag.setBounds(146, 176, 121, 44);
		newtagf.getContentPane().add(deltag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 126, 154);
		newtagf.getContentPane().add(scrollPane);
		JList<String> list = new JList<String>(names);
		scrollPane.setViewportView(list);
		
		colortag = new JTextField();
		colortag.setOpaque(false);
		colortag.setHorizontalAlignment(SwingConstants.CENTER);
		colortag.setEditable(false);
		colortag.setBounds(10, 176, 126, 44);
		newtagf.getContentPane().add(colortag);
		colortag.setColumns(1);
		//MOUSE ACTION OF TAG MENU BUTTON
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			int index = list.getSelectedIndex();
			colortag.setOpaque(true);
			colortag.setBackground(colors.get(index));
			}
			});	
		
		newtag.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(OKaddt) {	
					frame_addtag.setVisible(false);
					OKaddt = false;
				}
				else {
					frame_addtag.setVisible(true);
					OKaddt = true;
				}
			}
			});	
		//MOUSE ACTION OF EDIT COLOR BUTTON
		editcolor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					@SuppressWarnings("unused")
					Color error = colors.get(list.getSelectedIndex());;
					Color newcolour=JColorChooser.showDialog(editcolor,"Choose color", Color.white);
					int index = list.getSelectedIndex();
					colors.set(index, newcolour);
					SwingUtilities.updateComponentTreeUI(frame_tagmenu);
					selectObjectVar = combobox.getcomboBox();
					if(newcolour!=null) {
						try {
							fc.changelinecolor();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please select the tag you want to change its color", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});	
		//MOUSE ACTION OF EDIT NAME BUTTON
		editname.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					@SuppressWarnings("unused")
					String error = names.get(list.getSelectedIndex());
					String response = JOptionPane.showInputDialog("Insert new name:","New name");
					while("".equals(response)) {
						response = JOptionPane.showInputDialog("This name is invalid. Insert new name:","New name");
					}
					while(fn.tagexist(response)) {
						response = JOptionPane.showInputDialog("This name is already used by another tag. Insert new name:","New name");
					}
					if(!"".equals(response) && response!=null) {
							int index = list.getSelectedIndex();
							names.set(index, response);
							SwingUtilities.updateComponentTreeUI(frame_tagmenu);
							selectObjectVar = combobox.getcomboBox();
							try {
								fn.changelinename();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				} catch (Exception e) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please select the tag you want to rename", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});
		//MOUSE ACTION OF DELETE TAG BUTTON
		deltag.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					@SuppressWarnings("unused")
					String error = names.get(list.getSelectedIndex());
					int index = list.getSelectedIndex();
					if(names.size()>1) {
						fc.deletelinecolor(index);
						fn.deletelinename(index);
						names.remove(index);
						colors.remove(index);
						SwingUtilities.updateComponentTreeUI(frame_tagmenu);
						selectObjectVar = combobox.getcomboBox();
					}
					else {
						JFrame mesaj = new JFrame();
						JOptionPane.showMessageDialog(mesaj,"The tag list should have at least one item in it. Do not remove the last tag", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
						mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
				} catch (Exception e) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please select the tag you want to delete", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});
		frame_tagmenu=newtagf;
		frame_tagmenu.setIconImage(new FileManager().getImage("iconDataSet.png"));
		frame_tagmenu.setLocation(X - frame_tagmenu.getWidth(), Y + Y/2 + 25);
		}
	
	void initialize_tagbtn() {
		//Initialization of TagMenuButton
		TagMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OKtagm ) {
					frame_tagmenu.setVisible(false);
					OKtagm =false;
					frame_tagmenu.setLocation(X - frame_tagmenu.getWidth(), Y + Y/2 + 25);
				}
				else {
					frame_tagmenu.setVisible(true);
					OKtagm =true;
				}
			}
		});
	}
	
	void initialize_menubuttons() throws IOException {
		JFrame newmenu = new JFrame();
		newmenu.setResizable(false);
		newmenu.setBounds(100, 100, 301, 140);
		newmenu.setContentPane(new JLabel(new FileManager().getIcon("newmenu.png")));
		newmenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newmenu.getContentPane().setLayout(null);
		newmenu.setLocationRelativeTo(null);
		newmenu.setIconImage(new FileManager().getImage("iconDataSet.png"));
		newmenu.setTitle("New tag");
		newmenu.setLocation(X - frame_tagmenu.getWidth() - 4, Y);
		newmenu.setVisible(false);
		newmenu.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                OKaddt = false;
	        }
	    });
		
		JTextField nchange = new JTextField();
		nchange.setText("Insert name");
		nchange.setBounds(10, 11, 128, 26);
		newmenu.getContentPane().add(nchange);
		nchange.setColumns(1);
		
		JTextField cchange = new JTextField();
		cchange.setBackground(Color.CYAN);
		cchange.setEditable(false);
		cchange.setColumns(1);
		cchange.setBounds(148, 11, 126, 26);
		newmenu.getContentPane().add(cchange);
		
		Add = new JButton("Add");
		Add.setFocusPainted(false);
		Add.setBounds(10, 48, 128, 42);
		newmenu.getContentPane().add(Add);
		frame_addtag=newmenu;
		
		cchoose = new JButton("COLOR");
		cchoose.setFocusPainted(false);
		cchoose.setBounds(146, 48, 128, 42);
		newmenu.getContentPane().add(cchoose);
		
		cchoose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Color colour=JColorChooser.showDialog(cchange,"Choose color", Color.white);
				cchange.setBackground(colour);
			}
			});	
		//MOUSE ACTION OF ADD NEW TAG BUTTON
		Add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String auxname = nchange.getText();
				FileName fn = null;
				try {
					fn = new FileName();
				} catch (IOException e1) {
				}
				if(!"".equals(auxname)) {
					try {
						if(!fn.tagexist(auxname)) {
							Path pathn = fn.getPathn();
							try (BufferedWriter writer = Files.newBufferedWriter(pathn, StandardOpenOption.APPEND)) {
							    writer.write(System.lineSeparator() + auxname);
							    writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							Color colour = cchange.getBackground();
							String auxcolor = System.lineSeparator() + colour.getRGB();
							Path pathc = fc.getPathc();
							try (BufferedWriter writer = Files.newBufferedWriter(pathc, StandardOpenOption.APPEND)) {
							    writer.write(auxcolor);
							    writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							} 
							names.add(auxname);
							colors.add(colour);
							tags.add(new Tag(auxname,colour));
							SwingUtilities.updateComponentTreeUI(frame_tagmenu);	
							selectObjectVar = combobox.getcomboBox();
							JFrame mesaj = new JFrame();
					 		JOptionPane.showMessageDialog(mesaj,"Tag created","Info",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("done.png"));
					 		mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
						else {
							JFrame mesaj = new JFrame();
							JOptionPane.showMessageDialog(mesaj,"This name is already used by another tag", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
							mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
							
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This name is invalid", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});	
		
	}
	
	public void changeTagMenuIcons(int cont) {
		newtag.setIcon(new FileManager().getIcon(cont+"add.png"));
		Add.setIcon(new FileManager().getIcon(cont+"add.png"));
		editcolor.setIcon(new FileManager().getIcon(cont+"color.png"));
		cchoose.setIcon(new FileManager().getIcon(cont+"color.png"));
		editname.setIcon(new FileManager().getIcon(cont+"name.png"));
		deltag.setIcon(new FileManager().getIcon(cont+"delete.png"));
	}
	
	public static JComboBox<String> getSelectObjectVar(){
		return selectObjectVar;
	}
	
	public static Vector<String> getVectorName(){
		return names;
		
	}
	
	public static Vector<Color> getVectorColor(){
		return colors;
		
	}
	
}
