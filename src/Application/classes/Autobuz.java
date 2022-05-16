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
    
	/**
	 * Constructor de initializare cu parametri pentru clasa Autobuz
	 *  - Initializeaza imaginea adaugata si culoarea specifica pentru chenar(galben)
	 * @param Add_image Obiect de tipul clasei Add_Image
	 */
    public Autobuz(Add_Image Add_image){
    	this.Add_image = Add_image;
    	this.culoare=Color.YELLOW;
    }
    
	@Override
	/**
	 * Getter de tip Color pentru returnarea culorii
	 */
	public Color getCuloare() {
		return this.culoare;
	}
	
	/**
	 * Getter pentru returnarea numelui clasei
	 */
	public String getName(){
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Getter de tip Add_Image pentru preluarea imaginii adaugate
	 * @return Add_image Imagine adaugata
	 */
	public static Add_Image getAddImage(){
		return Add_image;
	}
	
	/**
	 * Metoda pentru desenarea dreptunghiului - Preluare coordonate puncte si desenare
	 */
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
	
	/**
	 * Getter pentru returnarea dreptunghiului
	 */
	public Rectangle getReact() {
		return this.rect;
	}

	@Override
	/**
	 * Setter pentru setarea primului punct
	 */
	public void setPoint1(Point p) {
		
		this.p1 = p;
	}

	@Override
	/**
	 * Setter pentru setarea celui de-al doilea punct
	 */
	public void setPoint2(Point p) {
		
		this.p2 = p;
	}
	
}
