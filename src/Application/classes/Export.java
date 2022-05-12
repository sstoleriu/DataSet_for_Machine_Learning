package Application.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Application.interfaces.Obiect;
import static marvin.MarvinPluginCollection.*;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Export{
	
	private JButton export;
	private static Add_Image Add_image;
	private Vector<Obiect> listOfObjects;
	private MarvinImage cropImage;
	@SuppressWarnings("unused")
	private static JComboBox<String> selectObjectVar;
	@SuppressWarnings("unused")
	private Vector<String> names=new Vector<>();
	@SuppressWarnings("unused")
	private Vector<Color> colors=new Vector<>();
	
	public Export(JFrame frame,JButton export, Add_Image Add_image, Vector<Obiect> listOfObjects, MarvinImage cropImage, JComboBox<String> selectObjectVar, Vector<String> names, Vector<Color> colors){
		Application.classes.Export.Add_image = Add_image;
		this.export=export;
		this.listOfObjects = listOfObjects;
		this.cropImage=cropImage;
		Application.classes.Export.selectObjectVar = selectObjectVar;
		this.names = names;
		this.colors = colors;
	}

	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	
	public void load() {
		Add_image.refreshImage();
		export.setEnabled(true);
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarvinImage imageOut = new MarvinImage();
				JFileChooser fileChooser2 = new JFileChooser();
				fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int response = fileChooser2.showOpenDialog(null);
				File file2 = fileChooser2.getSelectedFile();

				if (response == JFileChooser.APPROVE_OPTION) {
					VctCrop vct1=new VctCrop(listOfObjects);
				 	Vector<String> allvct=vct1.getvct();
				 	VctFreq vct2=new VctFreq(allvct);
				 	String namevct[]=vct2.getName_VctFreq();
				 	Integer contorvct[]=vct2.getContor_VctFreq();
				 	Integer aux[]=Arrays.copyOf(contorvct, contorvct.length);
				 	int conti;
					 for(int i=0;i<allvct.size();i++){
					 	for(int j=0;j<namevct.length;j++){
					 		if(allvct.get(i).equals(namevct[j])){
					 			java.awt.Rectangle rect=listOfObjects.get(i).getReact();
					 			crop(cropImage,imageOut,rect.x,rect.y,rect.width,rect.height);
					 			conti=contorvct[j]-aux[j];
					 			aux[j]=aux[j]-1;
					 			MarvinImageIO.saveImage(imageOut, file2.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg");
					 			}
					 		}
					 	}
					 if(allvct.size()!=0){
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Export done!");
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					System.out.println(allvct);
					 }
					 else{
						JFrame mesaj = new JFrame();
						JOptionPane.showMessageDialog(mesaj,"Please, select objects to export", "Warning", JOptionPane.WARNING_MESSAGE);
						mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 }
				}
			}
		});
	}
	
}