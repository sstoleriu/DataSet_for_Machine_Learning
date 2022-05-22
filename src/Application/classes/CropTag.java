package Application.classes;

import java.awt.Color;
import java.awt.Rectangle;

import Application.interfaces.Obiect;
/**
 * Clasa pentru tagurile imaginilor decupate
 */
public class CropTag implements Obiect{
	
	private String name;
	private Color color;
	private Rectangle rect;
	
	/**
	 * Constructor de initializare cu parametri
	 * @param color Culoarea atribuita tagului
	 * @param name Numele atribuit tagului
	 * @param rect Chenarul atribuit tagului
	 */
	public CropTag(Color color,String name, Rectangle rect){
    	this.color = color;   
    	this.name = name;
    	this.rect = rect;
    }

	@Override
	/**
	 * Getter pentru preluarea numelui tag-ului ales din lista existenta sau nou creat
	 * @return name Numele tag-ului creat
	 */
	public String getName() {
		return name;
	}

	@Override
	/**
	 * Getter pentru preluarea culorii tag-ului atribuita deja pentru lista existenta sau aleasa pentru un nou tag
	 * @return color Culoarea tag-ului creat
	 */
	public java.awt.Color getColor() {
		return color;
	}

	@Override
	/**
	 * Getter pentru preluarea chenarului creat
	 * @return rect Dreptunghiul corespunzator tag-ului creat
	 */
	public Rectangle getRect() {
		return rect;
	}	
	
	
}