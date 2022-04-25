package Application.classes;

import java.awt.Color;

import javax.swing.JFrame;

import marvin.image.MarvinImage;
import Application.interfaces.Draw;
import Application.interfaces.Obiect;

public class Cladire implements Obiect, Draw{
	private Color culoare;
    private static Add_Image Add_image;
    //private final JButton Done;
    
    public Cladire(JFrame frame, Add_Image Add_image){
    	this.Add_image = Add_image;
    	this.culoare=Color.PINK;
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
