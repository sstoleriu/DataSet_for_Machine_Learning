package Application.classes;

import java.util.Vector;

public class VctCrop {

	private String vct[];
	
	VctCrop(Vector<Object> list){
		int n=list.size();
		Object[] array =list.toArray();
		for(int i=0;i<n;i++)
		{
			vct[i]=array[i].getClass().getSimpleName();
		}
	}
	
	public String[] getvct() {
		return vct;
	}
	
}
