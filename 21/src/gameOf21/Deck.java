package gameOf21;

public class Deck
{
private Card [] cards = new Card [52];
private int position = -1;
private char temp;
//Constructors
/*
*   Creates a deck of cards
*/
public Deck ()
{
   for (int x = 0; x < 52; x++)
   {
       if (x == 0){ //Clubs
       temp = 'C';
       }
       else if (x == 13){ //Diamonds
       temp = 'D';
       }
       else if (x == 26){ // Heats
       temp = 'H';
       }
       else if (x == 39){ // Spades
       temp = 'S';
       }
       cards [x] = new Card ((x % 13)+1, temp); // creating arrray of cards
   }
}

/**
* Deals a card to the user
* Returns the current position in the deck
*/
public Card dealCard ()
{
   position ++;
   return (cards [position]);
}
/**
* Checks if the deck is empty
* Returns true if it is empty
* Returns false if it is not empty
*/
public boolean isEmpty ()
{
   if (position == 52)
   {
       return true;
   }
   else
   {
       return false;
   }
}

/**
* Shuffles the deck
* Change position, call array
*/
public void shuffle ()
{
   position = -1;
   shuffleCardArray (cards);
}

/**
* Randomly shuffles the elements of an array.
* An array of objects to be shuffled.
*/
public static void shuffleCardArray (Object [] array) 
{
   for (int i = array.length - 1; i > 0; i--)
   {
       int order = (int) (Math.random() * (i + 1));
       Object temp = array[i];
       array[i] = array[order];
       array[order] = temp;
   }
} // end shuffle
}///end class
