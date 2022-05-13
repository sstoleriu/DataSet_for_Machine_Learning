package Application.classes;

import java.io.File;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class FileBackground {
	
	private MarvinImage image;
	private File file = new File("src/Application/resources/test.png");
	
	FileBackground(){
		image = MarvinImageIO.loadImage(file.toString());
	}
	
	public MarvinImage getBackground() {
		return image;
	}
	
}
