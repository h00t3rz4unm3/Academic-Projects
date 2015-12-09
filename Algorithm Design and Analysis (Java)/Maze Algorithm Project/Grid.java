/**
 * Created by Alex on 5/1/2015.
 */

import java.util.*;

public class Grid
	{
		public Cell[][] grid;
		public int rows;
		public int columns;

		Stack<Cell> stack;

		public Grid(int rows, int columns)
			{
				this.rows = rows;
				this.columns = columns;

				stack = new Stack<Cell>();
				grid = new Cell[rows][columns];

				for (int i = 0; i < rows; i++)
					{
						for (int j = 0; j < columns; j++)
							{
								grid[i][j] = new Cell();
								grid[i][j].row = i;
								grid[i][j].column = j;
							}
					}

				grid[0][0].startSpot = true;
				grid[rows - 1][columns - 1].endSpot = true;
			}

		public Cell getStartSpot()
			{
				return grid[0][0];
			}

		public Cell getEndSpot()
			{
				return grid[rows - 1][columns - 1];
			}

		public void addCell(Cell current)
			{
				stack.push(current);
			}

		public Cell getTopCell()
			{
				return stack.peek();
			}

		public void removeWalls(Cell currentCell, int direction)
			{
				switch (direction)
					{
						case 0:
						{
							getTopCell().northWall = true;
							currentCell.southWall = true;
						}
						case 1:
						{
							getTopCell().eastWall = true;
							currentCell.westWall = true;
						}
						case 2:
						{
							getTopCell().southWall = true;
							currentCell.northWall = true;
						}
						case 3:
						{
							getTopCell().westWall = true;
							currentCell.eastWall = true;
						}
					}
			}

		public Cell nextMove(Cell cellStackTop, int direction)
			{
				Cell returnCell = null;

				switch (direction)
				{
					// North
					case 0:
					{
						if ((cellStackTop.row - 1) < 0)
							{
								returnCell = cellStackTop;
							}
						else if (grid[cellStackTop.row - 1][cellStackTop.column].isVisited())
							{
								returnCell = cellStackTop;
							}
						else
							{
								returnCell = grid[cellStackTop.row - 1][cellStackTop.column];
							}
					}

					// East
					case 1:
					{
						if ((cellStackTop.column + 1) >= columns)
							{
								returnCell = cellStackTop;
							}
						else if (grid[cellStackTop.row][cellStackTop.column + 1].isVisited())
							{
								returnCell = cellStackTop;
							}
						else
							{
								returnCell = grid[cellStackTop.row][cellStackTop.column + 1];
							}
					}

					// South
					case 2:
					{
						if ((cellStackTop.row + 1) >= rows)
							{
								returnCell = cellStackTop;
							}
						else if (grid[cellStackTop.row + 1][cellStackTop.column].isVisited())
							{
								returnCell = cellStackTop;
							}
						else
							{
								returnCell = grid[cellStackTop.row + 1][cellStackTop.column];
							}
					}

					// West
					case 3:
					{
						if ((cellStackTop.column - 1) < 0)
							{
								returnCell = cellStackTop;
							}
						else if (grid[cellStackTop.row][cellStackTop.column - 1].isVisited())
							{
								returnCell = cellStackTop;
							}
						else
							{
								returnCell = grid[cellStackTop.row][cellStackTop.column - 1];
							}
					}
				}

				return returnCell;
			}

		public void printMaze()
			{
				for (int i = 0; i < rows; i++)
					{
						for (int j = 0; j < columns; j++)
							{
								if (j % columns == 0)
									{
										System.out.println();
									}
								grid[i][j].printNorthWall();
								grid[i][j].printWestWall();
								grid[i][j].printEastWall();
								grid[i][j].printSouthWall();
							}
					}
			}

	}
