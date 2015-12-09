import javax.swing.*;

import static java.lang.Math.random;

/**
 * Created by alexandrugutu on 3/23/14.
 */
public class TicTacToe2
{
	private char[][] board;

	public TicTacToe2()
	{
		board = new char[3][3];
	}

	public void userInput()
	{
		int input;
		int counter = 0;
		while (counter < 9)
		{
			while (counter % 2 == 0)
			{
				// User input parsing string to Integer
				input = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the location for X: "));
				input = input - 1;

				// Verify input above 0 and below 9
				if (verifyInput(input))
				{
					// Make sure square is empty
					if (isEmpty(input))
					{
						board[input / 3][input % 3] = 'X';
						if (checkWinner() == true)
						{
							JOptionPane.showMessageDialog(null, "The Winner is X!");
							System.exit(0);
						}
						counter++;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The location you entered is already taken by " + board[input / 3][input % 3]);
					}
				}
				else if (!verifyInput(input))
				{
					JOptionPane.showMessageDialog(null, "The location you entered is incorrect");
				}

			}

			while (counter % 2 != 0)
			{
				// Computer generated input using random number generator between 0 and 8
//				input = (int)(9 * random());

				input = computerAI();

				if(verifyInput(input))
				{
					if (isEmpty(input))
					{
						board[input / 3][input % 3] = 'O';
						if (checkWinner())
						{
							JOptionPane.showMessageDialog(null, "The Winner is O!");
							System.exit(0);
						}
						counter++;
					}
				}
			}
			if (counter == 9)
			{
				JOptionPane.showMessageDialog(null, "The game is a tie!");
				System.exit(0);
			}
			printBoard();
		}
	}

	// Verify the location is empty
	public boolean isEmpty(int userinput)
	{
		if (board[userinput / 3][userinput % 3] == 'X' || board[userinput / 3][userinput % 3] == 'O')
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	// Verify input is between 0 and 8
	public boolean verifyInput(int userinput)
	{
		if (userinput < 0 || userinput > 8)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	// Print tic tac toe board
	public void printBoard()
	{
		for (int row = 0; row < 3; ++row)
		{
			for (int col = 0; col < 3; ++col)
			{
				System.out.print(" " + board[row][col] + " ");
				if (col != 3 - 1)
				{
					System.out.print("|");
				}
			}
			System.out.println();
			if (row != 3 - 1)
			{
				System.out.println("-----------");
			}
		}
		System.out.println();
	}

	// Verify winning conditions
	public boolean checkWinner()
	{
		boolean winner = false;
		// Row Checks
		if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') || (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'))
		{
			winner = true;
		}
		else if ((board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') || (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'))
		{
			winner = true;
		}
		else if ((board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') || (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'))
		{
			winner = true;
		}
		// Column Checks
		else if ((board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') || (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'))
		{
			winner = true;
		}
		else if ((board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') || (board[0][0] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'))
		{
			winner = true;
		}
		else if ((board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') || (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'))
		{
			winner = true;
		}
		// Diagonal Checks
		else if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') || (board[1][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'))
		{
			winner = true;
		}
		else if ((board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') || (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'))
		{
			winner = true;
		}
		return winner;
	}

	public int computerAI()
	{
		int nextmove = (int)(9 * random());
		for (int input = 0; input < 9; input++)
		{
			if (isEmpty(input))
			{
				board[input / 3][input % 3] = 'X';
				if (checkWinner())
				{
					nextmove = input;
					board[input / 3][input % 3] = '\u0000';
					return nextmove;
				}
				else
				{
					board[input / 3][input % 3] = '\u0000';
				}
			}
		}
		return nextmove;
	}


}
