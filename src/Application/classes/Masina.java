package Application.classes;
import Application.interfaces.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    //private final JButton Done;
    
    public Masina(JFrame frame, Add_Image Add_image){
    	this.Add_image = Add_image;
    	this.culoare=Color.RED;
    	//this.Done = Done;
    }
    
	@Override
	public Color getCuloare() {
		return this.culoare;
	}
	
	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	public void draw() {
		 MarvinImage imageIn = this.Add_image.getImage();
		 imageIn.drawRect(20, 20, 150, 150, culoare);
		this.Add_image.geImagePanel().setImage(imageIn);
	
		}
}

