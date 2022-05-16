package Application.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class VctFreq {
	private String name[];
	private Integer contor[];
	Map<String, Integer> freqMap=new HashMap<>();
	
	/**
	 * Constructor de initializare cu parametri
	 * @param allvct Vector care contine numele obiectului si indexul(contorul)
	 */
	public VctFreq(Vector<String> allvct){
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
	
	/**
	 * Getter pentru returnarea numelui obiectelor
	 *  - va fi utilizat la redenumirea pozelor decupate si exportate
	 * @return name Numele obiectelor care se pot selecta
	 */
	public String[] getName_VctFreq() {
		return name;
	}
	
	/**
	 * Getter pentru returnarea contorului
	 *  - va fi utilizat pentru adaugarea indecsilor in redenumirea pozelor in ordinea selectarii lor
	 * @return contor Indexul corespunzator ordinii selectarii
	 */
	public Integer[] getContor_VctFreq() {
		return contor;
	}
}
