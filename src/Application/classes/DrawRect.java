package Application.classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class DrawRect extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle selection = new Rectangle();
    private Point p1;
    private Point p2;
    private Rectangle rect;
    private MouseMotionListener constantDrawing;
    private boolean drawing = false;
    private Graphics2D g2d;
    private Color colour;
    private String name;
    private Image image;
    
    public Rectangle getRectangle() {
    	return rect;
    }
    
    public DrawRect(Color colour, String name, Image image) {
    	repaint();
    	this.colour = colour;
    	this.name = name;
    	this.image = image;
    	constantDrawing = new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				int minX = Math.min(e.getX(), p1.x);
                int minY = Math.min(e.getY(), p1.y);
                int maxX = Math.max(e.getX(), p1.x);
                int maxY = Math.max(e.getY(), p1.y);
                selection.setBounds(minX, minY, maxX - minX, maxY - minY);
                repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {	
			}
			
		}; 	
    	
        MouseAdapter ma = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
            	if(drawing == false) {
            		repaint();
            		addMouseMotionListener(constantDrawing);
            		p1 = new Point(e.getPoint());
            		drawing = true;
            	} else {
            		removeMouseMotionListener(constantDrawing);
            		p2 = new Point(e.getPoint());
            		rect = new Rectangle(p1);
            		rect.add(p2);
            		drawing = false;
            		repaint();
            	} 
            }        

        };
        
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g.create();
        g2d.drawImage(image, 0, 0, this);
        if (selection.width > 0 && selection.height > 0) {   	
        	g2d.setColor(colour);
        	g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 15));
        	if(selection.y>20) {
        		g2d.drawString(name, selection.x+selection.width/2-g2d.getFontMetrics().stringWidth(name)/2, selection.y-5);
        	} else {
        		g2d.drawString(name, selection.x+selection.width/2-g2d.getFontMetrics().stringWidth(name)/2, selection.y+15);
        	}
            g2d.draw(selection);
        }   
        g2d.dispose();
    }   
}