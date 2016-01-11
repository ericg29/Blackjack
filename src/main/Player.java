package main;

import main.Hand;
import main.Card;

public class Player {
	
	private boolean dealer;
	private Hand hand;
	private boolean done;
	
	//constructor
	public Player(boolean isDealer)
	{
		dealer = isDealer;
		done = false;
		hand = new Hand();
	}
	
	//return true if player is the dealer 
	public boolean isDealer() {return dealer;}
	
	//add a card to the player's hand
	public void addCard(Card card) {hand.addCard(card);}
	
	//print the player's hand
	public void outputHand() {hand.outputHand(dealer, done);}
	
	//returns true if the player has blackjack
	public boolean hasBlackjack() {return hand.hasBlackjack();}
	
	//returns true if player is busted
	public boolean isBust() {return (hand.getValue() > 21);}
	
	//checks if the player is done hitting
	public boolean isDone() { return done; }
	
	//sets done to true
	public void setDone() { done = true; }
	
	//returns the total value of the player's hand
	public int getValue() {return hand.getValue();}
	
	public void resetPlayer() 
	{
		hand = new Hand();
		done = false;
	}
	
}
