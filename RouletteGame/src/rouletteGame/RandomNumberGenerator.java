package rouletteGame;

import java.util.Random;

public class RandomNumberGenerator {

	
	private int rouletteNumber;
	Random randomNumber = new Random();
	//int randomNumber1 = this.randomNumber.nextInt(39)+1;
	
	public void setRouletteNumber(int rouletteNumber) {
		
		this.rouletteNumber = rouletteNumber;
	}
	public int getRouletteNumber() {
		//generate random number here
		return rouletteNumber;
	}
	

}