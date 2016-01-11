package main;
import java.util.ArrayList;
import main.Face;
import main.Card;

public class Hand {
	
	private ArrayList<Card> cards;
	private int numCards;
	private int totalVal;
	public int ace;
	
	//constructor
	public Hand() {
		cards = new ArrayList<Card>();
		numCards = 0;
		totalVal = 0;
		ace = -1;
	}
	
	//adds a card to the hand and updates value and number of cards
	public void addCard(Card card)
	{
		if (card != null) {
			//if it's the first ace, save its index in the cards array
			if ((card.getFace() == Face.ACE) && (ace == -1)) { ace = numCards; }
			
			cards.add(card);						//add card to array
			numCards++;								//increment num of cards
			totalVal += card.getValue();			//add value to total
			return;
		}
	}
	
	//returns the number of cards in the hand
	public int getNumCards() { return numCards; }
	
	//returns the total value of the hand
	public int getValue() 
	{ 
		//if the total (including the 1 from the ace) is <= 11, count the ace as 11
		if ((ace != -1) && (totalVal <= 11)) { return totalVal + 10; }
		//otherwise leave the ace as a 1
		else { return totalVal; } 	
	}
	
	//returns true if the player has two cards and total value of 21
	public boolean hasBlackjack() { return ((numCards == 2) && (totalVal == 21)); }
	
	//outputs all cards in the hand, and hides the first card if it's the dealer
	public void outputHand(boolean isDealer, boolean isDone)
	{
		//if it's the dealer, hide the first card
		if (isDealer) { 
			System.out.print("Dealer:\n\t");
			if (isDone) { System.out.println(cards.get(0).toString()); }
			else { System.out.println("Hidden Card"); }
		}
		//otherwise print it
		else {System.out.println("Player:\n\t" + cards.get(0).toString());}
		
		for (int i = 1; i < numCards; i++)
		{
			//print the rest of the cards in the hand
			System.out.println("\t" + cards.get(i).toString());
		}
		return;
	}
	
	//returns a string listing all the cards in the hand
	@Override
	public String toString()
	{
		//add first card to string
		String handStr = cards.get(0).toString();
		for (int i = 1; i < numCards; i++)
		{
			//add comma and next card
			handStr += ", " + cards.get(i).toString();
		}
		return handStr;
	}
	
	//returns true if the two hands have equal value
	public boolean equals(Hand hand)
	{
		return (totalVal == hand.getValue());
	}
	
}
