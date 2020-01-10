package gameOf21;

public class Card 
{
	private int rank;
	private char suit;

//Constructors
	/**
	 * Creates a card 
	 * r = the Rank of the card 
	 * s = the Suit of the card
	 */
	public Card(int r, char s) {
		this.rank = r;
		this.suit = s;
	}

	/**
	 * Creates a card 
	 * given = takes the string and creates a card
	 */
	public Card(String given) {
		char temp = given.charAt(0);
		if (temp == 'A') 
		{
			this.rank = 1;
		} 
		else if (temp == 'T') 
		{
			this.rank = 10;
		} 
		else if (temp == 'J') 
		{
			this.rank = 11;
		} 
		else if (temp == 'Q') 
		{
			this.rank = 12;
		} 
		else if (temp == 'K') 
		{
			this.rank = 13;
		} 
		else 
		{
			this.rank = temp;
		}

		this.suit = given.charAt(1);
	}

	/**
	 * Get the rank
	 * 
	 * returns the rank of this card
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Get The suit
	 * 
	 * returns the suit of this card
	 */
	public char getSuit() {
		return this.suit;
	}

	public String getRankLetter() 
	{
		if (rank == 1) 
		{
			return "A";
		} 
		else if (rank == 10) 
		{
			return "T";
		} 
		else if (rank == 11) 
		{
			return "J";
		} 
		else if (rank == 12) 
		{
			return "Q";
		} 
		else if (rank == 13) 
		{
			return "K";
		} else {
			return Integer.toString(this.rank);
		}

	}

	public String toString() 
	{
		String value = (getRankLetter() + suit);
		return value;
	}

} // Card class
