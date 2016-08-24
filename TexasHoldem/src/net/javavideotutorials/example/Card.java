package net.javavideotutorials.example;

public class Card implements Comparable<Card>
{
  private Suit suit;
  private Value value;
  
  public Card (Suit suit, Value value)
  {
    this.suit = suit;
    this.value = value;
  }
  
  public Suit getSuit()
  {
    return suit;
  }
  public Value getValue()
  {
    return value;
  }

  @Override
  public int compareTo(Card o)
  {
    // You will need to implement the proper code here
    // so that the cards can be properly sorted
	 Integer t = this.getValue().getSuitValue();
	 Integer b = o.getValue().getSuitValue();
	 if( (this.value.getSuitValue() > o.value.getSuitValue()))
		  return t-b;
	   if(this.value.getSuitValue() < o.value.getSuitValue())
		  return t-b;
	   else 
		   return 0;

  }
  @Override
  public String toString(){
	  return value + " of " + suit; 
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((suit == null) ? 0 : suit.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null) {
		return false;
	}
	if (!(obj instanceof Card)) {
		return false;
	}
	Card other = (Card) obj;
	if (suit != other.suit) {
		return false;
	}
	if (value != other.value) {
		return false;
	}
	return true;
}
  
}
