package Application.classes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Application.interfaces.Obiect;

public class MouseClick implements MouseListener{
	private boolean drawing=false;
	private Point p1=new Point(0,0);
	private Point p2=new Point(0,0);
	private static Vector<Obiect> listOfObjects;
	private String optiune;
	private Add_Image add_image;
	
	public void setOptiune(String optiune) {
		this.optiune = optiune;
	}
	
	public MouseClick(Vector<Obiect> listSlecObject, Add_Image add_image) {
		MouseClick.listOfObjects = listSlecObject;
		this.add_image = add_image;
	}
	
   public void mousePressed(MouseEvent e) {
        if(this.drawing){
        	p2=e.getPoint();
        	this.drawing=false;

        	
        	try {
				switch (this.optiune) {
				case "Masina": {
						Masina m1 = new Masina(add_image);
						m1.setPoint1(this.p1);
						m1.setPoint2(this.p2);
						m1.draw();
						MouseClick.listOfObjects.add(m1);
						break;
				}
				case "Bicicleta": {
					Bicicleta b1 = new Bicicleta(add_image);
					b1.setPoint1(this.p1);
					b1.setPoint2(this.p2);
					b1.draw();
					MouseClick.listOfObjects.add(b1);
					break;
				}
				case "Autobuz": {
					Autobuz a1 = new Autobuz(add_image);
					a1.setPoint1(this.p1);
					a1.setPoint2(this.p2);
					a1.draw();
					MouseClick.listOfObjects.add(a1);
					System.out.println(this.optiune + " " +MouseClick.listOfObjects);
					break;
				}
				case "Motocicleta": {
					Motocicleta mot1 = new Motocicleta(add_image);
					mot1.setPoint1(this.p1);
					mot1.setPoint2(this.p2);
					mot1.draw();
					MouseClick.listOfObjects.add(mot1);
					break;
				}
				case "Cladire": {
					Cladire c1 = new Cladire(add_image);
					c1.setPoint1(this.p1);
					c1.setPoint2(this.p2);
					c1.draw();
					MouseClick.listOfObjects.add(c1);
					break;
				}
				case "Pieton": {
					Pieton p1 = new Pieton(add_image);
					p1.setPoint1(this.p1);
					p1.setPoint2(this.p2);
					p1.draw();
					MouseClick.listOfObjects.add(p1);
					break;
				}
				case "Indicator": {
					Indicator i1 = new Indicator(add_image);
					i1.setPoint1(this.p1);
					i1.setPoint2(this.p2);
					i1.draw();
					MouseClick.listOfObjects.add(i1);
					break;
				}
				case "Semafor": {
					Semafor s1 = new Semafor(add_image);
					s1.setPoint1(this.p1);
					s1.setPoint2(this.p2);
					s1.draw();
					MouseClick.listOfObjects.add(s1);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + this.optiune);
				}
			} catch (NullPointerException e1) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"Please select tag!");
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
        	
        	
        	
        }
        else {
        	p1 = e.getPoint();
        	this.drawing=true;
        }
    }
   
   public Point getPoint_P1(){
	   
	   return p1;
   }
   
   public Point getPoint_P2(){
	   return p2;
   }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
