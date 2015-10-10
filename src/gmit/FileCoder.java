package gmit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FileCoder {
	private static final String WRITE_FILE = "encodedFile.txt";
	
	public void encoder(HashMap<String, List<String>> map, String file) throws Exception {	//encoder fills an arraylist with the corresponding values from a hashmap using the collection arraylist element 
		File writeFile = new File(WRITE_FILE);												//as a key which would take O(n). The method then checks for each value corresponding to the key if the code has been used before which in big O notation, 
		FileWriter fw = new FileWriter(writeFile);											//worst case scenario can be O(4n) as the maximum is 4 values per key.
		List<String> usedCodes = new ArrayList<String>();
		List<String> theValue = new LinkedList<String>();
		String code = "";
		FileParser parser = new FileParser();
		int j = 0;
		
		System.out.println("\nFile Encoding -\tStarted");
	
		if(!writeFile.exists())
			writeFile.createNewFile();
		
		ArrayList<String> collection = new ArrayList<String>(parser.parse(file));
		
		for (int i = 1; i <= collection.size(); i++) { // outer loop for each collection item, ie word
			List<String> values = new ArrayList<String>(map.get(collection.get(i - 1)));
			boolean entered = false;
			theValue.add(values.get(0));
			
			while (entered == false && j < values.size()) { // loop to add each code to file
				if (usedCodes.contains(theValue)) {
					j++;
				}
				
				else {
					entered = true;
					usedCodes.addAll(theValue);
					code = theValue.toString();
					code = code.substring(1, code.length() - 1);
					fw.write(code);
				}
			}
			
			theValue.remove(0);
			if ((i % 10) == 0 && i >= 10)
				fw.write(System.getProperty("line.separator"));
			
			else
				fw.write(" ");
		}
		
		fw.close();
		System.out.println("File Encoding -\tFinished");
		decoder(map, usedCodes);	
	}
	
	public void decoder(HashMap<String, List<String>> map, List<String> codes) throws IOException {	//decoder retrieves the arraylist of used codes from the encoder method (which is the same as the contents of the encoded file, 
		BufferedWriter bw = new BufferedWriter(new FileWriter("decodedFile.txt"));					//easier to use as it requires no reading in from a coding standpoint and being just as secure) and runs a while loop for the size of the
		String value = null;																		//arraylist (899 with commonEnglishWords.txt) and within runs a for loop to retrieve the key corresponding to the hashmap valueand writes
		int i = 1;																					//it into a file if the key has the right value. Taking n as being 899, this method runs at roughly O(2n)
		
		System.out.println("\nFile Decoding -\tStarted");
		while (i - 1 < codes.size()) {
			value = codes.get(i - 1);
			
			for(String theKey : map.keySet()) {//can retrieve every key

				if (map.get(theKey).contains(value)) {
					bw.write(theKey+ " ");
					break;
				}
			}
			
			if ((i % 10) == 0 && i >= 10)
				bw.newLine();
			
			else
				bw.write("\t");
			
			i++;
		}
		System.out.println("File Decoding -\tFinished");
		bw.close();
	}
}
