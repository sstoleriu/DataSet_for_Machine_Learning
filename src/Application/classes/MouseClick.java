package Application.classes;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;

public class MouseClick implements MouseListener{
	private boolean drawing=false;
	private Point p1=new Point(0,0);
	private Point p2=new Point(0,0);
	
   public void mouseClicked(MouseEvent e) {
        if(this.drawing){
        	this.p2=e.getPoint();
        	System.out.println(p2);
        }
        else {
        	this.p1 = e.getPoint();
        	this.drawing=true;
        	System.out.println(p1);
        }
    }

   public Point getPoint_P1(){
	   return this.p1;
   }
   public Point getPoint_P2(){
	   return this.p2;
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
