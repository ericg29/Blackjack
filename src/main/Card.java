package main;

import main.Suit;
import main.Face;

public class Card {
	
	private Face face;
	private Suit suit;
	
	public Card(Face newFace, Suit newSuit) {
		face = newFace;
		suit = newSuit;
	}
	
	public Suit getSuit() { return suit; }
	
	public Face getFace() { return face; }
	
	public int getValue() { return face.Value(); }
	
	public boolean equals(Card card) {
		return (face.Value() == card.getFace().Value());
	}
	
	@Override
	public String toString() {
		String cardStr = face + " of " + suit;
		return cardStr;
	}
	
}