package gmit;

import java.util.LinkedList;
import java.util.Random;

public class CodeGenerator {
	private static final int MAX = 75000;
	private static final int HIGH = 99999;
	private Random random = new Random();
	
	public LinkedList<String> codes(){	//code will be roughly O(n) with n being roughly 75000 as it creates 5 digit codes until it reaches 75000 unique codes and then sets them in a 5 digit format regardless of the code digit length
		LinkedList<String> uniqueCodes = new LinkedList<String>();
		int i = 0;
		System.out.println("\nCode Generation -\tStarted");
				
		while(i < MAX) {
			String number = null;
			
			int nextRandom = random.nextInt(HIGH);
			
			number = String.format("%05d", nextRandom);
			
			if(!uniqueCodes.contains(number)) {
				uniqueCodes.offer(number);
				i++;
			}			
		}		
		
		System.out.println("Code Generation -\tFinished");
		return uniqueCodes;
	}
}
