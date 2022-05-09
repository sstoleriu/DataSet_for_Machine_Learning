package Application.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class VctFreq {
	private String name[];
	private Integer contor[];
	Map<String, Integer> freqMap=new HashMap<>();
	
	VctFreq(Vector<String> allvct){
		for(int i=0;i<allvct.size();i++)
		{
			if(freqMap.containsKey(allvct.get(i))) {
				Integer count = freqMap.get(allvct.get(i));
				freqMap.put(allvct.get(i), count+1);
			} else {
				freqMap.put(allvct.get(i),1);
			}
		}
		name=freqMap.keySet().toArray(new String[0]);
		contor=freqMap.values().toArray(new Integer[0]);
	}
	
	public String[] getName_VctFreq() {
		return name;
	}
	
	public Integer[] getContor_VctFreq() {
		return contor;
	}
}
