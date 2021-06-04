package game;

import java.util.Scanner;

public class TicTacToeGame 
{
	static char[] tttBoard = new char[10];
	
	/*This method create board.
	0th index ignored to make it user friendly.
	Assigning empty space to blocks.*/
	 
	public static void createBoard()
	{
		for(int i=0; i<tttBoard.length; i++)
		{
			tttBoard[i] = '-';
		}
	}
	
	//Asking user to input X Or O.
	public static void userInput()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the character x or o");
		char userInput = scanner.next().charAt(0);
		if( userInput == 'x' || userInput == 'o' )
		{
			if(userInput == 'x')
			{
				System.out.println("Player chooses x & o is for computer.\n");
			}
			else
			{
				System.out.println("Player chooses o & x is for computer.\n");
			}
		}
		else
		{
			System.out.println("Invalid Input ! Try again.\n");
			userInput();
		}
	}
	
	static void showBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + tttBoard[0] + " | "
						+ tttBoard[1] + " | " + tttBoard[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + tttBoard[3] + " | "
						+ tttBoard[4] + " | " + tttBoard[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + tttBoard[6] + " | "
						+ tttBoard[7] + " | " + tttBoard[8]
						+ " |");
		System.out.println("|---|---|---|");
	}
	
	public static void main(String[] args)
	{
		//Calling the createBoard method.
		createBoard();
		//Calling userInput method.
		userInput();
		//calling ShowBoard method.
		showBoard();
	}
}
