import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class RouletteWheel {


//need major method that runs the game

private List<RouletteNumber> rouletteWheel = new ArrayList<RouletteNumber>();
private Integer numofSpins;
//major method
//need to record totalBets made
//make sure determine is accounted for
//number of spins account of
//if i want to have method that determines bet money need to refactor that

// need code for determining how many times you want to spin and the player choice
// should use try catch for user input
// what to name method that will run the game
public void setUpRouletteGame(List<RouletteNumber>rouletteWheel){
	rouletteWheel = makeRouletteWheel(); 
	numofSpins = determineSpins();
	RouletteColors playerChoice = makeColorChoice();
	
	playGame(numofSpins, playerChoice, rouletteWheel);


}


public boolean playGame(int numofSpins, RouletteColors playerChoice, List<RouletteNumber>rouletteWheel){

	boolean gameOver = false;
	boolean winner = false;
	Long currentBet = 0L;
	Long lastBet = 0L;
//	int totalBet = 0;
//	int totalWinnings = 0;
	Long totalBet = 0L;
	Long totalWinnings = 0L;
	Long firstBet = 10L;
	
	for(int index = 1; index <= numofSpins && winner == false; index++){
		if(index == 1){
			 lastBet = firstBet;
			 totalBet += lastBet;
		}
		else{
			 currentBet = (lastBet*2);
			 totalBet += currentBet;
			 lastBet = currentBet;
		}
			
		RouletteNumber spinResult = spinWheel(rouletteWheel); // spin the wheel
		winner = DetermineWinner(spinResult, playerChoice);
		
		if(winner){ //display winning results if winner is true
			totalWinnings = lastBet*2; 
			winningResults( index,  totalBet,  totalWinnings);
			}
		
		else if( index == numofSpins &&  !(winner) ){ //on last spin and winner is still false
			losingResults(totalBet);
		}
	
	}
	
	//gameOver = winner;
	gameOver = true;
	return gameOver;
}







public List<RouletteNumber> makeRouletteWheel() {
	List<RouletteNumber> rouletteWheel = new ArrayList<RouletteNumber>();
	RouletteColors BLACK = RouletteColors.Black;
	RouletteColors RED = RouletteColors.Red;
	RouletteColors GREEN = RouletteColors.Green;
	
	for(int index = 0; index < 38 ;index++){
		if(index == 0 || index == 37){
			RouletteNumber GreenNumbers = new RouletteNumber(index,GREEN);
			rouletteWheel.add(GreenNumbers);
		}
			else	
			{
				if ( (index % 2) == 0 ){
					RouletteNumber BlackNumbers = new RouletteNumber(index,BLACK);
					rouletteWheel.add(BlackNumbers);
				}
				else if( (index % 2) == 1){
					RouletteNumber RedNumbers = new RouletteNumber(index,RED);
					rouletteWheel.add(RedNumbers);
				}
			}
	}

	// TODO Auto-generated method stub
	return rouletteWheel;
}

//pass in rouletteWheel and spin it
public RouletteNumber spinWheel(List<RouletteNumber> rouletteWheel){
	Random ranGenerator = new Random();
	int index = ranGenerator.nextInt(rouletteWheel.size()-1);
	RouletteNumber wheelResult = rouletteWheel.get(index);
	
	return wheelResult;
}



//make color choice
 public RouletteColors makeColorChoice(){
	
	 boolean validChoice = false;
	 String redChoice = "red";
	 String blackChoice ="black";
	 RouletteColors colorChoice = null;
	 
	 

	 while(!validChoice){

		 System.out.println("Which color would you like to bet on this Cycle? (Red or Black)");
		 Scanner userInput = new Scanner(System.in);
		 String choice = userInput.nextLine();
		 try{
			 if( choice.equalsIgnoreCase(blackChoice) )
			 	{
				 validChoice = true;
				 colorChoice = RouletteColors.Black;
			 	} 
				 else if ( choice.equalsIgnoreCase(redChoice) ){
					 validChoice = true;
				 	 colorChoice = RouletteColors.Black;
				 }
			else{
				 throw new IOException();
				 }
		 	}
		catch (IOException e){
			System.out.println("Invalid input, please try again");
			 validChoice = false;
		}
		 finally{
				userInput.close();
			}
	 }
		
	 
 return colorChoice;
 }
 

 
 public boolean DetermineWinner(RouletteNumber spinResult, RouletteColors colorChoice){
	boolean isWinner = false;
	 
	if (spinResult.getColor().equals(colorChoice)){
			isWinner = true;
			System.out.println("You have landed on " + colorChoice + " you win!");
			
	}
	else{
		isWinner = false;
		System.out.println("maybe next time");
		}
	
	 
 return isWinner;
 }
 
 //prints Winning Results
public void winningResults(Integer numofSpins, Long totalBet, Long totalWinnings){
		System.out.println("Total needed to Win :" + totalBet);
		System.out.println("TotalWinnings : " + totalWinnings );
		System.out.println("numBer of Spins: "+ numofSpins);

}

//printsLosing results
public void losingResults(Long totalBet){
	System.out.println("maybe next time");
	System.out.println("Total Lost:" + totalBet);

}
 

//asks user for amount of spins
//use a single global scanner objects and use it in both methods, no need tto pass as parameter
//if that doesnt work, take input for both method in a single method so that you only need to close once
 public Integer determineSpins(){
	 boolean validChoice = false;
	Integer desiredSpins = 0;


	 while(!validChoice){

	 	 System.out.println("Input how many times you'd like to spin this cycle: (ex: 10)");
	 	 Scanner spinInput = new Scanner(System.in);
	 	 desiredSpins = spinInput.nextInt();
	 	 try{
	 		 if( desiredSpins > 0 ) //check user input for int
	 		 	{
	 			 validChoice =true;
	 			 }
	 		else{
	 			 throw new IOException();
	 			 }
	 	 	}
	 	catch (IOException e){
	 		System.out.println("Invalid input, please try again");
	 		 validChoice = false;
	 	}
	 	 finally{
	 			spinInput.close();
	 		}
	 }
	 
	 return desiredSpins;
	 }
 
// 
 public void amountNededtoWin(int totalBet, int numofSpins, int totalWinnings){
	 int minvalue = (numofSpins*10);
	 
	 if( minvalue > totalWinnings){
	 		System.out.println("Invalid input, please try again");
	 		System.out.println("Invalid input, please try again");

	 }
	 else
	 {
		 
	 }
	
 }
// 
// 
// public Integer totalWinnings(boolean isWinner, Integer lastBet, Integer totalBet){
//	 int totalWinnings = 0;
//	 
//	 if(isWinner){
//		  totalWinnings = lastBet;
//		 //System out print ln(that proints out the total bet
//		  }
//	 else{
//		 totalWinnings = 0;
//		 
//	 	}
//	 
//	 return totalWinnings;
// }
// public String Results( int numofdesignedSpins, RouletteColors colorchoice ){
//		//while num of spins is less than spin amount
//		String result = "";
//		
//		return result;
//	}
 
 //		//winner = DetermineWinner(spinResult,  playerChoice, totalBet, numofSpins, lastBet*2); //determine winner

//public boolean DetermineWinner(RouletteNumber spinResult, RouletteColors colorChoice, Integer totalBet, Integer numofSpins, Integer totalWinnings){
//	boolean isWinner = false;
//	 
//	if (spinResult.getColor().equals(colorChoice)){
//			isWinner = true;
//			System.out.println("You have landed on" + colorChoice + " you win!");
//			System.out.println("Total Bet this cycle :" + totalBet);
//			System.out.println("TotalWinnings : " + totalWinnings );
//			System.out.println("numBer of Spins: "+ numofSpins);
//	}
//	else{
//		isWinner = false;
//		System.out.println("maybe next time");
//		System.out.println("Total Lost:" + totalBet);
//	}
//	
//	 
//return isWinner;
//}
}
