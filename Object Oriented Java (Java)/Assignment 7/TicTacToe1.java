
/**
 * Created by alexandrugutu on 3/14/14.
 */

import javax.swing.*;

public class TicTacToe1
{
	private char[][] board;
	private	int counter = 0;

	private JFrame GUI;
	private char currentPlayer;

	public TicTacToe1()
	{
		board = new char[3][3];
		GUI = new TTTGUI(this);
		setPlayer(counter);
	}

	public int getCounter()
		{
			return counter;
		}

	public void setPlayer(int counter)
		{
			if (counter % 2 == 0)
				currentPlayer = 'X';
			else
				currentPlayer = 'O';
		}

	public char getPlayer()
		{
			return currentPlayer;
		}

	public char getWinner()
		{
			setPlayer(counter--);
			char Winner = getPlayer();
			setPlayer(counter++);

			return Winner;
		}

	public void userInput()
	{
		while (true)
			{
				xPlayer();
				oPlayer();

				if (counter == 9)
					{
						JOptionPane.showMessageDialog(null, "The game is a tie!");
						System.exit(0);
					}
			}
	}

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

	public void xPlayer()
		{
			int input = (Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the location for X: ")) - 1);

			if (verifyInput(input))
				{
					if (isEmpty(input))
						{
							board[input / 3][input % 3] = 'X';
							if (checkWinner())
								{
									JOptionPane.showMessageDialog(null, "The Winner is X!");
									System.exit(0);
								}
							counter++;
							printBoard();
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

			setPlayer(counter);
		}

	public void oPlayer()
		{
			int input = (Integer.parseInt(JOptionPane.showInputDialog(null, "Please input the location for O: ")) - 1);

			if (verifyInput(input))
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
							printBoard();
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
			setPlayer(counter);
		}

	public void playerGUI(int input)
		{
			board[input / 3][input % 3] = currentPlayer;

			counter++;
		}

	public void resetGame()
		{
			counter = 0;
			setPlayer(counter);

			for (int i = 0; i < 9; i++)
				{
					board[i / 3][i % 3] = '\0';
				}
		}

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
		else if ((board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') || (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'))
		{
			winner = true;
		}
		else if ((board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') || (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'))
		{
			winner = true;
		}
		// Diagonal Checks
		else if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') || (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'))
		{
			winner = true;
		}
		else if ((board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') || (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'))
		{
			winner = true;
		}

		return winner;
	}
}