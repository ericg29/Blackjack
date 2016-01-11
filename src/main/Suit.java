package main;

public enum Suit {
	SPADES		(1),
	CLUBS		(2),
	HEARTS		(3),
	DIAMONDS	(4)
;
	
	private int Value;

	private Suit(int value) {
		this.Value = value;
	}
	
	public int Value() {return Value;}
	
	public static Suit[] allSuits = {SPADES, CLUBS, HEARTS, DIAMONDS};
	
}
