package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
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
	private selectObject selectObjectTemp;
	
	public Export(JFrame frame,JButton export, Add_Image Add_image, selectObject selectObjectTemp, MarvinImage cropImage){
		Application.classes.Export.Add_image = Add_image;
		this.export=export;
		this.selectObjectTemp = selectObjectTemp;
		this.cropImage= cropImage;
		listOfObjects = this.selectObjectTemp.getListOfObjects();
	}

	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	
	public void load() {
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(listOfObjects);
				if(listOfObjects.isEmpty()) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please, select objects to export", "Warning", JOptionPane.WARNING_MESSAGE);
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					MarvinImage imageOut = new MarvinImage();
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int response = fileChooser.showOpenDialog(null);
					File file = fileChooser.getSelectedFile();
					if (response == JFileChooser.APPROVE_OPTION) {
						System.out.println("export done: "+listOfObjects);
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
						 			MarvinImageIO.saveImage(imageOut, file.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg");
						 			}
						 		}
						 	}
						 	if(allvct.size()!=0){
						 		JFrame mesaj = new JFrame();
						 		JOptionPane.showMessageDialog(mesaj,"Export done!","Info",JOptionPane.INFORMATION_MESSAGE);
						 		mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 	}
						}
					}
				}
		});
	}
	
}