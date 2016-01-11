package main;
import java.util.ArrayList;
import java.util.Random;
import main.Face;
import main.Suit;
import main.Card;

public class Deck {

	private ArrayList<Card> mDeck;
	private int currentCard;
	private Random rand;
	
	//constructor
	public Deck()
	{
		//create a card for each suit and face
		mDeck = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 13; j++) {
			
			mDeck.add(new Card(Face.allFaces[j], Suit.allSuits[i]));
		}
		}
		currentCard = 0;
		rand = new Random();
	}
	
	//deals a card and increments the counter to the next card
	public Card dealCard()
	{
		//return the top card and iterate to the next one
		 return mDeck.get(currentCard++);
	}
	
	//puts the cards in a random order
	public void Shuffle() 
	{
		Card tempCard;
		int rNum;		
		
		//for each card in the deck
		for (int i = mDeck.size() - 1; i > 0; i--)
		{
			//pick a random card between the beginning and the current card
			rNum = rand.nextInt(i + 1);
			//swap the random card and the current card
			tempCard = mDeck.get(rNum);
			mDeck.set(rNum, mDeck.get(i));
			mDeck.set(i, tempCard);
		}
		//reset current card
		currentCard = 0;
		return;
	}
	
}