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
					JOptionPane.showMessageDialog(mesaj,"Please, select objects to export", "Warning", JOptionPane.WARNING_MESSAGE, new FileGet().getIcon("warn.png"));
					mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					MarvinImage imageOut = new MarvinImage();
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int response = fileChooser.showOpenDialog(null);
					File file = fileChooser.getSelectedFile();
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
						 			try {
										crop(cropImage,imageOut,rect.x,rect.y,rect.width,rect.height);
									} catch (IllegalArgumentException e1) {
										IAE = true;
									}
						 			
						 			if(IAE == false) {
						 				conti=contorvct[j]-aux[j];
							 			aux[j]=aux[j]-1;
						 				MarvinImageIO.saveImage(imageOut, file.getAbsolutePath()+'/'+allvct.get(i)+" ("+conti+").jpg");
						 			}
						 			IAE = false;
						 		}
						 	}
						 }
						 	if(allvct.size()!=0){
						 		JFrame mesaj = new JFrame();
						 		JOptionPane.showMessageDialog(mesaj,"Export done!","Info",JOptionPane.INFORMATION_MESSAGE, new FileGet().getIcon("done.png"));
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