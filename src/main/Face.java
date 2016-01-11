package main;
public enum Face {
	ACE		(1), 
	TWO		(2),
	THREE	(3),
	FOUR	(4),
	FIVE	(5),
	SIX		(6),
	SEVEN	(7),
	EIGHT	(8),
	NINE	(9),
	TEN		(10),
	JACK	(10),
	QUEEN	(10),
	KING 	(10)
;

	private int Value;

	private Face(int value) {
		this.Value = value;
	}
	
	public int Value() {return Value;}
	
	public static Face[] allFaces = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}; 

}
