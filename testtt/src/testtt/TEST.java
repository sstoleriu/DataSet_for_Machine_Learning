package testtt;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TEST {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		BufferedImage img = ImageIO.read(new File("poza.jpeg"));
		Graphics2D g2d = img.createGraphics();
		g2d.setColor(Color.RED);
		g2d.drawRect(200, 200, 300, 300);
		g2d.dispose();
	
		    File outputfile = new File("saved.jpeg");
		    ImageIO.write(img, "jpeg", outputfile);
		  
	

	}

}
