package Application.classes;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.nio.charset.*;
public class FileNameTest {

	@Test
	public void testDeletelinename() throws IOException {
		FileName f1=new FileName();
		long lineCount, cnt;
		File name = new File("src/Application/resources/memory/name_tags");
		Path path = Paths.get(name.getAbsolutePath());
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
		  lineCount = stream.count();
		}
		cnt=lineCount-1;
		if(cnt>0){
		f1.deletelinename(1);
		long lineCount2;
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
		  lineCount2 = stream.count();
		}
		assertEquals(cnt, lineCount2);
		}
		else 
			assertEquals(cnt,0);
	}
	
	@Test
	public void testDeletelinename1() throws IOException {
		FileName f1=new FileName();
		long lineCount, cnt;
		File name = new File("src/Application/resources/memory/name_tags");
		Path path = Paths.get(name.getAbsolutePath());
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
		  lineCount = stream.count();
		}
		cnt=lineCount-1;
		if(cnt>0){
		f1.deletelinename(1);
		long lineCount2;
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
		  lineCount2 = stream.count();
		}
		assertNotEquals(lineCount, lineCount2);
		}
		else 
			assertEquals(cnt,0);
	}
	
	@Test
	public void testTagexist() throws IOException {
		FileName f1=new FileName();
		assertEquals(f1.tagexist("Autobuz"), true);
	}
	@Test
	public void testTagexist1() throws IOException {
		FileName f1=new FileName();
		assertNotEquals(f1.tagexist("Invalid"), true);
	}

}
