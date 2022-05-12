package Application.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class FileName {

	private Vector<String> names = new Vector<>();
	File name = new File("src/Application/classes/name_tags");
	Path path = Paths.get(name.getAbsolutePath());
	
	FileName() throws IOException{
		BufferedReader br_name = Files.newBufferedReader(path);
		String line = null;
		while((line = br_name.readLine()) != null) { 
			names.add(line);		
		}
		br_name.close();
	}
	
	public Vector<String> getlistname(){
		return names;
	}
	
	public void changelinename() throws IOException {
		name.delete();
		name.createNewFile();
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
			writer.write(""+names.get(0));
			for(int index=1; index<names.size(); index++) {			
				writer.write(System.lineSeparator()+names.get(index));
			}
		}
	}
	
	public void deletelinename(int index_delete) throws IOException {
		name.delete();
		name.createNewFile();
		int indexprimal=0;
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
			if(index_delete==0) {
			writer.write(""+names.get(1));
			indexprimal+=2;
			}else {
				writer.write(""+names.get(0));
				indexprimal++;
			}
			for(int index=indexprimal; index<names.size(); index++) {
				if(index!=index_delete)
				writer.write(System.lineSeparator()+names.get(index));
			}
		}
	}
	
	public boolean tagexist(String tagtba) throws IOException {
		BufferedReader br_name = Files.newBufferedReader(path);
		String line = null;
		while((line = br_name.readLine()) != null) { 
			if(line.equals(tagtba)) {
				return true;
			}
		}
		return false;
	}
	
}
