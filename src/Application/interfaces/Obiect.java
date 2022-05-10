package Application.interfaces;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;
/**
 *  IMPLEMENTOR CLASS (?)
 * 		=> Obiect
 */
public interface Obiect {
    public static final Color Culoare = null;
    Vector<Integer>Coord = new Vector<Integer>();
    
    /**
     * Getter pentru returnarea culorii
     */
    Color getCuloare();
    
    /**
     * Metoda de desenare
     */
    void draw();
    
    /**
     * Metoda pentru setarea primului punct
     * @param p Punct de tip Point
     */
    void setPoint1(Point p);
    
    /**
     * Metoda pentru setarea celui de-al doilea punct
     * @param p Punct de tip Point
     */
    void setPoint2(Point p);
    
    /**
     * Getter pentru returnarea chenarului(dreptunghiului)
     */
    public Rectangle getReact();

}
