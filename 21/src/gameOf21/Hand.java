package gameOf21;
/**
 * A generic hand of playing cards.
 * <p>The cards will be stored in an array.  We will make the array size 52 
 * since there can be a maximum of 52 cards in a hand.  Keep track of the size 
 * using the size attribute.</p>
 */
public class Hand 
{
    //////////////Attributes
    protected Card [] cards;
    protected int size;
    //private Card [] cards;
    //private int size;
    ////////////// Constructors
    public Hand ()
    {
        this.cards = new Card [52];
        this.size = 0;
    }
    ////////////// Accessors
    public Card getCards (int index)
    {
        return cards [index]; 
    }
    //////////////Behavioural
    /**
     * Adds a card to the hand
     * @param card Takes in an card data
     */
    public void addCard (Card card)
    {
        this.cards [size] = card;
        this.size ++;
    }
    
    /**
     * Removes a card from the hand given index in array
     * @param index 
     * @return null if there is no card at that index
     * @return Card at given index
     */
    public Card removeCard (int index)
    {
        if (index >= 52)
        {
            return null;
        }
        else
        {
            Card temp = cards [index];
            cards [index] = null;
            shuffleDown (cards);
            size --;
            return (temp);
        }
    }
    
    /**
     * Removes a card from the hand given the rank and suit
     * @param index 
     * @return null if there is no card of that rank and suit
     * @return Card if there is a card of that rank and suit
     */
    public Card removeCard (int rank, char suit)
    {
        for (int x = 0; x < 52; x++)
        {
            if (suit == cards[x].getSuit () ||rank == cards [x].getRank ())
            {
                Card temp = cards [x];
                cards [x] = null;
                shuffleDown (cards);
                size --;
                return (temp);
            }
        }
        shuffleDown (cards);
        return null;
    }
    
    /**
     * Removes all cards from hand
     */
    public void clear ()
    {
        for (int x = 0; x < 52; x++)
        {
            cards [x] = null;
        }
        size = 0;
    }
    
    //////////////Helper method  
    /// Create a method to remove blank spots using if == null
    /**
     * Shuffles the cards
     * @param array takes in an array and shuffles the order of it 
     */
    public static void shuffleDown (Object [] array)
    {
        for (int x = 0; x < 52; x++)
        {
            if (array [x] == null && array [x+1] != null)
            {
                array [x] = array [x+1];
                array [x+1] = null;
            }
        }
    }
    
    //public int forwardRank (int x)
    //{
    //    int bob = this.cards [x].getRank ();
    //    return bob;
    //}
    //////////////toString
   /**
    * Get The tostring
    * @return The information as a string
    */
    public String toString ()
    {
        String format = ("[" + cards [0]);
        
        for (int x = 1; x < size; x++)
        {
            
            format = (format + " " + cards [x]);
        }
        format = (format + "]");
        
        return format;
    }
    
}
