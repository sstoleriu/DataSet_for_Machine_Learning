package Application.classes;
import Application.interfaces.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.io.MarvinImageIO;

public class Masina implements Obiect, Draw{
    private Color culoare;
    private static Add_Image Add_image;
	public Point p1;
	public Point p2;
	
    
    public Masina(JFrame frame, Add_Image Add_image){
    	this.Add_image = Add_image;
    	this.culoare=Color.RED;
    	
    }
    


	@Override
	public Color getCuloare() {
		return this.culoare;
	}
	
	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	public void draw() {
		


				
				System.out.println(this.p1);
				System.out.println(this.p2);
				
				int width;
				int height;
				
				width=p2.x-p1.x;
				height=p1.y-p2.y;
		
				MarvinImage imageIn = Add_Image.getImage();
		
		 if(this.p1==null && this.p2==null)
		 {
			 System.out.println("\n Punctele nu au o valoare");
		 }
		 else
		 {
			 
		 imageIn.drawRect(p1.x,p1.y, width, height, culoare);
		
		 }
		 Add_Image.geImagePanel().setImage(imageIn);
	
		
		 
}}
	

