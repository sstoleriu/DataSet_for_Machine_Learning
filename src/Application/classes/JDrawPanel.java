package Application.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import Application.interfaces.Obiect;

/**
 * Clasa pentru desenarea chenarului
 */
public class JDrawPanel extends JPanel
	{

	private static final long serialVersionUID = 1L;
		private static BufferedImage image;
		private static BufferedImage imageBackup;
		private Rectangle rect;
		private static Vector<Obiect> listOfObjects = new Vector<Obiect>();
		private List<Rectangle> rectangles = new ArrayList<Rectangle>();
		private static JComboBox<String> selectObjectVar;
		private static Vector<String> names=new Vector<>();
		private static Vector<Color> colors=new Vector<>();
		private Graphics2D g2d;
		private int x, y;
		
		/**
		 * Getter pentru returnarea imaginii de decupat
		 * @return imageBackup Imaginea de backup pentru decupare
		 */
		public static BufferedImage getImageToCrop() {
			return imageBackup;
		}
		
		/**
		 * Getter pentru lista de obiecte pentru care se apeleaza metoda de desenare
		 * @return listOfObjects lista de obiecte create
		 */
		public Vector<Obiect> getList() {
			return listOfObjects;
		}
		
		/**
		 * Constructor de initializare cu parametri
		 * Adugare actiune la apasarea mouse-ului pentru optiunea de alegere din lista, 
		 *  preluare nume din lista si culori atribuite
		 * @param image Imaginea adaugata
		 * @param imageBackup Imaginea de backup
		 */
		public JDrawPanel(BufferedImage image, BufferedImage imageBackup)
		{
			JDrawPanel.image = image;
			JDrawPanel.imageBackup = imageBackup;
			MyMouseListener mouseAction = new MyMouseListener();
			addMouseListener(mouseAction);
			addMouseMotionListener(mouseAction);
			JDrawPanel.selectObjectVar = Application.classes.DrawStart.getComboBox();
			JDrawPanel.names = Application.classes.DrawStart.getNames();
			JDrawPanel.colors = Application.classes.DrawStart.getColor();
		}

		public JDrawPanel() {
		}
		
		@Override
		/**
		 * Getter pentru preluarea marimii preferate si predenifite pentru imagine
		 */
		public Dimension getPreferredSize()
		{
			return isPreferredSizeSet() ?
				super.getPreferredSize() : new Dimension(800, 543);
		}

		@Override
		/**
		 * Metoda de desenare a chenarului
		 */
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if (image != null){
				g.drawImage(image, 0, 0, null);
			}
				if (rect != null){
					g2d = (Graphics2D)g;
					
					Font myfont =new Font("TimesRoman", Font.PLAIN, 30);
					g2d.setStroke(new BasicStroke(3.0f));
					g2d.setFont(myfont);;
					g2d.setFont(myfont);
					g2d.setColor(colors.get(selectObjectVar.getSelectedIndex()));
					g2d.draw(rect);
					x = rect.x+rect.width/2-g2d.getFontMetrics().stringWidth(names.get(selectObjectVar.getSelectedIndex()))/2;
		            if(rect.y>30) {
		            	y = rect.y - 10;
		            } else {
		            	y = rect.y + 25;
		            }
		            g2d.drawString(names.get(selectObjectVar.getSelectedIndex()), x, y);
				}
		}

		
		/**
		 * Metoda pentru adaugarea chenarului si setarea culorii
		 * @param rectangle dreptunghiul creat prin selectarea a doua puncte pe imaginea incarcata in aplicatie
		 */
		public void addRectangle(Rectangle rectangle)
		{
			
			if(rect.width>10 && rect.height>10) {
			g2d = (Graphics2D)image.getGraphics();
			Font myfont =new Font("TimesRoman", Font.PLAIN, 30);
			g2d.setFont(myfont);
			g2d.setStroke(new BasicStroke(3.0f));
			
			g2d.setColor( colors.get(selectObjectVar.getSelectedIndex()) );
			g2d.draw( rectangle );
			g2d.drawString(names.get(selectObjectVar.getSelectedIndex()), x, y);
			repaint();
			rectangles.add(rect);
			CropTag newObject2 = new CropTag(colors.get(selectObjectVar.getSelectedIndex()), names.get(selectObjectVar.getSelectedIndex()), rect);
			listOfObjects.add(newObject2);
			} else {
				JFrame mesaj2 = new JFrame();
				JOptionPane.showMessageDialog(mesaj2,"Rectangle too small, please draw another one", "Warning", JOptionPane.WARNING_MESSAGE, new FileManager().getIcon("warn.png"));
				mesaj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				repaint();
			}
		}

		/**
		 * Metoda de stergere a dreptunghiurilor si redimensionarea imaginii la valorile presetate
		 * @throws IOException Exceptie de input/output
		 */
		public void clear() throws IOException
		{
			rectangles.clear();
			image = resizeImage(imageBackup, 800, 543);
			createEmptyImage();
			repaint();
		}
		
		/**
		 *  Metoda pentru redimensionarea imaginii
		 * @param originalImage Imaginea originala
		 * @param targetWidth Valoarea latimii
		 * @param targetHeight Valoarea lungimii
		 * @return outputImage Imaginea finala
		 * @throws IOException Exceptie de input/output
		 */
		public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
		    Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
		    BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		    outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		    return outputImage;
		}
		
		/**
		 * Metoda pentru clonarea imaginii existente in buffer
		 * @param image Imagine adaugata
		 * @return clone Imaginea clonata dupa imaginea originala
		 */
		public static final BufferedImage clone(BufferedImage image) {
		    BufferedImage clone = new BufferedImage(image.getWidth(),
		            image.getHeight(), image.getType());
		    Graphics2D g2d = clone.createGraphics();
		    g2d.drawImage(image, 0, 0, null);
		    g2d.dispose();
		    return clone;
		}
		
		/**
		 * Metoda de creare a unei imagini simple prin clonare
		 */
		private void createEmptyImage()
		{
			image = clone(image);
			g2d = (Graphics2D)image.getGraphics();
			
		}

		class MyMouseListener extends MouseInputAdapter
		{
		
			
			private Point startPoint;
			private boolean drawing = false;

			/**
			 *  Metoda care redimenisoneaza un chenar la miscarea mouse-ului 
			 */
			public void mouseMoved(MouseEvent e) {
				if(drawing) {
					int x = Math.min(startPoint.x, e.getX());
					int y = Math.min(startPoint.y, e.getY());
					int width = Math.abs(startPoint.x - e.getX());
					int height = Math.abs(startPoint.y - e.getY());
					rect.setBounds(x, y, width, height);
					repaint();
				}
			}
			
			/**
			 * Metoda care la apasarea mouse-ului preia punctul initial pentru desenarea chenarului
			 * si verifica daca masuratorile sunt valide pentru adaugarea unui dreptunghi
			 */
			public void mousePressed(MouseEvent e)
			{
				if(drawing == false) {
				drawing = true;
				startPoint = e.getPoint();
				rect = new Rectangle();
				} else {
					drawing = false;
					if (rect.width != 0 || rect.height != 0)
					{
						addRectangle(rect);
					}	
					rect = null;
				}
			}

		}
	}