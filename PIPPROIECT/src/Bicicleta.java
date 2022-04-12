


import java.util.Vector;

public class Bicicleta implements Obiect{
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
    
//    Bicicleta b1=new Bicicleta();
//    b1.setCuloare("red");
//   
//   
//    String s1;
//    s1=b1.getCuloare();
    
//    JTextArea area = new JTextArea("hello world");
//    area.setForeground(Color.s1)

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
