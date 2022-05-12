package Application.classes;

import java.util.Vector;

import Application.interfaces.Obiect;

public class VctCrop {

	private Vector<String> vct=new Vector<>();
	
	VctCrop(Vector<Obiect> list){
		for(int i=0;i<list.size();i++)
		{
			vct.add(i,list.get(i).getName());
			//vct.add(i,list.get(i).getClass().getSimpleName());
		}
	}
	
	public Vector<String> getvct() {
		return vct;
	}
	
}
