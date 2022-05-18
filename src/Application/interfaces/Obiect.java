package Application.interfaces;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Vector;

public interface Obiect {
	public static final String Name = null;
    public static final Color Color = null;
    public static final Rectangle Rect = null;
    Vector<Integer>Coord = new Vector<Integer>();
	public String getName();
	public Color getColor();
	public Rectangle getRect();
}
