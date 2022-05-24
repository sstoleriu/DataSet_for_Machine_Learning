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

public class FileColorTest {

	@Test
	public void testDeletelinecolor() throws IOException {
		FileColor f1=new FileColor();
		long lineCount, cnt;
		File name = new File("src/Application/resources/memory/color_tags");
		Path path = Paths.get(name.getAbsolutePath());
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
		  lineCount = stream.count();
		}
		cnt=lineCount-1;
		if(cnt>0){
		f1.deletelinecolor(1);
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
public void testDeletelinecolor1() throws IOException {
	FileColor f1=new FileColor();
	long lineCount,cnt;
	File name = new File("src/Application/resources/memory/color_tags");
	Path path = Paths.get(name.getAbsolutePath());
	try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
	  lineCount = stream.count();
	}
	cnt=lineCount-1;
	if(cnt>0){
	f1.deletelinecolor(1);
	long lineCount2;
	try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
	  lineCount2 = stream.count();
	}
	assertNotEquals(lineCount, lineCount2);
	}
	else 
		assertEquals(cnt,0);
	
	}
}

