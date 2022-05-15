package Application.classes;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class FileColor {
	
	private Vector<Color> colors = new Vector<Color>();
	private File color = new File("src/Application/resources/memory/color_tags");
	private Path path = Paths.get(color.getAbsolutePath());
	
	FileColor() throws IOException{
		BufferedReader br_color = Files.newBufferedReader(path);
		String line = null;
		while((line = br_color.readLine()) != null) { 
			int rgb = Integer.parseInt(line);
			Color newColor = new Color(rgb);
			colors.add(newColor);		
		}
		br_color.close();
	}
	
	public Vector<Color> getlistcolor(){
		return colors;
	}
	
	public Path getPathc() {
		return path;
	}
	
	public void changelinecolor() throws IOException {
		color.delete();
		color.createNewFile();
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
			writer.write(""+colors.get(0).getRGB());
			for(int index=1; index<colors.size(); index++) {			
				writer.write(System.lineSeparator()+colors.get(index).getRGB());
			}
		}
	}
	
	public void deletelinecolor(int index_delete) throws IOException {
		color.delete();
		color.createNewFile();
		int indexprimal=0;
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
			if(index_delete==0) {
			writer.write(""+colors.get(1).getRGB());
			indexprimal+=2;
			}
			else {
				writer.write(""+colors.get(0).getRGB());
				indexprimal++;
			}
			for(int index=indexprimal; index<colors.size(); index++) {
				if(index!=index_delete)
				writer.write(System.lineSeparator()+colors.get(index).getRGB());
			}
		}
	}
}
