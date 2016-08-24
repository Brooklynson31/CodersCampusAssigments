
public enum RouletteColors {
	Green (0),
	Red(1),
	Black(2);

	private int color;
	
	private RouletteColors(int color){
		this.color = color;
		
	}

	public int getColor() {
		return color;
	}
	
}
