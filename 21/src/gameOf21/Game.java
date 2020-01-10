package gameOf21;
import java.io.*;
public class Game {
	 	private Deck deck;
	    private int numPlayers;
	    private Player [] players;
	    private int [] bets;
	    private Dealer dealer;
	    private BufferedReader input;
	    
	    /** 
	     * Initializes all of the objects needed to play a game of 21.  
	     * This includes getting the number of players, their names and amount of apples from
	     * the player.
	     */
	    public Game () throws IOException
	    {
	        // Set up the buffered reader
	        this.input = new BufferedReader(new InputStreamReader(System.in));
	        
	        // Get the number of players from the user
	        do {
	            System.out.print("How many players (not counting dealer)? [Enter 1 for single player or 2 for two player] ");
	            this.numPlayers = Integer.parseInt(input.readLine());
	        } while (this.numPlayers < 1 || this.numPlayers > 5);
	        System.out.println();
	        
	        ///Sizing bet Array
	        bets = new int [numPlayers];
	        
	        // Create all of the players using player input for name and amount of chips
	        this.players = new Player [this.numPlayers + 1]; // Include the dealer
	        for (int i = 0; i < this.numPlayers; i++) 
	        {
	            System.out.print("What is player " + (i + 1) + "'s name? ");
	            String playerName = this.input.readLine();
	            System.out.print("How many chips does player " + (i + 1) + " have? ");
	            int playerChips = Integer.parseInt(this.input.readLine());
	            this.players[i] = new RealPlayer(playerName, playerChips);
	            System.out.println();
	        }
	        
	        // Create a dealer
	        this.dealer = new Dealer();
	        this.players[this.numPlayers] = this.dealer; // The last player in players is the dealer
	        
	        // Create the deck
	        this.deck = new Deck();
	    }
	    
	    /**
	     * Runs a single round of 21.
	     */
	    private void playRound () throws IOException
	    {
	        // Get bets
	        for (int i = 0; i < this.numPlayers; i++) 
	        {
	            System.out.println ("Player " + (i+1));
	            bets [i] = this.players [i].makeBet();
	        }
	        
	        // Shuffle and deal
	        this.deck.shuffle();
	        System.out.println("DEALING ...\n");
	        for (int k = 0; k < 2; k++) {
	            for (int i = 0; i <= this.numPlayers; i++) {
	                this.players[i].pickUpCard(this.deck.dealCard());
	            }
	        }
	        
	        // Print out the hands as they are
	        for (int i = 0; i < this.numPlayers; i++) 
	        {
	           System.out.println ( this.players [i].toString ()+ " " + this.players [i].getHandString());
	        }
	        
	        System.out.println (" ");
	        /// If the dealer has a 21, then finish game now.
	        if (this.dealer.has21()) {
	            System.out.println("Dealer WINS!!!");
	        }
	        else
	        {
	            // Run each player's turn
	            for (int i = 0; i <= this.numPlayers; i++) 
	            {

	                boolean bob = false;
	                do
	                {
	                  if (i != this.numPlayers)
	                  {
	                      System.out.println (this.dealer.toString () + " " + this.dealer.getHandString ());
	                      System.out.println ( this.players [i].toString ()+ " " + this.players [i].getHandString());
	                  }
	                      // If its the dealer, reveal his/her card
	                  if (i == this.numPlayers) //if they are dealer
	                  { 
	                      this.dealer.revealCard();
	                      bob = true;
	                  }
	                  else if (this.players [i].getHandTotal () > 21)
	                  {
	                      System.out.println(this.players[i] + " Went over :(");
	                      bob = true;
	                  }
	                  else if (this.players [i].getHandTotal () == 21)
	                  {
	                      System.out.println(this.players[i] + " Has 21, HE WINS!!!");
	                      bob = true;
	                  }
	                  else //checks if they want to hit that round
	                  {
	                      boolean temp = this.players [i].wantsToHit ();
	                      if (temp == true)
	                      {
	                        System.out.println(this.players[i] + ", it's now your turn!!!");
	                        this.players[i].pickUpCard(this.deck.dealCard()); 
	                      }
	                      else if (temp == false)
	                      {
	                        bob = true; 
	                      }
	                  }
	                  
	                }while (bob == false);
	                System.out.println (" ");
	            }
	        }
	        this.dealer.revealCard ();
	        System.out.println (this.dealer.toString () + " " + this.dealer.getHandString ());
	        
	        boolean bob = true;
	        do
	        {
	            if (dealer.wantsToHit () == true )
	            {
	             dealer.pickUpCard(this.deck.dealCard());
	             System.out.println ("The Dealer hits!");
	             System.out.println (this.dealer.toString () + " " + this.dealer.getHandString ());
	            }
	            else
	            {
	              bob = false;
	              
	            }
	        }
	        while (bob == true);
	        
	        // Find out who wins and pay out the winnings
	        ///////////////////////////////////////////////////////////////
	        //  ~ player > 21                           --> player loses (loses chips)
	        //  ~ dealer 21 and player 21 --> tie (return bet amount)
	        //  ~ dealer = player                       --> tie (return bet amount)
	        //  ~ player 21 (but not dealer)     --> player wins (receive 2.5 * bet)
	        //  ~ dealer busts (but not player)         --> player wins (receive 2 * bet)
	        //  ~ player > dealer                       --> player wins (receive 2 * bet)
	        //  ~ othersize                             --> player loses (loses chips)
	        for (int i = 0; i < this.numPlayers; i++)
	        {
	            if (this.dealer.getHandTotal() > 21)
	            {
	                System.out.println (this.players [i] + " Won " + bets [i] + " chips!");
	                players [i].collectChips (bets [i]);
	            }
	             else if ((this.players [i].getHandTotal () == 21 && this.dealer.has21 ()) || this.players [i].getHandTotal () == this.dealer.getHandTotal () )
	            {
	                System.out.println (this.players [i] + " Tied the dealer!");
	            }
	            else if ((this.players [i].getHandTotal () == 21) || (this.players [i].getHandTotal () > this.dealer.getHandTotal () && this.players [i].getHandTotal () <= 21))
	            {
	                System.out.println (this.players [i] + " Won " + bets [i] + " chips!");
	                players [i].collectChips (bets [i]);
	            }
	            else if ((this.players [i].getHandTotal () > 21) || (this.players [i].getHandTotal () < this.dealer.getHandTotal ()))
	            {
	                System.out.println (this.players [i] + " Lost " + bets [i] + " chips!");
	                players [i].collectChips (-bets [i]);
	            }

	           
	        }
	        
	        // Clean up
	        for (int i = 0; i < this.numPlayers; i++) {
	            this.players[i].clearHand();
	        }
	        this.dealer.clearHand();
	    }
	    
	    /**
	     * Prints a summary of all of the players and their chips.
	     */
	    private void printSummary () 
	    {
	        for (int i = 0; i < this.numPlayers; i++) {
	            System.out.println(this.players[i] + " has " + 
	                    this.players[i].getNumChips() + " chips.");
	        }
	    }
	    
	    /**
	     * Runs the game.
	     * Runs again if they want to play another round
	     */
	    public static void main (String [] args) throws IOException
	    {
	        Game game = new Game();
	        char decision;
	        do {
	            game.playRound();
	            
	            game.printSummary();
	            System.out.println();
	            
	            System.out.print("Would you like to play another round? [Enter Y/N] ");
	            decision = game.input.readLine().toUpperCase().charAt(0);
	            System.out.println();
	        } while (decision == 'Y');
	    }
	}


