
import java.util.Vector;

public class Semn implements Obiect{
    private String culoare;
    private Vector<Integer> coord;

    @Override
    public void setCuloare(String color) {
        this.culoare = color;
    }

    @Override
    public String getCuloare() {
        return this.culoare;
    }

    @Override
    public void setObject(Obiect ob) {

    }

    @Override
    public String getObject() {
        return "This is a object of type `masina`";
    }

    @Override
    public void setCoord(Vector<Integer> coord) {
        this.coord = coord;
    }

    @Override
    public Vector<Integer> getCoord() {
        return this.coord;
    }
}