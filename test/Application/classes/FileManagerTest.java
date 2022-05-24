package Application.classes;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.IOException;
import javax.swing.Icon;

import org.junit.Test;

public class FileManagerTest {

	@Test
	public void testFileExist() {
		FileManager f1=new FileManager();
		assertEquals(f1.FileExist("src/Application/resources/images/"), true);
	}
	
	@Test
	public void testFileExist1() {
		FileManager f1=new FileManager();
		assertNotEquals(f1.FileExist("src/Aplicatie/resurse"), true);
	}
	
	@Test
	public void testGetIcon() {
		String iconSecondPath = "1export.png";
		Icon template = new FileManager().getIcon(iconSecondPath);
		assertNotNull(template);
	}

	@Test
	public void testGetImage() throws IOException {
		String iconSecondPath = "tagmenu.png";
		Image template = new FileManager().getImage(iconSecondPath);
		assertNotNull(template);
	}

}
