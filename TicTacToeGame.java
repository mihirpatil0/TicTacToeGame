package game;

import java.util.Random;
import java.util.Scanner;


public class TicTacToeGame 
{
	static char[] tictactoeBoard = new char[10];
	static Scanner scanner;
	static char playerInput;
	static char computerInput;
	
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
	public static void playerInput() 
	{
		
		scanner = new Scanner(System.in);
		System.out.println("Choose the character x or o");
		playerInput = scanner.next().charAt(0);
		if (playerInput == 'x' || playerInput == 'o') 
		{
			if (playerInput == 'x') 
			{
				computerInput = 'o';
				System.out.println("Player chooses x & o is assigned to computer.\n");
			} 
			else 
			{
				computerInput = 'x';
				System.out.println("Player chooses o & x is assigned to computer.\n");
				//computerMove();
			}
		} 
		else 
		{
			System.out.println("Invalid Input ! Try again.\n");
			playerInput();
		}
		tossWhoIsFirst();
	}

	
	/**
	 * Displaying empty tic-tac-toe board.
	 */
	static void showBoard() 
	{
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
		//showBoard();
	}

	
	/**
	 * Checking with the player selected slot number,if it is empty or not.
	 * If empty assigning the chosen value in it.
	 */
	public static void playerMove() 
	{
		System.out.println("\nPlayer: Enter a slot number :\n");
		int boardSlotNumber = scanner.nextInt();

		if (boardSlotNumber > 0 && boardSlotNumber <= 9 && tictactoeBoard[boardSlotNumber] != 'x' && tictactoeBoard[boardSlotNumber] != 'o')
		{
			tictactoeBoard[boardSlotNumber] = playerInput;
			//beforeMoveBoard();
			showBoard();
		} 
		else 
		{
			System.out.println("Invalid input");
			playerMove();
		}
	}
	
	/**
	 * UC - 8
	 * If computer wins coin toss.
	 * computer will assign the value either x or o inside board. 
	 */
	public static void computerMove() 
	{
		Random random = new Random();
		int comupterRandomNumber = random.nextInt(9);
		if(comupterRandomNumber == 1)
		{
			tictactoeBoard[1] = computerInput;
			//beforeMoveBoard();
		}
		else if(comupterRandomNumber == 3)
		{
			tictactoeBoard[3] = computerInput;
			//beforeMoveBoard(); 
		}
		else if(comupterRandomNumber == 7)
		{
			tictactoeBoard[7] = computerInput;
			//beforeMoveBoard(); 
		}
		else if(comupterRandomNumber == 9)
		{
			tictactoeBoard[9] = computerInput;
			//beforeMoveBoard();
		}
		else
		{
			computerMove();
		}
		beforeMoveBoard();
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
				beforeMoveBoard();
			}
			else 
			{
				System.out.println("Computer won toss ! Make's first move.");
				computerMove();
			}
		}
		else
		{
			System.out.println("Invalid Coin choice: Make choice again.");
			tossWhoIsFirst();
		}
	}
	
	/**
	 * This function will check either winning or tie condition after every move.
	 * If any condition satisfied stop the game and print winner name.
	 */
	private static void winnerOrTie()
	{
		//Check each row for winning or tie condition.
		if(tictactoeBoard[0] == tictactoeBoard[1] && tictactoeBoard[1] == tictactoeBoard[2] && tictactoeBoard[0] != 1)
		{
			System.out.println("Winner");
		}
		if(tictactoeBoard[3] == tictactoeBoard[4] && tictactoeBoard[4] == tictactoeBoard[5] && tictactoeBoard[3] != 4)
		{
			System.out.println("Winner");
		}
		if(tictactoeBoard[6] == tictactoeBoard[7] && tictactoeBoard[7] == tictactoeBoard[8] && tictactoeBoard[6] != 7)
		{
			System.out.println("Winner");
		}
		//Check diagonally for winning or tie condition.
		if(tictactoeBoard[0] == tictactoeBoard[4] && tictactoeBoard[4] == tictactoeBoard[8] && tictactoeBoard[0] != 1)
		{
			System.out.println("Winner");
		}
		if(tictactoeBoard[6] == tictactoeBoard[4] && tictactoeBoard[4] == tictactoeBoard[2] && tictactoeBoard[6] != 7)
		{
			System.out.println("Winner");
		}
		else
		{
			//nobody has won yet.
			//changeTurn();
		}
	}
		
	/**
	 * @param args
	 * Calling static methods.
	 */
	public static void main(String[] args) 
	{
		createBoard();
		playerInput();
		showBoard();
		playerMove();
		winnerOrTie();
	}

}
