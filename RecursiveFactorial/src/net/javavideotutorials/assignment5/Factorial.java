package net.javavideotutorials.assignment5;

public class Factorial 
{
  /**
   * This method is where all the magic happens.  This will be
   * your recursive method that will (in the end) return the
   * proper total of the factorial number that's passed in. 
   * @param value variable represents the factorial numbers being
   *        multiplied... so if you're solving 5!, the first 'value'
   *        passed in here should be 5.
   * @return the total of the factorial calculation so, 5! should equal 120
   */
 private int index =0; //dont want method to assign index more than once so intialize outside method
  public int factorial(int value)
  {
	  
	if(index==0) //if index hasnt been assinged a value 
		{
			index=value; //index equal to first value being passed in
		}
	index--; 
	value *= index; // value is equal to values times index 
		
	if(index == 1)  
    return value; //once index is at one return value
	 
	
    return factorial(value);//if index is not 1 then has method call itself
  }
}
