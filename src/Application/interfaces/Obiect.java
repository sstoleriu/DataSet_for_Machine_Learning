package Application.interfaces;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public interface Obiect {
    public static final Color Culoare = null;
    Vector<Integer>Coord = new Vector<Integer>();
    Color getCuloare();
    void draw();
    void setPoint1(Point p);
    void setPoint2(Point p);
    public Rectangle getReact();

}
