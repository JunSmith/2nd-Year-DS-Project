package gmit;

import java.io.*;
import java.util.ArrayList;

public class FileParser {
	
	private static final int CHAR_MIN = 97;
	private static final int CHAR_MAX = 122;

	public ArrayList<String> parse(String file) throws Exception {	//parse method should be roughly O(2n) as	it has to read in each line from the file as well as insert it into a string array	
		ArrayList<String> col = new ArrayList<String>();			//and pass the array into another method to process the words
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		System.out.println("\nFile Parsing -\tStarted");
		
		while((line = reader.readLine()) != null){
			String[] words = line.split(" ");
			
			for(int i = 0; i < words.length; i++) {
				String next = process(words[i]);
				
				if(next != null)
					col.add(next);
			}
		}
		reader.close();
		System.out.println("File Parsing -\tStarted");
		return col;
	}

	public String process(String string) {		//process method should be O(n + 2) as it trims and sets all letters to lowercase and uses a for loop for each character in the imported string
		String s = string.trim().toLowerCase();
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) <= CHAR_MAX && s.charAt(i) >= CHAR_MIN)
				buffer.append(s.charAt(i));
			
			else
				break;
		}
		
		return buffer.toString();
	}
}
