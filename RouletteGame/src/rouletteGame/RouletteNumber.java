package rouletteGame;

public class RouletteNumber {
	
	private int rouletteNumber;
	private RouletteColors color;
	
	public RouletteNumber( int rouletteNumber, RouletteColors color){
		this.color = color;
		this.rouletteNumber = rouletteNumber;
	}
	
	public RouletteNumber() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRouletteNumber() {
		return rouletteNumber;
	}

	public void setRouletteNumber(int rouletteNumber) {
		this.rouletteNumber = rouletteNumber;
	}
	public RouletteColors getColor() {
		return color;
	}

	public void setColor(RouletteColors color) {
		this.color = color;
	}

}

