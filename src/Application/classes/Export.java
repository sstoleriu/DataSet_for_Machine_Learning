package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import static marvin.MarvinPluginCollection.*;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Export{
	
	private JButton Export;
	private static Add_Image Add_image;
	
	public Export(JFrame frame,JButton Export, Add_Image Add_image){
		this.Add_image = Add_image;
		this.Export=Export;
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
				if (response == JFileChooser.APPROVE_OPTION) {	
					Vector<Object> vctneed=getListOfObjects();
					/*	Vector<Object> vctneed=getListOfObjects();
					 	VctCrop vct1=new VctCrop(vctneed);
					 	String vector1[]=vct1.getvct();
					 	VctFreq vct2=new VctFreq(vct_1);
					 	String namevct[]=vct2.getName_VctFreq();
					 	Integer contorvct[]=vct2.getContor_VctFreq();
					 	for(int i=0;i<vector1.length;i++){
					 		for(int j=0;j<namevct.length;j++){
					 			if(vector1[i].equals(namevct[j])){
					 				//crop(imageIn,imageOut,vect_poz_x[i][0],vect_poz_y[i][0],vect_width[i][0],vect_height[i][0];
						  			//MarvinImageIO.saveImage(imageOut, file.getAbsolutePath()+'/'+ta[i]+".jpg");
						  			//contorvct[j]--;
					 			}
					 		}
					 	}
					 	
					 */
					 
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
					
						int x=60,y=32,width=182,height=62;
						crop(imageIn, imageOut, x, y, width, height);
						MarvinImageIO.saveImage(imageOut, file2.getAbsolutePath()+"/x.jpg");
				}
			}
		});
	}
	
}