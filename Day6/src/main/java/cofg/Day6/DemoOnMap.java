package cofg.Day6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class DemoOnMap {
	public static void main(String[] args) {
		HashMap<Integer, String>hashMap=new HashMap<Integer, String>();
		hashMap.put(1, "Ashu");
		hashMap.put(2, "Neeku");
		hashMap.put(3, "Amit");
		hashMap.put(4,"Rahul");
		System.out.println(hashMap);
		
		for(Integer key:hashMap.keySet())
		System.out.println(key);
		for(String val:hashMap.values());
		System.out.println(hashMap.containsKey(5));
		System.out.println(hashMap.containsValue("Ashu"));
		Set<Entry<Integer,String>> entrySet=hashMap.entrySet();
		System.out.println(entrySet);
		Iterator<Entry<Integer, String>> itr=entrySet.iterator();
		while(itr.hasNext())
		System.out.println(itr.next());
		System.out.println(hashMap.get(7));
		//treeMap
		TreeMap<Integer,String>fruitTree=new TreeMap<Integer,String>();
		fruitTree.put(1,"Appple");
		fruitTree.put(2,"grapes");
		
		

		fruitTree.put(3,"Lemon");
		
		

		fruitTree.put(4,"orange");
		System.out.println(fruitTree);
		for(Integer key:fruitTree.keySet())
			System.out.println(key+"---->"+fruitTree);
		
		

		
		
	}
	

}
