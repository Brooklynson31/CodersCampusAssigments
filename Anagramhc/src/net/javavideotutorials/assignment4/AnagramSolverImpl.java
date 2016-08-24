package net.javavideotutorials.assignment4;

import java.util.HashMap;
import java.util.Map;

import net.javavideotutorials.assignment4.AnagramSolver;
/**
 * This class should implement the AnagramSolver interface, the
 * naming convention here is a Java standard, any class that implements
 * an interface should end with the letters Impl (suggesting it's an
 * implementation of an interface)
 * 
 * @author Trevor Page
 */
public class AnagramSolverImpl implements AnagramSolver
{
	public boolean isAnAnagram(String word1, String word2) {
		
		if(word1 == null || word2 == null)
			return false;
		
		if (word1.length() != word2.length())
			return false;
		
		word2 = word2.toLowerCase();
		word1 = word1.toLowerCase();
		
	Map<Character,Integer> word1Map = new HashMap<Character,Integer>();		
	Map<Character,Integer> word2Map = new HashMap<Character,Integer>(); //create 2 maps, key is a letter and the value is the amount of letters seen
	Check_for_duplicates(word1, word1Map);
	Check_for_duplicates(word2, word2Map);
	
	if(word1Map.equals(word2Map))
		return true;
	else{
		return false;
	}
}

	public void Check_for_duplicates(String word, Map<Character, Integer> wordMap) {
		for(int i=0;i<word.length();i++) {
			Character c = word.charAt(i); //store the letter value at word index
			if (wordMap.containsKey(c)){ //if the letter is present in the key
				
				Integer lettercount = wordMap.get(c); //increase the value(amount of time letter appeawrs
				lettercount++;							
				wordMap.put(c, lettercount); //re enter the letter with new value(overrides previous values)
				
			}
			else {
				wordMap.put(c, 1); // put in letter with 1 as occurences
			}
				
		}
	}
}