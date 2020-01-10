package gameOf21;

import java.io.IOException;
import java.util.Scanner; 

public class Main
{

	
	
	public void welcome()
	{
		System.out.println("Welcome to the card game of 21!");
		System.out.println("Have fun!");
	}
	
	
	public void rules()
	{
		System.out.println("To start, players are dealt two cards from the deck of playing cards.");
		System.out.println("Players can choose to hold these cards or they can choose to be given a third, fourth or fifth card.");
		System.out.println("The player who is closest to 21 points without going over is the winner.");
		System.out.println("However, if a player gets under 21 points with 5 cards, they automatically win.");
		System.out.println("You will have the chance to play against another player or the player.");
		System.out.println("You can play as many rounds as you want. A winner will be announced at the end of each round.");
		System.out.println("The grand winner of the whole game will be announced at the end of the game.");
		
		System.out.println();
		
		System.out.println("Each number card has a value equal to its number.");
		System.out.println("Each face card (Jack, Queen and King) is equal to ten.");
		System.out.println("The Ace is a bit different from the rest of the cards.");
		System.out.println("it can equal either one or eleven, depending on what you want it to be.");
	}
	
	
	public static void main(String[] args) throws IOException
	{
		//Variables
		String answer;
		String start;
		String startKey="1";
		Scanner input = new Scanner(System.in);
		Main GameOf21 = new Main();
		
		GameOf21.welcome();
		
		System.out.println("Would you like to see the rules of the game? (yes/no)");
		System.out.print("--> ");
		answer=input.next();
		//answer.toLowerCase();
		System.out.println();
		
		while (!answer.equalsIgnoreCase("yes")&& !answer.equalsIgnoreCase("no"))
		{
			System.out.println("Invalid");
			System.out.println("Please enter yes or no.");
			System.out.print("--> ");
			answer=input.next();
			//answer.toLowerCase();
			System.out.println();
		}
		
		if (answer.equalsIgnoreCase("yes"))
		{
			System.out.println();
			GameOf21.rules();
		}
		
		System.out.println();
		System.out.println("Press 1 to start");
		System.out.print("--> ");
		start=input.next();
		System.out.println();

		
		while (!start.matches(startKey))
		{
			System.out.println("Press 1 to start");
			System.out.print("--> ");
			start=input.next();
			System.out.println();
			
		}
		
		if (start.equals(startKey))
		{
			Game.main(args);
		}
		
	}
}

