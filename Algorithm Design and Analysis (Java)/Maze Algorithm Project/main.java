/**
 * Created by Alex on 5/1/2015.
 */

import java.io.*;
import java.util.*;

public class main
	{
		public static void main(String[] args)
			{
				String fileInLocation = args[0];
				String fileOutLocation = args[1];

				try
					{
						Scanner inputReading = new Scanner(new FileReader((fileInLocation)));
						String input = inputReading.nextLine();
						StringTokenizer setBuilder = new StringTokenizer(input, " ");
						int[] inputVariables = new int[2];
						for (int i = 0; i < 2; i++)
							{
								inputVariables[i] = Integer.parseInt(setBuilder.nextToken());
							}
					}

				catch (FileNotFoundException e)
					{
						System.out.println("No file found");
					}


				int rows = 10;
				int columns = 10;

				int direction;

				Grid mazeGrid = new Grid(rows, columns);

				mazeGrid.addCell(mazeGrid.getStartSpot());
				Cell currentCell = mazeGrid.getStartSpot();

				Stack<Cell> correctPath;

				while (!mazeGrid.stack.empty())
					{
						System.out.println("main while loop");
						direction = new Random().nextInt(3);
						currentCell = mazeGrid.nextMove(mazeGrid.stack.peek(), direction);

						while (currentCell == mazeGrid.stack.peek())
							{
								System.out.println("inner" + currentCell.row + " " + currentCell.column);
								currentCell.putWallDown(direction);

								if (currentCell.wallsDown())
									{
										mazeGrid.stack.pop();
									}

								if (currentCell == mazeGrid.getEndSpot())
									{
										correctPath = (Stack<Cell>) mazeGrid.stack.clone();
									}

								direction = new Random().nextInt(3);
								currentCell = mazeGrid.nextMove(mazeGrid.stack.peek(), direction);

							}

						currentCell.hasBeenVisited = true;
						mazeGrid.removeWalls(currentCell, direction);
						mazeGrid.addCell(currentCell);
					}

				mazeGrid.printMaze();
			}
	}
