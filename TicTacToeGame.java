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
		for(int i=1; i<tttBoard.length; i++)
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
				System.out.println("Player chooses x & o is for computer.");
			}
			else
			{
				System.out.println("Player chooses o & x is for computer.");
			}
		}
		else
		{
			System.out.println("Invalid Input ! Try again.");
			userInput();
		}
	}
	
	
	public static void main(String[] args)
	{
		//Calling the method.
		createBoard();
		userInput();
	}
}
