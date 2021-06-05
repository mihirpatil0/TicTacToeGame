package game;

import java.util.Random;
import java.util.Scanner;


public class TicTacToeGame 
{
	static char[] tictactoeBoard = new char[10];
	static Scanner scanner;
	static char userInput;

	/**
	* This method create board. 0th index ignored to make it user friendly.
	* Assigning empty space to blocks.
	*/
	public static void createBoard() 
	{
		for (int i = 0; i < tictactoeBoard.length; i++) 
		{
			tictactoeBoard[i] = '-';
		}
	}

	
	/**
	 * Asking user what his choice is.
	 * Either x or o.
	 * vice versa will get assigned.
	 */
	public static void userInput() 
	{
		scanner = new Scanner(System.in);
		System.out.println("Choose the character x or o");
		userInput = scanner.next().charAt(0);
		if (userInput == 'x' || userInput == 'o') 
		{
			if (userInput == 'x') 
			{
				System.out.println("Player chooses x & o is assigned to computer.\n");
			} 
			else 
			{
				System.out.println("Player chooses o & x is assigned to computer.\n");
			}
		} 
		else 
		{
			System.out.println("Invalid Input ! Try again.\n");
			userInput();
		}
		tossWhoIsFirst();
	}

	
	/**
	 * Displaying empty tic-tac-toe board.
	 */
	static void showBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + tictactoeBoard[1] + " | " + tictactoeBoard[2] + " | " + tictactoeBoard[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + tictactoeBoard[4] + " | " + tictactoeBoard[5] + " | " + tictactoeBoard[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + tictactoeBoard[7] + " | " + tictactoeBoard[8] + " | " + tictactoeBoard[9] + " |");
		System.out.println("|---|---|---|");
	}

	/**
	 * Displaying Board with Block numbers.
	 * player can choose in which block she/he want to draw the selected choice.
	 */
	static void beforeMoveBoard()
	{
		int REDIX = 10;
		System.out.println("\n");
		for (int i = 0; i < 10; i++)
		{
			if (tictactoeBoard[i] != 'x' && tictactoeBoard[i] != 'o') 
			{
				tictactoeBoard[i] = Character.forDigit(i, REDIX);
			}
		}
		showBoard();
	}

	
	/**
	 * Checking with the player selected slot number,if it is empty or not.
	 * If empty assigning the chosen value in it.
	 */
	public static void userMove() 
	{
		System.out.println("\nEnter a slot number :\n");
		int nmb = scanner.nextInt();

		if (nmb > 0 && nmb <= 9 && tictactoeBoard[nmb] != 'x' && tictactoeBoard[nmb] != 'o')
		{
			tictactoeBoard[nmb] = userInput;
			beforeMoveBoard();
		} 
		else 
		{
			System.out.println("Invalid input");
			userMove();
		}
	}

	/**
	 * UC-6
	 * Making use of Random function that generate head or tail.
	 * Player or Computer makes a call.
	 * Whoever wins make first move.
	 */
	public static void tossWhoIsFirst() 
	{
		
		Random randomHeadTail = new Random();
		int generatedHeadOrTail = randomHeadTail.nextInt(2);
		System.out.println(generatedHeadOrTail);
		System.out.println("Tossing a coin To decide who plays first.\nEnter 1-for-Head or 0-for-Tail:");
		scanner = new Scanner(System.in);
		int playerHeadOrTail = scanner.nextInt();
		if(playerHeadOrTail >= 0 && playerHeadOrTail <= 1)
		{
			if(playerHeadOrTail == generatedHeadOrTail)
			{
				System.out.println("Player won toss ! Make first move.");
			}
			else 
			{
				System.out.println("Computer won toss ! Make first move.");
			}
		}
		else
		{
			System.out.println("Invalid Coin choice: Make choice again.");
			tossWhoIsFirst();
		}
	}
		
	public static void main(String[] args) 
	{
		createBoard();
		userInput();
		showBoard();
		beforeMoveBoard();
		userMove();
	}

}
