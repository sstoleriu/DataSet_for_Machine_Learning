package Application.classes;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DrawStartTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testResizeImage()throws IOException {
		JPanel panel=new JPanel();
		JButton refresh=new JButton();
		JButton export=new JButton();
		Vector<String> names=new Vector<String>();
		Vector<Color> colors =new Vector<Color>();
		Image image = null;
		BufferedImage originalImage=ImageIO.read(new File("src/Application/resources/images/1credits.png"));
		DrawStart d1=new DrawStart(panel,refresh,export,names,colors,image);
	
		assertNotEquals(d1.resizeImage(originalImage,800, 543), originalImage);
		
	}

}
