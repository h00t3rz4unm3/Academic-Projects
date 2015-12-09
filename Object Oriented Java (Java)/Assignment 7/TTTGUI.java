import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by alexandrugutu on 4/8/14.
 */

/**
 * Use the slideshows posted here on blackboard and the java api to help you create this object
 *
 *	Create a tic tac toe GUI object. call the class TTTGUI
 *	a) There should be a text box (look up JTextField). When the game starts, the text field should say "would you like to play tic tac toe?"
 *	There should be two buttons below the text field. One says "yes" and the other says "no". If button "no" is pressed the GUI should close and
 *	the program should quit. If button "yes" is pressed, both of these 2 buttons should disappear (look up setVisibile), the Text Field should say
 *	"X, pick a square" (look up method setText). There should now be 9 buttons in a 3x3 grid (use GridLayoutManager for these 9 buttons but the other
 *	 2 buttons and text field should be placed with a different layout manger - I recommend using BorderLayoutManager for this, but you dont have to).
 *	you will also probably have to resize the 9 buttons so that they will each be a square. When one of these 9 buttons is pressed:
 *	i) the text of the button should represent which player pressed the button.
 *	ii) the text field should change to indicate whose turn it is now
 *	and iii) that button pressed should remain visible, but become disabled (look up method setEnabled)
 *
 *	After a game is finished (either with a winner or a draw), the GUI object should again ask the user if they want to play and depending
 *	on the response from the user, a new game should be started or the program should close.
 *
 *
 *	b) You must create a main method that will call the constructor to this GUI object. The method should be in its own class.
 *
 *	c) The GUI object should interact with an instance of the TicTacToe class that you created in assignment 5. (some adjustments to that
 *	class might be necessary).
 *
 *	If you were unable to get a working version for assignment 5, I am planning on posting a version of the class on Thursday. If possible, I would perfer
 *	that you use your version.
 */

public class TTTGUI extends JFrame
	{
		// ActionEvent Listener
		ActionListener buttonListener = new Listener();

		// TickTacToe Logic
		TicTacToe1 backend;

		private int scoreX = 0;
		private int scoreO = 0;

		// Text label
		JLabel myTextLabel = new JLabel();
		JLabel scoreLabelX = new JLabel("X: " + Integer.toString(scoreX));
		JLabel scoreLabelO = new JLabel("O: " + Integer.toString(scoreO));

		// Buttons
		JButton[] button = new JButton[9];
		JButton yes = new JButton("Yes");
		JButton no = new JButton("No");

		// Layout
		Container myContentPane = getContentPane();
		JPanel grid = gridButtons();
		JPanel yesNo = yesNoButtons();
		JPanel score = scoreBoard();

		public TTTGUI(TicTacToe1 logic)
			{
				backend = logic;

				setTitle("Tic Tac Toe");
				setSize(600, 600);
				setLocationRelativeTo(null);

				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				initialize();
				playerChoice();
			}

		public void initialize()
			{
				myContentPane.add(myTextLabel, BorderLayout.NORTH);
				myTextLabel.setVisible(false);

				myContentPane.add(yesNo, BorderLayout.SOUTH);
				yesNo.setVisible(false);

				myContentPane.add(grid, BorderLayout.CENTER);
				grid.setVisible(false);

				myContentPane.add(score, BorderLayout.EAST);
				score.setVisible(true);
			}

		// Sets Yes/No buttons visible
		public void playerChoice()
			{
				myTextLabel.setText("Would you like to play Tic Tac Toe?");
				myTextLabel.setHorizontalAlignment(SwingConstants.CENTER);

				myTextLabel.setVisible(true);
				yesNo.setVisible(true);
			}

		// Starts the game when called
		public void startGame()
			{
				grid.setVisible(true);
				yesNo.setVisible(false);
			}

		// Resets the game when called
		public void resetGame()
			{
				myTextLabel.setText(backend.getPlayer() + " has won the game! Would you like to play again?");
				myTextLabel.setHorizontalAlignment(SwingConstants.CENTER);

				yesNo.setVisible(true);
				grid.setVisible(false);

				backend.resetGame();
				for (int i = 0; i < 9; i++)
					{
						button[i].setEnabled(true);
						button[i].setText(Integer.toString(i + 1));
					}
			}

		// JPanel with buttons inside
		public JPanel gridButtons()
			{
				// Grid Layout
				JPanel gridLayout = new JPanel();

				gridLayout.setLayout(new GridLayout(3, 3));

				for (int i = 0; i < 9; i++)
					{
						button[i] = new JButton(i + 1 + "");
						button[i].setText(Integer.toString(i + 1));
						button[i].addActionListener(buttonListener);
						gridLayout.add(button[i]);
					}

				return gridLayout;
			}

		// JPanel with the YES/NO buttons inside
		public JPanel yesNoButtons()
			{
				JPanel yesNoButtons = new JPanel();

				yesNoButtons.setLayout(new GridLayout(1, 2));

				yesNoButtons.add(yes);
				yes.addActionListener(buttonListener);

				yesNoButtons.add(no);
				no.addActionListener(buttonListener);

				return yesNoButtons;
			}

		// JPanel for the scoreboard
		public JPanel scoreBoard()
			{
				JPanel score = new JPanel();

				score.setLayout(new GridLayout(2, 1));

				score.add(scoreLabelX);
				score.add(scoreLabelO);

				return score;
			}

		// Actionlistener class (implements actionlistener)
		public class Listener implements ActionListener
			{

				public void actionPerformed(ActionEvent e)
					{
						// No button definition for Action
						if (((JButton) e.getSource()).getText().equals("No"))
							{
								System.exit(0);

							}
						// Yes button definition for Action
						else if (((JButton) e.getSource()).getText().equals("Yes"))
							{
								yesNo.setVisible(false);

								startGame();

								myTextLabel.setText(backend.getPlayer() + ", Please pick an available square");

							}
						// Actions defined for the grid buttons
						else
							{
								backend.playerGUI(Integer.parseInt(((JButton) e.getSource()).getText()) - 1);
								((JButton) e.getSource()).setLabel(Character.toString(backend.getPlayer()));
								((JButton) e.getSource()).setEnabled(false);

								if (backend.checkWinner())
									{



												if (backend.getPlayer() == 'X')
											{
												scoreX++;
												scoreLabelX.setText("X: " + Integer.toString(scoreX));
											}
										else if (backend.getPlayer() == 'O')
											{
												scoreO++;
												scoreLabelO.setText("O: " + Integer.toString(scoreO));
											}
										resetGame();
									}
								else if (backend.getCounter() == 9)
									{
										resetGame();
										myTextLabel.setText("It appears the game is a tie. Would you like to play again?");
										myTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
									}
								else
									{
										backend.setPlayer(backend.getCounter());

										myTextLabel.setText(backend.getPlayer() + " please pick a square");
										myTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
									}
							}
					}
			}
	}
