package Application.classes;
import Application.interfaces.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import marvin.image.MarvinImage;


public class Masina implements Obiect, Draw{
    private Color culoare;
    private static Add_Image Add_image;
	private Point p1;
	private Point p2;
	
    
    public Masina(Add_Image Add_image){
    	this.Add_image = Add_image;
    	this.culoare=Color.RED;    	
    }
    
    public void setPoint1(Point p) {
    	this.p1 = p;
    }

    public void setPoint2(Point p) {
    	this.p2 = p;
    }
    
	@Override
	public Color getCuloare() {
		return this.culoare;
	}
	
	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	
	public void draw() {
		if (this.p1.x == 0 || this.p1.y == 0 || this.p2.x == 0 || this.p2.y == 0) {
			System.out.println("\n Punctele nu au o valoare");
		} else {
			MarvinImage imageIn = Add_Image.getImage();
			Rectangle rect = new Rectangle(p1);
			rect.add(p2);
			imageIn.drawRect(rect.x, rect.y, rect.width, rect.height, culoare);
			Add_Image.geImagePanel().setImage(imageIn);
		}
	}
	
}
	

