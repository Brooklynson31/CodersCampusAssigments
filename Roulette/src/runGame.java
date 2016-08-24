import java.util.ArrayList;
import java.util.List;

public class runGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RouletteWheel game = new RouletteWheel();
		List<RouletteNumber> wheel = new ArrayList<RouletteNumber>();
		game.setUpRouletteGame(wheel);
		
	}

}
