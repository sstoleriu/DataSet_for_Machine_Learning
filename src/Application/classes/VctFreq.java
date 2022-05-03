package Application.classes;

import java.util.HashMap;
import java.util.Map;

public class VctFreq {
	private String name[];
	private Integer contor[];
	Map<String, Integer> freqMap=new HashMap<>();
	
	VctFreq(String tags[]){
		for(int i=0;i<tags.length;i++)
		{
			if(freqMap.containsKey(tags[i])) {
				Integer count = freqMap.get(tags[i]);
				freqMap.put(tags[i], count+1);
			} else {
				freqMap.put(tags[i],1);
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
