package Application.classes;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import marvin.image.MarvinImage;
import Application.interfaces.Draw;
import Application.interfaces.Obiect;

public class Autobuz implements Obiect, Draw{
	private Color culoare;
    private static Add_Image Add_image;
    public Point p1;
	public Point p2;
	private Rectangle rect;
    
    public Autobuz(Add_Image Add_image){
    	this.Add_image = Add_image;
    	this.culoare=Color.YELLOW;
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
			this.rect = new Rectangle(p1);
			this.rect.add(p2);
			imageIn.drawRect(rect.x, rect.y, rect.width, rect.height, culoare);
			Add_Image.geImagePanel().setImage(imageIn);
		}
	}
	
	public Rectangle getReact() {
		return this.rect;
	}

	@Override
	public void setPoint1(Point p) {
		// TODO Auto-generated method stub
		this.p1 = p;
	}

	@Override
	public void setPoint2(Point p) {
		// TODO Auto-generated method stub
		this.p2 = p;
	}
}
