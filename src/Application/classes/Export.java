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
	private static Add_Image Add_imageTemp;
	private Vector<Obiect> listOfObjects;
	private MarvinImage cropImage;
	private selectObject selectObjectTemp;
	private static ActionListener exportAction;
	private static boolean createdBooleanExport = false;
	private static boolean IAE = false;
	
	public Export(JFrame frame,JButton export, Add_Image Add_imageTemp, selectObject selectObjectTemp){
		Export.Add_imageTemp = Add_imageTemp;
		this.export=export;
		this.selectObjectTemp = selectObjectTemp;
		cropImage= Export.Add_imageTemp.getrcImage();
		listOfObjects = this.selectObjectTemp.getListOfObjects();
	}
	
	public void load() {
		exportAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listOfObjects.isEmpty()) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Please, select objects to export", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					MarvinImage imageOut = new MarvinImage();
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int response = fileChooser.showOpenDialog(Add_imageTemp.getFrame());
					File file = fileChooser.getSelectedFile();
					if (response == JFileChooser.APPROVE_OPTION) {
						VctCrop vct1=new VctCrop(listOfObjects);
					 	Vector<String> allvct=vct1.getvct();
					 	VctFreq vct2=new VctFreq(allvct);
					 	String namevct[]=vct2.getName_VctFreq();
					 	Integer contorvct[]=vct2.getContor_VctFreq();
					 	Integer aux[]=Arrays.copyOf(contorvct, contorvct.length);
					 	int conti;
					 	boolean OK = false;
						 for(int i=0;i<allvct.size();i++){	
						 	for(int j=0;j<namevct.length;j++){	 		
						 		if(allvct.get(i).equals(namevct[j])){
						 			java.awt.Rectangle rect=listOfObjects.get(i).getReact();
						 			try {
										crop(cropImage,imageOut,rect.x,rect.y,rect.width,rect.height);
									} catch (IllegalArgumentException e1) {
										IAE = true;
									}
						 			if(IAE == false) {
						 				String path = file.getAbsolutePath()+'/'+allvct.get(i)+".jpg";
						 				if(new FileManager().FileExist(path) == false) {
						 					MarvinImageIO.saveImage(imageOut, path);
						 					aux[j] = aux[j]-1;
						 					OK = true;
						 				} else {
						 					if(OK) {
						 						conti = contorvct[j]-aux[j];
						 					} else {
						 						conti = contorvct[j]-aux[j]+1;
						 					}		
						 					path = file.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg";
						 					while(new FileManager().FileExist(path)) {
						 						conti++;
						 						path = file.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg";
						 					}
						 					MarvinImageIO.saveImage(imageOut, path);
						 					aux[j] = aux[j]-1;
						 				}					 				
						 			}
						 			IAE = false;
						 		}
						 	}
						 }
						 	if(allvct.size()!=0){
						 		JFrame mesaj = new JFrame();
						 		JOptionPane.showMessageDialog(mesaj,"Export done!","Info",JOptionPane.INFORMATION_MESSAGE, new FileManager().getIcon("done.png"));
						 		mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 	}
						}
					}
				}
			};
			if(createdBooleanExport == false) {
				export.addActionListener(exportAction);
				createdBooleanExport = true;
			}
	}
}