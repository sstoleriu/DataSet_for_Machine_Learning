package Application.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TagMenu {
	
	private JButton TagMenu;
	private static Vector<String> names=new Vector<>();
	private static Vector<Color> colors=new Vector<>();
	private Vector<Tag> tags=new Vector<>();
	private boolean OK=false;
	private JFrame frame_tagmenu;
	private JFrame frame_addtag;
	private ComboBox combobox;
	private JFrame frame;
	private static JComboBox<String> selectObjectVar;
	
	public TagMenu(JButton TagMenu, ComboBox combobox, JFrame frame,JComboBox<String> selectObjectVar) {
		this.TagMenu = TagMenu;
		this.combobox = combobox;
		this.frame = frame;
		Application.classes.TagMenu.selectObjectVar = selectObjectVar;
	}
	
	void initialize_tags() throws IOException{
		//Initialization of TagMenuPanel
		JButton editname;
		JFrame newtagf;
		JTextField colortag;
		FileName fn = new FileName();
		FileColor fc = new FileColor();
		names=fn.getlistname();
		colors=fc.getlistcolor();
		for(int i=0; i<names.size(); i++) {
			tags.add(new Tag(names.get(i),colors.get(i)));
		}
		
		combobox.modComboBox(frame, names);
		selectObjectVar = combobox.getcomboBox();
		newtagf = new JFrame();
		newtagf.setBounds(100, 100, 262, 276);
		newtagf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newtagf.setTitle("Tag menu");
		newtagf.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                OK=false;
	        }
	    });
		
		newtagf.getContentPane().setLayout(null);
		newtagf.setVisible(false);
		
		JButton newtag = new JButton("New tag");
		newtag.setBounds(136, 11, 100, 44);
		newtagf.getContentPane().add(newtag);
		
		editname = new JButton("Edit name");
		editname.setBounds(136, 66, 100, 44);
		newtagf.getContentPane().add(editname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 116, 154);
		newtagf.getContentPane().add(scrollPane);
		JList<String> list = new JList<String>(names);
		scrollPane.setViewportView(list);
		
		
		JButton editcolor = new JButton("Edit color");
		editcolor.setBounds(136, 121, 100, 44);
		newtagf.getContentPane().add(editcolor);
		
		JButton deltag = new JButton("Delete tag");
		deltag.setBounds(136, 176, 100, 44);
		newtagf.getContentPane().add(deltag);
		
		colortag = new JTextField();
		colortag.setHorizontalAlignment(SwingConstants.CENTER);
		colortag.setEditable(false);
		colortag.setBounds(10, 176, 116, 44);
		newtagf.getContentPane().add(colortag);
		colortag.setColumns(10);
		//MOUSE ACTION OF TAG MENU BUTTON
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			int index = list.getSelectedIndex();
			colortag.setBackground(colors.get(index));
			}
			});	
		newtag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame_addtag.setVisible(true);
			}
			});	
		//MOUSE ACTION OF EDIT COLOR BUTTON
		editcolor.addMouseListener(new MouseAdapter() {
			@Override
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
					JOptionPane.showMessageDialog(mesaj,"Please select the tag you want to change its color", "Warning", JOptionPane.WARNING_MESSAGE);
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});	
		//MOUSE ACTION OF EDIT NAME BUTTON
		editname.addMouseListener(new MouseAdapter() {
			@Override
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
					JOptionPane.showMessageDialog(mesaj,"Please select the tag you want to rename", "Warning", JOptionPane.WARNING_MESSAGE);
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});
		//MOUSE ACTION OF DELETE TAG BUTTON
		deltag.addMouseListener(new MouseAdapter() {
			@Override
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
						JOptionPane.showMessageDialog(mesaj,"The tag list should have at least one item in it. Do not remove the last tag", "Warning", JOptionPane.WARNING_MESSAGE);
						mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
				} catch (Exception e) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please select the tag you want to delete", "Warning", JOptionPane.WARNING_MESSAGE);
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});
		frame_tagmenu=newtagf;
		}
	
	void initialize_tagbtn() {
		//Initialization of TagMenuButton
		TagMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(OK) {
					frame_tagmenu.setVisible(false);
					OK=false;
				}
				else {
					frame_tagmenu.setVisible(true);
					OK=true;
				}
			}
		});
	}
	
	void initialize_menubuttons() {
		JFrame addtag;
		addtag = new JFrame();
		addtag.setBounds(100, 100, 251, 125);
		addtag.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addtag.getContentPane().setLayout(null);
		addtag.setTitle("New tag");
		addtag.setVisible(false);
		
		JTextField nchange = new JTextField();
		nchange.setText("Insert name");
		nchange.setBounds(10, 11, 120, 20);
		addtag.getContentPane().add(nchange);
		nchange.setColumns(1);
		
		JTextField cchange = new JTextField();
		cchange.setBackground(Color.CYAN);
		cchange.setEditable(false);
		cchange.setColumns(1);
		cchange.setBounds(140, 11, 85, 20);
		addtag.getContentPane().add(cchange);
		
		JButton Add = new JButton("Add");
		Add.setBounds(10, 42, 120, 33);
		addtag.getContentPane().add(Add);
		frame_addtag=addtag;
		
		JButton cchoose = new JButton("COLOR");
		cchoose.setBounds(140, 42, 85, 33);
		addtag.getContentPane().add(cchoose);
		
		cchoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color colour=JColorChooser.showDialog(cchange,"Choose color", Color.white);
				cchange.setBackground(colour);
			}
			});	
		//MOUSE ACTION OF ADD NEW TAG BUTTON
		Add.addMouseListener(new MouseAdapter() {
			@Override
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
							File name = new File("src/Application/classes/name_tags");
							Path pathn = Paths.get(name.getAbsolutePath());
							try (BufferedWriter writer = Files.newBufferedWriter(pathn, StandardOpenOption.APPEND)) {
							    writer.write(System.lineSeparator() + auxname);
							    writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							Color colour = cchange.getBackground();
							String auxcolor = System.lineSeparator() + colour.getRGB();
							File color = new File("src/Application/classes/color_tags");
							Path pathc = Paths.get(color.getAbsolutePath());
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
						}
						else {
							JFrame mesaj = new JFrame();
							JOptionPane.showMessageDialog(mesaj,"This name is already used by another tag", "Warning", JOptionPane.WARNING_MESSAGE);
							mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
							
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"This name is invalid", "Warning", JOptionPane.WARNING_MESSAGE);
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			});	
		
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
