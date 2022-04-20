package Application.classes;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import marvin.image.MarvinImage;
import Application.interfaces.Draw;
import Application.interfaces.Obiect;

public class Pieton implements Obiect, Draw{
	private Color culoare;
    private static Add_Image Add_image;
    private Point p1, p2;
    
    public Pieton(JFrame frame, Add_Image Add_image, Point pc1,Point pc2){
    	this.Add_image = Add_image;
    	this.culoare=Color.MAGENTA;
    	p1=pc1;
    	p2=pc2;
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
		 int lungime;
		 int latime;
		 lungime=p2.x-p1.x;
		 latime=p1.y-p2.y;
		 imageIn.drawRect(p1.x, p1.y,lungime,latime ,culoare);
		this.Add_image.geImagePanel().setImage(imageIn);
	
		}
}
