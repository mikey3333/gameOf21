package gameOf21;
/**
* A hand of cards used for a Blackjack player.
* <p>This class inherits from the Hand class, but also keeps track of the value
* of the hand using Blackjack rules.</p>
*/
public class GameHand extends Hand
{
   private int total = 0;
   private int aces = 0;
   ////////////// Constructor
   public GameHand()
   {
       super ();//Creates an empty hand. 
   }
   /**
    * Gets the total points
    * Returns total of card value
    */
   public int getTotal ()
   {
       total = 0;
       aces = 0;
       for (int x = 0; x != this.size; x++)
       {
         if (this.cards [x].getRank () == 1)//if the card is an ace, add to the ace total score
         {
             aces ++;
         }
         else if (this.cards [x].getRank () >= 10)
         {
           total = total + 10;
         }
         else 
         {
           total = total + this.cards [x].getRank ();
         }
       }
       
       if (aces > 0)
       {
           do
               if (total + 11 < 21)
               {
                   total = total + 11;
                   aces --;
               }
               else
               {
                   total = total + aces;
                   aces = 0;
               }
           while (aces != 0);
       }
       // Get the total value of the Blackjack hand.
       return total;
   }
   
   /**
    * Decides if hand is soft or not
    * @return true if soft
    * @return false if hard
    */
   public boolean getIsSoft ()
   {
       total = 0;
       aces =0;
       for (int x = 0; x != this.size; x++)
       {
         if (this.cards [x].getRank () == 1)
         {
             aces ++;
         }
         else if (this.cards [x].getRank () >= 10)
         {
           total = total + 10;
         }
         else 
         {
           total = total + this.cards [x].getRank ();
         }
       }
       
       if (aces > 0)
       {
           do
               if (total + 11 < 21)
               {
                   total = total + 11;
                   aces --;
                   return true;
               }
               else if (total + 11 > 21)
               {
                   total = total + aces;
                   aces = 0;
                   return false;
               }
           while (aces != 0);
       }
       return false;
       // Return true if the hand is "soft" and false if the hand is "hard".
   }
   ////////////// Behavioural
   /**
    * adds card to hand
    *  card uses the addcard from parent
    */
   public void addCard (Card card)
   {
       super.addCard (card);
       //Implement if it is necessary to do more work than the generic Hand.addCard() method.
   }
   
   /**
    * removes card from hand
    *  index uses the removescard from parent
    * Returns null
    */
   public Card removeCard (int index)
   {
       //In Blackjack, cards are never removed from hands (only added). 
       // Override the Hand.removeCard() method and just return null.
       
       return null;
   }
   
   /**
    * Gets the total points for rank and suit     
    * Returns null
    */
   public Card removeCard (int rank,char suit)
   {
       //Overrides the Hand.removeCard() method and just returns nothing.
       return null;
   }
   
   /**
    * Clears hand
    */
   public void clear ()
   {
       super.clear ();
       total = 0;
       aces = 0;
       //Implement if it is necessary to do more work than the generic Hand.clear() method.
   }

   /**
    * Checks if it is a blackjack hand
    * @return true if blackjack
    * @return false if not blackjack
    */
   public boolean isBlackjack ()
   {
       getTotal ();
       if (total == 21)
       {
           return true;
       }
       else 
       {
           return false;
       }
       //Returns true if the hand has 21 and false if it does not.
   }
  
   public String toString ()
   {
       String st = super.toString ();
           if (isBlackjack () == true)
           {
               st = st + " (BLACKJACK)";
               return st;
           }
           else if (getIsSoft () == true)
           {
               st = st + " (soft " + getTotal () + ")";
               return st;
           } 
           else
           {
               st = st + " (" + getTotal () + ")";
               return st;
           }
       
   }
}

