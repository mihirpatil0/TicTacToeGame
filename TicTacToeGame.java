package game;

import java.util.Iterator;

public class TicTacToeGame 
{
	static char[] tttBoard = new char[10];
	
	/**
	 * {@summary}
	 * This method create board.
	 */
	public static void createBoard()
	{
		for(int i=1; i<tttBoard.length; i++)
		{
			tttBoard[i] = '-';
		}
	}
	
	public static void main(String[] args)
	{
		
	}
}
