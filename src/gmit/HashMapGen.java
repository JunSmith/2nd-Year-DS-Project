package gmit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HashMapGen {
	CodeGenerator gen = new CodeGenerator();
	FileParser parser = new FileParser();
	
	private LinkedList<String> uniqueCodes = new LinkedList<String>(gen.codes());
	private HashMap<String, List<String>> encoded = new HashMap<String, List<String>>();
	String word;
	
	public HashMap<String, List<String>> encoder(ArrayList<String> collection) { 	//will run at "O(n log(n)" as it requires getting an item from a collection at known index as well as 
		System.out.println("\nHashMap Generator -\tStarted");							//insert a word into an arraylist - all of which has to be done for every entry in the arraylist generated in FileParser
		int size = collection.size();
		

		for(int i = 0; i < size; i++) {
			word = collection.get(i);
			
			if(i >= 0 && i < 25) 	{				
				encoded.put(word, new ArrayList<String>());
				addCodes(4);
			}
						
			else if (i >= 25 && i < 100) {
				encoded.put(word, new ArrayList<String>());
				addCodes(3);
			}
						
			else if (i >= 100 && i < 200) {
				encoded.put(word, new ArrayList<String>());
				addCodes(2);
			}
						
			else {
				encoded.put(word, new ArrayList<String>());
				addCodes(1);
			}
		}
		
		System.out.println("HashMap Generator -\tFinished");	
		return encoded;
	}
	
	public void addCodes(int count) {	
		for(int i = 0; i < count; i++) 
			encoded.get(word).add(i, uniqueCodes.poll());
	}
}
