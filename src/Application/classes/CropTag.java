package Application.classes;

import java.awt.Color;
import java.awt.Rectangle;

import Application.interfaces.Obiect;

public class CropTag implements Obiect{
	
	private String name;
	private Color color;
	private Rectangle rect;
	
	public CropTag(Color color,String name, Rectangle rect){
    	this.color = color;   
    	this.name = name;
    	this.rect = rect;
    }

	@Override
	public String getName() {
		return name;
	}

	@Override
	public java.awt.Color getColor() {
		return color;
	}

	@Override
	public Rectangle getRect() {
		return rect;
	}	
	
	
}