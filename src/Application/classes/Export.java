package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.sun.javafx.geom.Rectangle;

import Application.interfaces.Obiect;
import static marvin.MarvinPluginCollection.*;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Export{
	
	private JButton Export;
	private static Add_Image Add_image;
	private Vector<Obiect> listOfObjects;
	
	public Export(JFrame frame,JButton Export, Add_Image Add_image, Vector<Obiect> listOfObjects){
		this.Add_image = Add_image;
		this.Export=Export;
		this.listOfObjects = listOfObjects;
	}

	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	
	public void Load2() {		
		Export.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MarvinImage imageIn = MarvinImageIO.loadImage(getAddImage().getFileAdd_image().toString());;
				MarvinImage imageOut = new MarvinImage();
				JFileChooser fileChooser2 = new JFileChooser();
				fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int response = fileChooser2.showOpenDialog(null);
				File file2 = fileChooser2.getSelectedFile();
				VctCrop vct1=new VctCrop(listOfObjects);
			 	Vector<String> allvct=vct1.getvct();
			 	VctFreq vct2=new VctFreq(allvct);
			 	String namevct[]=vct2.getName_VctFreq();
			 	Integer contorvct[]=vct2.getContor_VctFreq();
			 	Integer aux[]=contorvct;
			 	int conti;
			 	/*
			 	 * test <---
			 	 */
				
				/*if (response == JFileChooser.APPROVE_OPTION) {	 	
					 	for(int i=0;i<allvct.size();i++){
					 		for(int j=0;j<namevct.length;j++){
					 			if(allvct.get(i).equals(namevct[j])){
					 				java.awt.Rectangle rect=listOfObjects.get(i).getReact();
					 				crop(imageIn,imageOut,rect.x,rect.y,rect.width,rect.height);
					 				conti=contorvct[j]-aux[j];
					 				aux[j]=aux[j]-1;
					 				MarvinImageIO.saveImage(imageOut, file2.getAbsolutePath()+'/'+allvct.get(i)+conti+".jpg");
					 				//crop(imageIn,imageOut,vect_poz_x[i][0],vect_poz_y[i][0],vect_width[i][0],vect_height[i][0];
						  			//MarvinImageIO.saveImage(imageOut, file.getAbsolutePath()+'/'+ta[i]+".jpg");
						  			//contorvct[j]--;
					 			}
					 		}
					 	}*/
					 	
					/*
						 //y[i]-vector cu numarul de taguri ale tagurilor respective
						 //ta[i]-vector cu denumirile tagurilor
						 //numarul de pe pozitia 0 a vectorului y corespunde cu numele de pe pozitia 0 a vectorului ta
						 //arr_poz_x matrice cu pozitia x ale spatiilor selectate depinzand pe linie de numele tagului, iar coloane numarul de taguri
						 //arr_poz_y matrice cu pozitia y ale spatiilor selectate depinzand pe linie de numele tagului, iar coloane numarul de taguri
						 //arr_width matrice cu latimea spatiilor selectate depinzand pe linie de numele tagului, iar coloane numarul de taguri
						 //arr_height matrice cu inaltimea spatiilor selectate depinzand pe linie de numele tagului, iar coloane numarul de taguri
						  for(int i=0;i<nr_total_de_taguri;i++)
						  	int aux=y[i];
						  	if(aux!=0){
						  		crop(imageIn,imageOut,vect_poz_x[i][0],vect_poz_y[i][0],vect_width[i][0],vect_height[i][0];
						  		MarvinImageIO.saveImage(imageOut, file.getAbsolutePath()+'/'+ta[i]+".jpg");
        						aux--;
						  	}
						  	while(aux!=0){
						  		crop(imageIn,imageOut,arr_poz_x[i][y[i]-aux],arr_poz_y[i][y[i]-aux],arr_width[i][y[i]-aux],arr_height[i][y[i]-aux];
						  		MarvinImageIO.saveImage(imageOut, file.getAbsolutePath()+'/'+ta[i]+'('+(y[i]-aux)+')'+".jpg");
        						aux--;
						  	}
						 */
					
						/*int x=60,y=32,width=182,height=62;
						crop(imageIn, imageOut, x, y, width, height);
						MarvinImageIO.saveImage(imageOut, file2.getAbsolutePath()+"/x.jpg");*/
				}
			}
		});
	}
	
}