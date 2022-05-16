package Application.classes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SelectionExample {

	private static boolean ok = false;
	private static DrawRect2 startDraw;
	
	public static void main(String[] args) {
        new SelectionExample();
    }

    public SelectionExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                JFrame frame = new JFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);
                frame.pack();
                frame.setVisible(true);
                frame.setBounds(100, 100, 1050, 600);
                frame.setLocationRelativeTo(null);
                
                JButton Refresh = new JButton("Refresh");
        		Refresh.setBounds(839, 265, 187, 41);
        		Refresh.setFocusPainted(false);
        		frame.getContentPane().add(Refresh);

        		ActionListener refreshAction = new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				if(ok == false) {
        					try {
								startDraw.changeImageDraw(new FileManager().getImage("tagmenu.png"));
								ok = true;
							} catch (IOException e1) {}
        				} else {
        					try {
								startDraw.changeImageDraw(new FileManager().getImage("startDataSet.png"));
								ok = false;
							} catch (IOException e1) {}
        				}
        			}
        		};
        		Refresh.addActionListener(refreshAction);
                
                JPanel paneldraw = new JPanel();
                paneldraw.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                paneldraw.setLayout(new BorderLayout());
					try {
						startDraw= new DrawRect2(Color.CYAN, "Done", new FileManager().getImage("startDataSet.png"));
					} catch (IOException e1) {}
				paneldraw.add(startDraw);

                //frame.getContentPane().add(paneldraw);
                paneldraw.setBounds(10, 10, 800, 543);
                
                JButton Icons = new JButton();
        		Icons.setFocusPainted(false);
        		Icons.setBounds(839, 461, 90, 41);
        		frame.getContentPane().add(Icons);
        		
        		JButton Credits = new JButton();
        		Credits.setFocusPainted(false);
        		Credits.setBounds(936, 461, 90, 41);
        		frame.getContentPane().add(Credits);
                
                JButton Reset = new JButton();
        		Reset.setFocusPainted(false);
        		Reset.setBounds(894, 510, 90, 41);
        		frame.getContentPane().add(Reset);
                
            }
        });
    }

    public class DrawRect2 extends JPanel {
    	
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
        
        public void changeImageDraw(Image image) {
        	this.image = image;
        	repaint();
        }
        
        public Rectangle getRectangle() {
        	return rect;
        }
        
        public DrawRect2(Color colour, String name, Image image) {
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
}