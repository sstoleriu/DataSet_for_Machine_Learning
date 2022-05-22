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
 * Clasa pentru gestionarea fisierului care contine numele obiectelor
 */
public class FileName {

	private Vector<String> names = new Vector<>();
	File name = new File("src/Application/resources/memory/name_tags");
	Path path = Paths.get(name.getAbsolutePath());
	
	/**
	 * Constructorul clasei
	 *  - Adauga o linie in fisierul cu numele obiectelor
	 *  @throws IOException Exceptie de input/output
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
	 * Metoda pentru schimbarea unei linii din fisier cu nume
	 * @throws IOException Exceptie de input/output
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
	 * Metoda pentru stergerea unei linii din fisierul cu nume
	 * @param index_delete indexul liniei care va fi stearsa
	 * @throws IOException IOException Exceptie de input/output
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
	 * @throws IOException Exceptie de input/output
	 * @return true/false
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
