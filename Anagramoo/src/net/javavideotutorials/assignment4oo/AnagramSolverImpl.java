package net.javavideotutorials.assignment4oo;

import java.util.Arrays;


//import java.util.Arrays;

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
	
		  
	
		
	
		
			if (hasNullValues(word1, word2) == false || hasSameWordLength(word1, word2) == false  )
				
			return false;
			
			if (hasSameCaseSensivity( word1, word2)== true)
			return true;
			else if (checkforDuplicates(word1, word2) == false )
			return false;
		
		
			
	
			return true;
		
	}
	
	
public boolean hasNullValues(String word1, String word2)
{
	boolean isAnagram = true;
	if (word1 == null ||  word2 == null)
	 isAnagram = false;
	
	return isAnagram; 
}
public boolean hasSameWordLength(String word1, String word2)
{
	boolean isAnagram = true;
	if(word1.length() != word2.length() )
	isAnagram = false; //return false is lengths are different
	
	return isAnagram; 
}
public boolean hasSameCaseSensivity(String word1, String word2)
{
	
	

	boolean isAnagram = false;
	char[] word1arr= word1.toLowerCase().toCharArray(); //transform fords into array of lowercase charcters
	char[] word2arr = word2.toLowerCase().toCharArray();
	Arrays.sort(word1arr); //sort arrays
	Arrays.sort(word2arr);
	
	if(Arrays.equals(word1arr, word2arr)) //should be the same since sorted and converted to lowercase;
		isAnagram = true;
	
		

	return isAnagram; 
}

public boolean checkforDuplicates(String word1, String word2)
{
	boolean isAnagram = false;

			
	for(int i=0;i<word1.length();i++){ //iterate through string1
		char c = word1.charAt(i);	//store index in character
		if(word2.contains("" + c) == false){ //if word2 does not contain the value at the index
			 isAnagram=false;			//is not an anagram
			 break; //break loop and go to return of method
		}
		for(int j =0;i<word2.length()-1;j++){ //iterate through word2 
			char d = word2.charAt(j); //store the charcter in word2 at index
			if (c == d){ 
				word2 = word2.substring(0, j)+ word2.substring(j+1);//create new word2 between the word before and after the removed charcter
				break;											//go back to first loop so you dont remove more than one value at a time
				}

			
		}
	}
	
	return isAnagram; 
}

}
