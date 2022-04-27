package Application.classes;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;

import marvin.image.MarvinImage;

public class MouseClick implements MouseListener{
	private boolean drawing=false;
	public Point p1=new Point(0,0);
	public Point p2=new Point(0,0);
	
   public void mouseClicked(MouseEvent e) {
        if(this.drawing){
        	p2=e.getPoint();
        	this.drawing=false;
        	System.out.println(p2);
        	System.out.println(" \n S-a printat p2 \n");
        }
        else {
        	p1 = e.getPoint();
        	this.drawing=true;
        	System.out.println(p1);
        	System.out.println(" \n S-a printat p1 \n");
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
