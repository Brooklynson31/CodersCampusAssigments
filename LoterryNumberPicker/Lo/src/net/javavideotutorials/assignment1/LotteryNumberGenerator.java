package net.javavideotutorials.assignment1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotteryNumberGenerator 
{

  /**
   * This method should return a Set of 6 different
   * integers.  
   * 
   * Hint: use the 'Random' class located here: java.util.Random
   *       to generate random numbers
   * @return
   */
  public Set<Integer> generateLotteryNumbers ()
  {
	  Set<Integer> randomGenerator = new  HashSet<Integer>(6); 
	  Random randomnum = new Random();
	  
	

	  
	  for (Integer i=0; i<6;i++) 
	  {
		  //keep looping until able to add a add number into a set that does not not exist and is between 1 and49
		  
		 while (randomGenerator.add(1+randomnum.nextInt(49)) == false) {
			 
			
		  }
		  

	  }
	 
	  
	  
    return randomGenerator;
    
  }
}
