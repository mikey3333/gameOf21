package gameOf21;
/**
 * A class representing a dealer.
 * Comes from the player class
 */
public class Dealer extends Player
{
   
    /** Boolean to decide if dealers second card has been revealed */
    private boolean cardRevealed; ///true if dealer has revealed second card, false if not
        
    /**
     * Creates a Player object by passing it to the player object
     */
    public Dealer ()
    {
        super ("Dealer", 0);
      //Creates a blackjack dealer.  Don't forget to call the base class' constructor!  Make his/her name "Dealer".
    }
    
    
     /**
     * Dealer does not bet 
     * Returns 0
     */
    public int makeBet ()
    {
        return 0; //dealer never bets, return 0
    }
    
    /**
     * Checks if dealer wants to hit
     * Returns true if the dealer is below or is 16
     * Returns false if dealer wants to stand and is above 16
     */
    public boolean wantsToHit ()
    {
        if (hand.getTotal () <= 16)
        {
            return true;
        }
        else
        {
            return false;
        }
        //Return true if the dealer needs to "hit" or false if the dealer needs to "stand".  
        //See the rule in the description above.
    }
    
     /**
     * Clears the dealers hand
     */
    public void clearHand ()
    {
        hand.clear ();
        cardRevealed = false;
    }
    
    /**
     * Reveals the dealers last card
     */
    public void revealCard ()
    {
        this.cardRevealed = true;
    }
    
     /**
     * Creates a string for player wih name and ID 
     * Returns padded string of id n stuff
     */
    public String getHandString ()
    {
        if (cardRevealed == false)
        {
            String format = ("[" + hand.getCards (0) + " ??]");
            return format;
          //However, if cardRevealed is false, then the second card in the hand must be hidden 
          //and the value should not be included.  For example:[6H ??]
        }
        
        else
        {
           return this.hand.toString ();
        }
    }
    
    
}
