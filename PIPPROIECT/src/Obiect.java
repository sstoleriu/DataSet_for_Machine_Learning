
import java.util.Vector;

public interface Obiect {
    String Culoare = null;
    Vector<Integer>Coord = new Vector<Integer>();

    void setCuloare(String color);
    String getCuloare();

    void setObject(Obiect ob);
    String getObject();

    void setCoord(Vector<Integer> coord);
    Vector<Integer> getCoord();

}
