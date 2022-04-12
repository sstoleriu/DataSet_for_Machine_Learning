package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import static marvin.MarvinPluginCollection.*;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Export extends Add_Image{
	
	private static JFrame frame;
	private JButton Export;
	
	public Export(JButton Export){
		super(frame, Export);
		this.Export=Export;
	}

	public void Load() {
		Export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					JFileChooser fileChooser2 = new JFileChooser();
					fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int response = fileChooser2.showOpenDialog(null);
					File file2 = fileChooser2.getSelectedFile();
					if (response == JFileChooser.APPROVE_OPTION) {
						MarvinImage imageIn = MarvinImageIO.loadImage(file.toString());;
						MarvinImage imageOut = new MarvinImage();
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
