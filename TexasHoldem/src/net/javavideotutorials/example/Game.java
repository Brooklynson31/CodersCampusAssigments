package net.javavideotutorials.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Game
{
  private Deck deck;
  private List<Player> players = new ArrayList<Player>();
  private List<Card> communityCards = new ArrayList<Card>();

 
  
  public Game ()
  {
    for (int i=1; i<=4; i++)
      players.add(new Player("player"+i));
    
    deck = new Deck();
    deck.shuffleDeck();
    
    deal();
    // Once you have a good chunk of your Unit Tests passing, you can
    // uncomment the line below and start running this code via the Runnable class
  System.out.println(determineWinner());
  }
  
  /**
   * This method is fully implemented and should work properly... if you need to make changes
   * then feel free
   * @return either the winning or tieing statement
   */
  String determineWinner()
  {
    int winningPlayerHandStrength = 0;
    List<Card> winningPlayerWinningCards = null;
    List<Card> winningPlayerWinningHand = null;
    Player winningPlayer = null;
    boolean draw = false;
    String kicker = "";
    
    for (Player player : players)
    {
      player.setPlayerHandStrength(checkForHand(player.getHand(), communityCards));
      player.setPlayableHand(player.getPlayerHandStrength().getPokerHand());
      List<Card> playerWinningCards = player.getPlayerHandStrength().getWinningCards();
      if (player.getPlayerHandStrength().getPokerHandEnum().getStrength() > winningPlayerHandStrength)
      {
        winningPlayer = player;
        winningPlayerHandStrength = player.getPlayerHandStrength().getPokerHandEnum().getStrength();
        winningPlayerWinningCards = playerWinningCards;
        winningPlayerWinningHand = player.getPlayableHand();
        draw = false;
        kicker = "";
      }
      else if (player.getPlayerHandStrength().getPokerHandEnum().getStrength() == winningPlayerHandStrength && winningPlayer != player)
      {
        Boolean newWinner = null;
        
        // compare two players' winning cards first
        Collections.sort(winningPlayerWinningCards);
        Collections.sort(playerWinningCards);
        for (int i=playerWinningCards.size()-1; i>0; i--)
        {
          if (playerWinningCards.get(i).getValue().getSuitValue() > winningPlayerWinningCards.get(i).getValue().getSuitValue())
          {
            newWinner = true;
            draw = false;
            kicker = "";
            if (player.getPlayerHandStrength().getPokerHandEnum().equals(PokerHandEnum.FLUSH))
            {
              kicker = ", " + playerWinningCards.get(i).getValue() + " kicker";
            }
          }
          else if (playerWinningCards.get(i).getValue().getSuitValue() == winningPlayerWinningCards.get(i).getValue().getSuitValue())
          {
          }
          else
          {
            newWinner = false;
            break;
          }
        }
        
        // if no winner is found then compare the entire hands against each other
        if (newWinner == null)
        {
          for (int i=4; i>=0; i--)
          {
            if (player.getPlayableHand().get(i).getValue().getSuitValue() > winningPlayerWinningHand.get(i).getValue().getSuitValue())
            {
              newWinner = true;
              draw = false;
              if (!player.getPlayerHandStrength().getPokerHand().equals(PokerHandEnum.HIGH_CARD))
                  kicker = ", " + player.getPlayableHand().get(i).getValue() + " kicker";
              break;
            }
            else if (player.getPlayableHand().get(i).getValue().getSuitValue() == winningPlayerWinningHand.get(i).getValue().getSuitValue())
            {
            }
            else
            {
              newWinner = false;
              break;
            }
          }
        }
        
        if (newWinner == null)
        {
          draw = true;
        }
        else if (newWinner)
        {
          draw = false;
          winningPlayer = player;
          winningPlayerHandStrength = player.getPlayerHandStrength().getPokerHandEnum().getStrength();
          winningPlayerWinningHand = player.getPlayableHand();
          winningPlayerWinningCards = playerWinningCards;
        }
      }
      System.out.print(player);
      System.out.print(" - " + player.getPlayerHandStrength());
      System.out.println();
    }
    
    System.out.println();
    for (Card card : communityCards)
    {
      System.out.println(card);
    }
    System.out.println();
    if (draw)
     return "There was a draw with hand: " + winningPlayer.getPlayerHandStrength();
    else
      return winningPlayer + " wins with " + winningPlayer.getPlayerHandStrength() + kicker;
  }

  /**
   * This method is the core of the game.  This is where we will determine what poker hands can be
   *  created from the cards in the player's hand and the community cards.  In my solution, I identified
   *  all the different Poker Hands that could be created from the 7 cards (2 in hand, 5 community cards on 'table')
   *  then returned only the strongest hand.
   *  
   * @param hand This is the list of cards that are held by an individual player (2 cards)
   * @param communityCards This is the list of cards that can be shared by all players (5 cards)
   * @return The strongest poker hand that a particular player holds
   *         This hand does not have to be made with the hards in the player's hand, it can be solely
   *         made up of just the community cards if need be... or it can be made up of either 1 or both
   *         cards in the player's hand.
   */
  ActualPokerHand checkForHand(List<Card> hand, List<Card> communityCards)
  {
    // initialize an empty list of actual poker hands that will be populated
    // as it gets passed into the individual PokerHand checking methods
	   // All poker hands have a high card, this method will determine which card
	    // is the high card.  Once it figures out which card is the high card, it will
	    // assign a new ActualPokerHand to the List of pokerHands.
	    //
	    // ex. pokerHands.add(new ActualPokerHand(PokerHandEnum.HIGH_CARD, winningCard));
	
	List<ActualPokerHand> pokerHands = new ArrayList<ActualPokerHand>();


	     
	 checkForHighcard(hand, communityCards, pokerHands);
   		checkForPair(hand, communityCards, pokerHands);
	 	checkForThreeOfAKind(hand, communityCards, pokerHands);	 	
	 	checkForFourOfAKind(hand, communityCards, pokerHands);
	 	checkForFlush(hand, communityCards, pokerHands);
	 	checkForTwoPair(hand, communityCards, pokerHands);
	 	checkForFullHouse(hand, communityCards, pokerHands);
	 	checkForStraight(hand, communityCards, pokerHands);
	 	checkForStraightFlush(hand, communityCards, pokerHands);
//	 	
	 
	 		  Collections.sort(pokerHands);
	 		
	 		   return pokerHands.get(pokerHands.size()-1);

}

  /**
   * In my solution, I used this method to determine if we had a straight flush AND if we had a royal flush... so I didnt
   * create a separate method to check for a royal flush.
   * 
   * @param hand the 2 cards in a given player's hand
   * @param communityCards the 5 community cards
   * @param pokerHands a list of all the actual PokerHands that can be made from the 7 available cards
   */
  
  private void checkForStraightFlush(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
	  
	  ActualPokerHand straightflush = new ActualPokerHand(null,null);
			List<Card> winningCards = new ArrayList<Card>();
			Integer dupCount = 5;
			boolean isstraightflush= false;
			List<Card> possibleStraightFlush = new ArrayList<Card>();			
			
			Map<Suit, List<Card>> checkFlush = checkforDupSuit(Table);
			if( addRepeatSuitCards(winningCards, dupCount, checkFlush)){
			  
				
			  	if(winningCards.size() == 7 && winningCards.get(1).compareTo(winningCards.get(2)) != -1 ){
					 winningCards.remove(0);
					 winningCards.remove(0);
				 }
			
				for(int index=0;index<winningCards.size();index++){
					Card indexCard = winningCards.get(index);
					if( index+1 < winningCards.size()){ //cards 0-6
							Card nextCard = winningCards.get(index+1);
							if (indexCard.compareTo(nextCard) == -1){ //compare next 
								possibleStraightFlush.add(indexCard);	
								}
							else if (index > 0) {
								Card prevCard = winningCards.get(index-1);
								if (indexCard.compareTo(prevCard) == 1){ // compare to previous if index != 0
									possibleStraightFlush.add(indexCard);
								if (indexCard.compareTo(nextCard) == 0 || indexCard.compareTo(prevCard) ==0)
									continue;
								if (indexCard.compareTo(nextCard) < -1 || indexCard.compareTo(prevCard) > 1)
									continue;
								else if(indexCard.compareTo(nextCard) != 0){
									continue;}
								}
						} //index 1-5
					}
					else if(index == winningCards.size()-1 && possibleStraightFlush.size() == 4){ //lastcard
						if (indexCard.compareTo(possibleStraightFlush .get(3)) == 1)
							possibleStraightFlush.add(indexCard);
					}
				
		
			}
				if (possibleStraightFlush.size() == 6 ){
					possibleStraightFlush.remove(0);
					}
			if (possibleStraightFlush.size() == 5 && possibleStraightFlush.get(0).compareTo(possibleStraightFlush.get(4)) == -4)
				isstraightflush = true;

			}
			else
			{
				isstraightflush = false;
			}
			if(isstraightflush){
				if(possibleStraightFlush.get(4).getValue().getSuitValue() == 14) {
						makePokerHand(pokerHands, straightflush, possibleStraightFlush, isstraightflush, PokerHandEnum.ROYAL_FLUSH);
						}
				else {
						makePokerHand(pokerHands, straightflush, possibleStraightFlush, isstraightflush, PokerHandEnum.STRAIGHT_FLUSH);
					}
			}	
	
		
			
  }
  private void checkForStraight(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  	List<Card> Table =availableCards(communityCards,hand); 
	  	ActualPokerHand Straight = new ActualPokerHand(null,null);
		List<Card> winningCards = new ArrayList<Card>();
		boolean isStraight = false;
		
	
	
		isStraight(winningCards,Table);
			if(winningCards.size() == 5){
				isStraight =true;
				}

			makePokerHand(pokerHands, Straight, winningCards, isStraight, PokerHandEnum.STRAIGHT);
		
  }



  private void checkForFullHouse(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
	  ActualPokerHand fullBoat = new ActualPokerHand(null,null);
		List<Card> winningCards = new ArrayList<Card>();
		Map<Value,List<Card>> checkfullBoat = checkforDup(Table);
		Integer dupCount1 = 3;
		Integer dupCount2 = 2;
		boolean isFullHouse = false;
		isFullHouse = addRepeatsToPokerHand(winningCards, dupCount1, checkfullBoat);
		isFullHouse = addRepeatsToPokerHand(winningCards, dupCount2, checkfullBoat);

			
		Collections.sort(winningCards);
		if(winningCards.size() == 6){
			winningCards.remove(0);
			isFullHouse = true;
		}
		if(winningCards.size() != 5){
			isFullHouse=false;
		}
	

		makePokerHand(pokerHands, fullBoat, winningCards, isFullHouse, PokerHandEnum.FULL_HOUSE);
  }

  private void checkForTwoPair(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
	  ActualPokerHand twoPair = new ActualPokerHand(null,null);
		List<Card> winningCards = new ArrayList<Card>();
		Integer dupCount = 2;
		Map<Value,List<Card>> checktwoPair = checkforDup(Table);
		boolean isTwoPair = false;
	
	
		
		addRepeatsToPokerHand(winningCards, dupCount, checktwoPair);
		if(winningCards.size() ==4){
			isTwoPair = true;
		}
		

		addRemainingCards(winningCards,Table);
	
		makePokerHand(pokerHands, twoPair, winningCards, isTwoPair, PokerHandEnum.TWO_PAIR);
		
  }
  
  private void checkForHighcard(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  { 
	  List<Card> Table = availableCards(communityCards,hand); 
	  ActualPokerHand highCard = new ActualPokerHand(null, null);
	
	 List<Card> winningCards = new ArrayList<Card>();	
	 Collections.sort(Table);
	 Table = Table.subList(2, 7);
	 winningCards.addAll(Table);
	
	
	 highCard.setPokerHand(winningCards);
	 highCard.setPokerHandEnum(PokerHandEnum.HIGH_CARD);
	 pokerHands.add(highCard);

  }


		  
  private void checkForFlush(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
	  ActualPokerHand flush = new ActualPokerHand(null,null);
	  
		List<Card> winningCards = new ArrayList<Card>();
		Integer dupCount = 5;
		boolean isFlush = false; 
		Map<Suit, List<Card>> checkFlush = checkforDupSuit(Table);
		
		isFlush = addRepeatSuitCards(winningCards, dupCount, checkFlush);
		
		
		

		makePokerHand(pokerHands, flush, winningCards, isFlush, PokerHandEnum.FLUSH);

		
  }





  private void checkForPair(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
	ActualPokerHand Pair = new ActualPokerHand(null,null);
	List<Card> winningCards = new ArrayList<Card>();
	Integer dupCount = 2;
	boolean isPair = false;
	Map<Value, List<Card>> checkforPair = checkforDup(Table);
	
	isPair = addRepeatsToPokerHand(winningCards, dupCount, checkforPair);
		
	if(winningCards.equals(hand))
			{
			Pair.setWinningCards(hand);
			Pair.setPokerHandEnum(PokerHandEnum.PAIR);
			pokerHands.add(Pair);
			}
		


	addRemainingCards(winningCards,Table);
	makePokerHand(pokerHands, Pair, winningCards, isPair, PokerHandEnum.PAIR);

  }





  private void checkForThreeOfAKind(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
		ActualPokerHand threeKind = new ActualPokerHand(null,null);
		List<Card> winningCards = new ArrayList<Card>();
		Integer dupCount = 3;
		boolean isThreeKind = false;
		
		Map<Value, List<Card>> checkforthreeKind = checkforDup(Table);
		isThreeKind =addRepeatsToPokerHand(winningCards, dupCount, checkforthreeKind);
		addRemainingCards(winningCards,Table);
		
		makePokerHand(pokerHands, threeKind, winningCards, isThreeKind, PokerHandEnum.THREE_OF_A_KIND);
  }


  private void checkForFourOfAKind(List<Card> hand, List<Card> communityCards, List<ActualPokerHand> pokerHands)
  {
	  List<Card> Table =availableCards(communityCards,hand); 
		ActualPokerHand fourKind = new ActualPokerHand(null,null);
		List<Card> winningCards = new ArrayList<Card>();
		Integer dupCount = 4;
		boolean isFourKind = false;
		
		Map<Value, List<Card>> checkforfourKind = checkforDup(Table);
		isFourKind = addRepeatsToPokerHand(winningCards, dupCount, checkforfourKind);
		addRemainingCards(winningCards,Table);
		
		makePokerHand(pokerHands, fourKind, winningCards, isFourKind, PokerHandEnum.FOUR_OF_A_KIND);
  }

private void makePokerHand(List<ActualPokerHand> pokerHands, ActualPokerHand actualpokerhand, List<Card> winningCards,
		boolean isPokerHand, PokerHandEnum handtype) {
	
	if(isPokerHand){
		Collections.sort(winningCards);
		actualpokerhand.setPokerHand(winningCards);
		actualpokerhand.setWinningCards(winningCards);
		actualpokerhand.setPokerHandEnum(handtype);
		pokerHands.add(actualpokerhand);
	}
	else{
		winningCards.clear();
	}
}
private List<Card> availableCards(List<Card> communityCards, List<Card> hand) {
	List<Card> allCards = new ArrayList<Card>();
	allCards.addAll(hand);
	allCards.addAll(communityCards);
	Collections.sort(allCards);
	return allCards;
}
  private static List<Card> createTableCopy(List<Card> Table) {
	
		List<Card> Tablecopy =Table;
		return Tablecopy;
	}
  private void addRemainingCards(List<Card> winningCards,List<Card> Table) {
	  	List<Card> Tablecopy = createTableCopy(Table);

		for(int i=Tablecopy.size()-1;i>=0;i--){
			Card nextCard= Tablecopy.get(i);
				if(!winningCards.contains(nextCard)){
					winningCards.add(nextCard);
					if(winningCards.size() ==5){
					
						break;
					}
				}
		}
		//return isPokerHand;
	}
  private void isStraight(List<Card> winningCards, List<Card> Table) {
	  	List<Card> Tablecopy1 = createTableCopy(Table);
	  	Collections.sort(Tablecopy1);
	  	Set<Card> Stra = new TreeSet<Card>();
	  	Stra.addAll(Tablecopy1);
	  	List<Card> Tablecopy = new ArrayList<Card>();
	  	Tablecopy.addAll(Stra);
		 if(Tablecopy.size() == 7 && Tablecopy.get(1).compareTo(Tablecopy.get(2)) != -1 ){
			Tablecopy.remove(0);
			 Tablecopy.remove(0);
		 }
	
		
		 
		 
		for(int index=0;index<Tablecopy.size();index++){
			Card indexCard = Tablecopy.get(index);
			if( index+1 < Tablecopy.size()){ //cards 0-6
					Card nextCard = Tablecopy.get(index+1);
					if (indexCard.compareTo(nextCard) == -1){ //compare next 
						
						winningCards.add(indexCard);
						}
					else if (index > 0) {
						Card prevCard = Tablecopy.get(index-1);
						if (indexCard.compareTo(prevCard) == 1 && indexCard.compareTo(nextCard) < -1){ // compare to previous if index != 0
						
							winningCards.add(indexCard);
						
							if(winningCards.size() == 5)
								break;}
					
						if (indexCard.compareTo(prevCard) > 1)	
						continue;
						}
				} //index 1-5
		
			else if(index == Tablecopy.size()-1 && winningCards.size() == 4){
				
				 if (indexCard.compareTo(winningCards.get(3)) == 1){
					winningCards.add(indexCard);}
			}
			}
	
		if(winningCards.size() == 5 && winningCards.get(0).compareTo(winningCards.get(4)) != -4)
			winningCards.clear();
	}
  private boolean addRepeatsToPokerHand(List<Card> winningCards, Integer dupCount, Map<Value, List<Card>> repeatCards) {
		boolean hasdups = false;
	  for(List<Card> a: repeatCards.values() ){
			if (a.size() ==dupCount ){
				winningCards.addAll(a);
				hasdups = true;
				if (winningCards.size() >= 4)
					break;
			}
			
		}
		return hasdups;
	}
	  
  private boolean addRepeatSuitCards(List<Card> winningCards, Integer dupCount, Map<Suit, List<Card>> checkSuit) {
		boolean hasdupssuit = false;
	  for(List<Card> f: checkSuit.values()){
			if(f.size() >= dupCount){
				winningCards.addAll(f);
				hasdupssuit = true;
			}
		}
	 return  hasdupssuit;
	}
  static Map<Value, List<Card>> checkforDup(List<Card> Table) {
		Map<Value,List<Card>> checkforDup = new TreeMap<Value,List<Card>>(Collections.reverseOrder());
	  	List<Card> Tablecopy = createTableCopy(Table);

		
		for(int i=0; i<Tablecopy.size();i++){
			Card tableCard = Tablecopy.get(i);
			Value cardval = tableCard.getValue();
			if(!checkforDup.containsKey(cardval)){
				List<Card> card = new ArrayList<Card>();
				card.add(tableCard);
				checkforDup.put(cardval, card);
				
			}
			else {
			List<Card> Tc = checkforDup.get(cardval);//store list cards currently in map
			Tc.add(tableCard); //add duplicate card to stored list of card values
			checkforDup.put(cardval, Tc); //overwrite previous list of values with new list including duplicate
			}
		}
		return checkforDup;
	}
  static Map<Suit, List<Card>> checkforDupSuit(List<Card> Table) {
		Map<Suit,List<Card>> checkforDupSuit = new TreeMap<Suit,List<Card>>();
	  	List<Card> Tablecopy = createTableCopy(Table);

		
		for(int i=0; i<Tablecopy.size();i++){
			Card tableCard = Tablecopy.get(i);
			Suit cardsuit = tableCard.getSuit();
			if(!checkforDupSuit.containsKey(cardsuit)){
				List<Card> card = new ArrayList<Card>();
				card.add(tableCard);
				checkforDupSuit.put(cardsuit, card);
				
			}
			else {
			List<Card> Tc = checkforDupSuit.get(cardsuit);//store list cards currently in map
			Tc.add(tableCard); //add duplicate card to stored list of card values
			checkforDupSuit.put(cardsuit, Tc); //overwrite previous list of values with new list including duplicate
			}
		}
	
		return checkforDupSuit;
	} 
  
  void deal ()
  {
    for (Player player : players)
    {
      List<Card> playerHand = new ArrayList<Card>();
      playerHand.add(deck.getCards().remove(0));
      playerHand.add(deck.getCards().remove(0));
      
      player.setHand(playerHand);
    }
    
    for (int i=0; i<5; i++)
    {
      communityCards.add(deck.getCards().remove(0));
    }
  }

  public void setDeck(Deck deck)
  {
    this.deck = deck;
  }

  public void setPlayers(List<Player> players)
  {
    this.players = players;
  }

  public void setCommunityCards(List<Card> communityCards)
  {
    this.communityCards = communityCards;
  }
  
}
