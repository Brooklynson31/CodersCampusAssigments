

public class RouletteNumber {
	
	private Integer rouletteNumber;
	private RouletteColors color;
	
	public RouletteNumber( Integer rouletteNumber, RouletteColors color){
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

	@Override
	public String toString() {
		return "RouletteNumber: " + rouletteNumber + ", color=" + color;
	}
	


}
