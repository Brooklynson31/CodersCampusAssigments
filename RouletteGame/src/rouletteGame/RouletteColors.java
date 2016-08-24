package rouletteGame;

public enum RouletteColors {
	Green (0),
	Black(1),
	Red(2);

	private int color;
	
	private RouletteColors(int color){
		this.color = color;
		
	}

	public int getColor() {
		return color;
	}
}