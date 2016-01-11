package driver;

import java.util.Scanner;
import main.Deck;
import main.Card;
import main.Face;
import main.Suit;
import main.Hand;
import main.Player;

public class driver {

	public static void main(String[] args) {
	
		//create scanner for input
		Scanner input = new Scanner(System.in);
		boolean gameOver = false;
		
		//create players
		Player player = new Player(false);
		Player dealer = new Player(true);
		
		//create deck
		Deck deck = new Deck();
		
		//begin game logic loop
		while (!gameOver) {

			startGame(player, dealer, deck);
			queryHit(player, deck, input);
			queryHit(dealer, deck, input);
			declareWinner(player, dealer);
			
			//check if the player wants to continue playing
			if (queryContinue(input))
			{
				System.out.println("--------------------------------------------");
				player.resetPlayer();
				dealer.resetPlayer();
			}
			else { gameOver = true; }
		}
		System.out.println("\nThanks for playing!\n");
		return;
	}
	
	
	//-----DRIVER FUNCTIONS-----
	
	
	
	//sets up players and deck
	public static void startGame(Player player, Player dealer, Deck deck) 
	{
		//shuffle deck
		deck.Shuffle();
		
		//deal first two cards to both players
		player.addCard(deck.dealCard());
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		
		
		/* FOR DEBUGGING/TESTING. Since it's so uncommon for both to get blackjack
		 * 
		 * player.addCard(new Card(Face.ACE, Suit.CLUBS));
		player.addCard(new Card(Face.JACK, Suit.CLUBS));
		dealer.addCard(new Card(Face.ACE, Suit.SPADES));
		dealer.addCard(new Card(Face.JACK, Suit.SPADES));*/
		
		//display both hands
		player.outputHand();
		dealer.outputHand();
	}
	
	
	//player hit loop
	public static void queryHit(Player player, Deck deck, Scanner input)
	{
		if (player.isDealer()) {
			//dealer must hit until their hand value is >= 17
			while (player.getValue() < 17) {
				player.addCard(deck.dealCard());
			}
		}
		else {
			boolean hit = true;
			System.out.print("Hit? (Y or N): ");
			while (hit && !player.isBust()) {
				//create input string, get input, and trim input
				String in;
				in = input.nextLine();
				in.replaceAll("\\s", "");
				
				//if player answered no, exit loop
				if ((in.equals("N")) || (in.equals("n"))) { 
					hit = false;
				}
				//if yes, deal a card
				else if ((in.equals("Y")) || (in.equals("y"))) {
					player.addCard(deck.dealCard()); 
					player.outputHand();
					if (player.isBust()) { System.out.println("\nYou've bust! Hand total: " + player.getValue()); }
					else { System.out.print("Hit? (Y or N): "); }
				}
				//otherwise ask for input again
				else { System.out.print("Invalid response, please try again (Y or N): "); }		
			}
		}
		player.setDone();
	}
	
	//decides the winner;
	//	returns 1 if player wins
	//	returns 0 if tied
	//	returns -1 if dealer wins
	public static void declareWinner(Player player, Player dealer) 
	{
		System.out.println("--------------------------------------------");
		player.outputHand();
		System.out.println("\tTotal Value: " + player.getValue());
		dealer.outputHand();
		System.out.println("\tTotal Value: " + dealer.getValue());
		
		int winner;
		
		//get scores
		int pValue = player.getValue();
		int dValue = dealer.getValue();
		
		//if bust, set score to 0
		if (player.isBust()) { pValue = 0; }
		if (dealer.isBust()) { dValue = 0; }
		
		//check for blackjack
		boolean pBlackjack = player.hasBlackjack();
		boolean dBlackjack = dealer.hasBlackjack();
		
		//if both have blackjack, tie
		if (pBlackjack && dBlackjack) {
			winner = 0;
		}
		//if player has blackjack or higher score, they win
		else if (pBlackjack || (pValue > dValue)) {
			winner = 1;
		}
		//if dealer has blackjack or higher score, they win
		else if (dBlackjack || (pValue < dValue)) {
			winner = -1;
		}
		//if both bust, dealer wins
		else if ((pValue == 0) && (dValue == 0)) { winner = -1; }
		//otherwise tie
		else { winner = 0; }
		
		if (winner == -1) { System.out.println("Dealer wins!\n"); }
		else if (winner == 1) { System.out.println("Player wins!\n"); }
		else { System.out.println("It's a tie!\n"); }
		
	}

	//asks if user wants to continue playing
	public static boolean queryContinue(Scanner input)
	{
		//ask to play again or quit
		System.out.print("Continue playing? (Y or N): ");
		while (true) {
			String in;
			in = input.nextLine();
			in.replaceAll("\\s", "");
			
			if ((in.equals("N")) || (in.equals("n"))) {
				return false;
			}
			else if ((in.equals("Y")) || (in.equals("y"))) {
				return true;
			}
			else { System.out.print("Invalid response, please try again (Y or N): "); }
			
		}
	}
	
}
