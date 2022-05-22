package Application.classes;

import java.awt.Color;

/**
 * Clasa pentru adaugarea tagurilor pe imagine
 */
public class Tag {
	private String name;
	private Color color;
	
	/**
	 * Constructor de initializare cu parametri
	 * @param name Numele tag-ului
	 * @param color Culoarea atribuita/aleasa pentru tag
	 */
	Tag(String name,Color color){
		this.name=name;
		this.color=color;
	}
	
	/**
	 * Getter pentru returnarea numelui tag-ului
	 * @return name Numele tagului ales din lista/creat
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter pentru returnarea culorii tag-ului
	 * @return color Culoarea tag-ului atribuita conform listei sau aleasa din paleta de culori
	 */
	public Color getColor() {
		return color;
	}
}
