package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class game {

	static int rounds = 0;
	static String input = null; 
	static int choice = 0;
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static int playerRounds = 0;
	static int compRounds = 0;
	static int tieRounds = 0;
	
	public static void main(String[] args) {

		
		do {
			try {
			System.out.print("Please enter number of rounds (1-10):");
			input = sc.next();
			rounds = Integer.parseInt(input);
			System.out.println();
			}
			catch(NumberFormatException e)
			{
				System.out.println(input + " is not a number. Please input a number");
				continue;
			}
			if (rounds<0)
			{
				System.out.println("You can't have negative rounds. Input a number between 1 and 10.");
				rounds=0;
				continue;
			}
			else if (rounds>10)
			{
				System.out.println("Too many rounds. Enter a number between 1 and 10.");
				rounds=0;
				continue;
			}
			else if (rounds==0)
			{
				System.out.println("Zero rounds? That's called not playing. Ok, exiting.");
				System.exit(rounds);
			}
		}
		while(rounds==0);
		
		for (int i=0;i<rounds;i++)
		{
			GetResult(GetPlayerChoice());
		}
		
		FinalResults();

	}

	public static int GetPlayerChoice()

	{
		do
		{
			try {
				System.out.println("Make a selection");
				System.out.println("1: Paper");
				System.out.println("2: Scissors");
				System.out.println("3: Rock");
				System.out.print("Your selection:");
				input = sc.next();
				choice = Integer.parseInt(input);
				System.out.println();
			}
			catch(NumberFormatException e)
			{
				System.out.println(input + " is not a number. Please input a number between 1 and 3");
				continue;
			}
			if (choice<0||choice>3)
			{
				System.out.println("Not a valid selection.");
				choice=0;
				continue;
			}

		}
		while(choice==0);
		return choice;
		
		}

	public static void GetResult(int playerChoice)
	{
		String player = null;
		String comp = null;
		int compChoice = rand.nextInt(3)+1;
		switch(compChoice)
		{
			case 1:
			{
				comp = "paper";
				break;
			}
			case 2:
			{
				comp = "scissors";
				break;
			}
			case 3:
			{
				comp = "rock";
				break;
			}
		}

				
		switch(playerChoice)
		{
			case 1:
			{
				player = "paper";
				break;
			}
			
			case 2:
			{
				player = "scissors";
				break;
			}
			
			case 3: 
			{
				player = "rock";
				break;
			}
			
		}
		
		OutputResult(playerChoice,compChoice,player,comp);
	}
	
	public static void OutputResult(int playerChoice, int compChoice, String player, String comp)
	{
		System.out.println("Player chose " + player + ". Computer chose " + comp + ".");
		if (playerChoice == compChoice)
		{
			tieRounds++;
			System.out.println("Tie game");
		}
		
		if (playerChoice==1)
		{
			if (compChoice==2)
			{
				CompRound();
			}
			else 
			{
				PlayerRound();
			}
		}
		if (playerChoice==2)
		{
			if(compChoice==1)
			{
				PlayerRound();
			}
			else
			{
				CompRound();
			}
		}
		if (playerChoice==3)
		{
			if(compChoice==1)
			{
				CompRound();
			}
			else
			{
				PlayerRound();
			}
		}
		
	}
	
	public static void PlayerRound()
	{
		playerRounds++;
		System.out.println("Player wins.");
		System.out.println();
	}
	
	public static void CompRound()
	{
		compRounds++;
		System.out.println("Comp wins.");
		System.out.println();
	}

	public static void FinalResults()
	{
		System.out.println("Total Rounds: " + rounds);
		System.out.println("Player wins: " + playerRounds);
		System.out.println("Computer wins:" + compRounds);
	}
}

