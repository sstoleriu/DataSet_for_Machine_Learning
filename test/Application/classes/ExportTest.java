package Application.classes;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JButton;

import org.junit.Test;

import Application.interfaces.Obiect;

public class ExportTest {

	@Test
	public void testCropImage() {
		JButton export = null;
		Vector<Obiect> listOfObjects = null;
		BufferedImage img = new BufferedImage(256, 256,BufferedImage.TYPE_INT_RGB);
		Rectangle rect = new Rectangle(4,7,10,10);
		BufferedImage template = null;
		template = new Export(export, listOfObjects).cropImage(img, rect);
		assertNotNull(template);
	}

}
