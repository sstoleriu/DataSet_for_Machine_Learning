package Application.classes;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import Application.interfaces.Draw;
import Application.interfaces.Obiect;
import marvin.image.MarvinImage;

public class CropTag implements Obiect, Draw{
	
	private String name;
	private Color color;
    private static Add_Image Add_image;
	private Point p1;
	private Point p2;
	private Rectangle rect;
	
	public CropTag(Add_Image Add_image,Color color,String name){
    	CropTag.Add_image = Add_image;
    	this.color = color;   
    	this.name = name;
    }
    
    public void setPoint1(Point p) {
    	this.p1 = p;
    }

    public void setPoint2(Point p) {
    	this.p2 = p;
    }
    
	public Color getCuloare() {
		return this.color;
	}
	
	public String getName() {
		return name;
	}
	
	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	public void draw() {
		if (this.p1.x == 0 || this.p1.y == 0 || this.p2.x == 0 || this.p2.y == 0) {
			System.out.println("\n Punctele nu au o valoare");
		} else {
			MarvinImage imageIn = Add_Image.getImage();
			this.rect = new Rectangle(p1);
			this.rect.add(p2);
			imageIn.drawRect(rect.x, rect.y, rect.width, rect.height, color);
			Add_Image.geImagePanel().setImage(imageIn);
		}
	}
	
	public Rectangle getReact() {
		return this.rect;
	}
	
}
