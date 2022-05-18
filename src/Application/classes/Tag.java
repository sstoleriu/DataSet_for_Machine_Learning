package Application.classes;

import java.awt.Color;

public class Tag {
	private String name;
	private Color color;
	
	Tag(String name,Color color){
		this.name=name;
		this.color=color;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
}
