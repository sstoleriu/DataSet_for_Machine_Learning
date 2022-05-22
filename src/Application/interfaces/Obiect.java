package Application.interfaces;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Vector;
/**
 *	INTERFACE 
 * 		- Obiect
 */
public interface Obiect {
	public static final String Name = null;
    public static final Color Color = null;
    public static final Rectangle Rect = null;
    Vector<Integer>Coord = new Vector<Integer>();
	
    /**
     * Getter pentru returnarea numelui obiectului
     */
    public String getName();
    
    /**
     * Getter pentru returnarea culorii chenarului
     */
	public Color getColor();
	
	/**
     * Getter pentru returnarea chenarului(dreptunghiului)
     */
	public Rectangle getRect();
}
