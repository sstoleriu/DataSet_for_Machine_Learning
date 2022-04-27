package Application.classes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Application.interfaces.Obiect;

public class MouseClick implements MouseListener{
	private boolean drawing=false;
	private Point p1=new Point(0,0);
	private Point p2=new Point(0,0);
	private Obiect obiect;
	
	public MouseClick(Obiect obiect) {
		this.obiect = obiect;
	}
	
   public void mouseClicked(MouseEvent e) {
        if(this.drawing){
        	p2=e.getPoint();
        	this.drawing=false;
        	//System.out.println(p2);
        	//System.out.println(" \n S-a printat p2 \n");
        	this.obiect.setPoint1(this.p1);
        	this.obiect.setPoint2(this.p2);
        	this.obiect.draw();
        }
        else {
        	p1 = e.getPoint();
        	this.drawing=true;
        	//System.out.println(p1);
        	//System.out.println(" \n S-a printat p1 \n");
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

//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		this.p1 = e.getPoint();
//	}
}
