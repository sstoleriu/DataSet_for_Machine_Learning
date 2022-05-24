package Application.classes;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
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

}
