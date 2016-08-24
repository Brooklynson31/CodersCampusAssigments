package rouletteGame;

import java.util.ArrayList;
import java.util.List;

public class RouletteWheel {
	
	  private List<RouletteNumber> numbers = new ArrayList<RouletteNumber>();
	  
RandomNumberGenerator r = new RandomNumberGenerator();
Integer a = r.getRouletteNumber();
int g;
//r.setRouletteNumber(g);
RouletteColors guess = RouletteColors.Black;
RouletteNumber b = new RouletteNumber(a, guess);



public ArrayList<RouletteNumber> makeRouletteWheel() {
	// TODO Auto-generated method stub
	return null;
}

public RouletteNumber spinWheel(){
	return null;
}

public List<RouletteNumber> getNumbers()
{
  return numbers;
}

}