package net.javavideotutorials.assignment1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LotteryNumberPicker 
{

  /**
   * This method should pull input from the user in the console.  It should
   * gather 6 Integers from the user and then store these numbers in a Set of
   * Integers that will then be returned by the method.
   * 
   * Hint: use the following code to get numbers:
   * 
   * Scanner in = new Scanner(System.in);
   * in.nextInt();
   * 
   * @return Set of 6 numbers that were chosen by the user
   * @throws IOException
   */
  public Set<Integer> promptUserForLotteryNumbers () throws IOException
  {
		//Integer userPick; //integer that will be used to check user input
		Set<Integer> userLotteryNumbers = new HashSet<Integer>(6);
		
		Scanner in = new Scanner(System.in); //create scanner object in that takes user input
		boolean error = false;
		
		System.out.println("Enter an Integer into the set betweeen 1 and 49 :");
		
		
		do{
			try
				{
				error = false; //sets error to false because tere is no error
					in.nextInt();
						if ( (in.nextInt() >50) || (in.nextInt() < 1) )
							{
								throw new IOException(); 
							}
						
				}
			
			catch (IOException e) 
				{
				error = true; //acknowledge there is an error  and so after we handle the error while its true the loop resets
				e.printStackTrace();
				}
			finally {
		 		in.close();
		 	}
				
				 	if (!(userLotteryNumbers.add(in.nextInt()))) 
				 	{
					  System.out.println("You already picked that number, choose again");
					  in.nextInt();
					  userLotteryNumbers.add(in.nextInt());
					  in.close();
					  }
				 	
				  } while ((error) && (userLotteryNumbers.size() < 7));//keep running loop until there is not an errors or the set is filled
			
	    return userLotteryNumbers;
    
  }
}
