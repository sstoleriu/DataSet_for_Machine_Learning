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

/**
 * Clasa pentru numele fisierului 
 */
public class FileName {

	private Vector<String> names = new Vector<>();
	File name = new File("src/Application/resources/memory/name_tags");
	Path path = Paths.get(name.getAbsolutePath());
	
	/**
	 * 
	 */
	FileName() throws IOException{
		BufferedReader br_name = Files.newBufferedReader(path);
		String line = null;
		while((line = br_name.readLine()) != null) { 
			names.add(line);		
		}
		br_name.close();
	}
	
	/**
	 * Getter pentru vectorul listei cu nume fisierelor
	 * @return names Vectorul cu numele fisierelor
	 */
	public Vector<String> getlistname(){
		return names;
	}
	
	/**
	 * Getter pentru preluarea path-uli
	 * @return path Path-ul ales
	 */
	public Path getPathn() {
		return path;
	}
	
	/**
	 * Metoda pentru schimbarea numelui fisierului
	 */
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
	
	/**
	 * Metoda pentru stergerea numelui fisierului
	 * @param index_delete
	 * @throws IOException
	 */
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
	
	/**
	 * Metoda de verificare a existentei tag-ului
	 * @param tagtba Tag-ul de verificat
	 */
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
