package Application.classes;

import java.util.Vector;

import Application.interfaces.Obiect;

public class VctCrop {

	private Vector<String> vct=new Vector<>();
	
	/**
	 * Constructor de initializare cu parametri care adauga in lista obiectul de tipul unei clase existente
	 * @param list Vector care contine numele obiectelor
	 */
	public VctCrop(Vector<Obiect> list){
		for(int i=0;i<list.size();i++)
		{
			vct.add(i,list.get(i).getClass().getSimpleName());
		}
	}
	
	/**
	 * Getter pentru returnarea vectorului de obiecte existente
	 * @return vct Vector de obiecte
	 */
	public Vector<String> getvct() {
		return vct;
	}
	
}
