package gameOf21;

import java.io.*;

public abstract class Player 
{
    /** Static counter used to make unique IDs for each player. */
    private static int nextId = 1;
    
    /** The player's ID. */
    private int id;
    
    /** The player's hand. */
    protected GameHand hand;
    
    /** The player's name. */
    protected String name;
    
    /** The number of chips the player has. */
    protected int numChips;
    
    /**
     *  Creates a Player object with a given name and starting number of chips.
     *  name = the player's name.
     *  numChips = the number of chips the player starts with.
     */
    public Player (String name, int numChips) {
        this.id = Player.nextId;
        Player.nextId++;
        this.hand = new GameHand();
        this.name = new String(name);
        this.numChips = numChips;
    }
    
    /**
     * Gets the player's ID.
     * Returns The player's ID.
     */
    public int getId () {
        return this.id;
    }
    
    /**
     * Gets the player's name.
     * Returns player's name.
     */
    public String getName () {
        return new String(this.name);
    }
    
    /**
     * Sets the player's name.
     * @param name  The player's new name.
     */
    public void setName (String name) {
        this.name = new String(name);
    }
    
    /**
     * Gets the number of chips the player has.
     * Returns The number of chips the player has.
     */
    public int getNumChips () {
        return this.numChips;
    }
    
    /**
     * Gets the total of the player's hand.
     * Returns The player's hand total.
     */
    public int getHandTotal () {
        return this.hand.getTotal();
    }
    
    /**
     * Gets a string representing the player's hand.
     * Returns String representing player's hand.
     */
    public String getHandString () {
        return this.hand.toString();
    }
    
    /**
     * Gets whether or not the player currently has a blackjack.
     * Returns  {@code true} if the player has a blackjack and {@code false}
     *          otherwise.
     */
    public boolean has21 () {
        return this.hand.isBlackjack();
    }
    
    /**
     * Puts a card into the player's hand.
     * Adds card to the player's hand.
     */
    public void pickUpCard (Card card) {
        this.hand.addCard(card);
    }
    
    /**
     * Collects some won chips and adds them the player's amount of chips.
     * The number of chips to add(winnings)
     * Returns the player's total number of chips.
     */
    public int collectChips (int winnings) {
        this.numChips += winnings;
        return this.numChips;
    }
    
    /**
     * Returns the amount that the player would like to bet on the next round.
     * This method must be implemented in derived classes.
     * returns the bet for the next hand.
     */
    public abstract int makeBet () throws IOException;
    
    /**
     * Returns whether or not the player wants to hit (receive another card) or
     * stand (not receive another card).  This method must be implemented in
     * derived classes.
     * Returns true the player wants to hit and false
     */
    public abstract boolean wantsToHit () throws IOException;
    
    /**
     * Removes all of the cards from the player's hand.
     */
    public void clearHand () {
        this.hand.clear();
    }
    
    /**
     * Get a string representing the player.  
     * Includes the player's name and their id
     * Returns Player's string representation.
     */
    public String toString () 
    {
        return this.name + " (Player " + this.id + ")";
    }
}
