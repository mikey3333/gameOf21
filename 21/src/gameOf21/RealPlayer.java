package gameOf21;

import java.io.*;

/**
* A class representing a Blackjack human player.
* <p>Inherits from the Player class.</p>
* <p>The methods of this class will display to the screen and get input from
* the user.</p>
*/
public class RealPlayer extends Player 
{
 BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
///// Constructor
/**
*    Creates a human player from the player parent
*     name  = The player name
*     numChips = The Number of chips the said player owns
*/
public RealPlayer (String name, int numChips)
{
    super(name, numChips);
  //Creates a another real player with a given name and specific number of chips to start with.
}
/**
*    Asks for a bet 
*    Returns The amount the player wants to bet
*/
public int makeBet () throws IOException
{
     boolean bob = false;
     int betAmount;
     do
     {   
         System.out.println ("How much would you like to bet? ");
         betAmount = Integer.parseInt (input.readLine ());
         
         if (betAmount <= this.numChips && betAmount >= 0)///If the bet is less then or equal to chip num 
         {                                                ///and greater then or equal to 0
             return betAmount;
         }
         else ///If it is not valid
         {
             System.out.println ("out or, not accepted amount! ");
         }
     }
     while (bob == false);
     return betAmount;
     //This is called to make it so the human player can input their bet for a round. 
     // The method should check that a valid number of chips is bet and ask again if invalid. 
     // Zero chips is an allowable bet.  Return the bet amount.
}

/**
*    Checks if player wishs to hit or stand
*    Returns true if they want to hit
*    Returns false if they want to stand
*/
public boolean wantsToHit() throws IOException
{
     System.out.println ("Would you like to Hit or Stand?");
     String temp = (input.readLine ());
     char what = temp.charAt (0) ;
     if (what == 'H' || what =='h')
     {
         return true;
     }
     else
     {
         return false;
     }

   //This is called to make it so the human player can input whether they want to "hit" or "stand".
   // Return true if the player wants to "hit" or false if the player wants to "stand".
}
}


