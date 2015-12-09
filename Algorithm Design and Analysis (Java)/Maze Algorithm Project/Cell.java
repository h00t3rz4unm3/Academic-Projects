/**
 * Created by Alex on 5/1/2015.
 */
public class Cell
	{
		int row;
		int column;

		boolean northWall;
		boolean westWall;
		boolean southWall;
		boolean eastWall;

		boolean hasBeenVisited;
		boolean startSpot;
		boolean endSpot;

		public Cell()
			{
				northWall = false;
				westWall = false;
				southWall = false;
				eastWall = false;

				hasBeenVisited = false;

				startSpot = false;
				endSpot = false;
			}

		public void putWallDown(int direction)
			{
				if (direction == 0)
					{
						northWall = true;
					}
				else if (direction == 1)
					{
						eastWall = true;
					}
				else if (direction == 2)
					{
						southWall = true;
					}
				else if (direction == 3)
					{
						westWall = true;
					}
			}

		public boolean wallsDown()
			{
				if (northWall == true && eastWall == true && southWall == true && westWall == true)
					{
						return true;
					}
				else
					{
						return false;
					}
			}

		public boolean isVisited()
			{
				return hasBeenVisited;
			}

		public void printNorthWall()
			{
				if (northWall == true)
					{
						System.out.print("-");
					}
				else if (northWall == false)
					{
						System.out.print(" ");
					}
			}

		public void printEastWall()
			{
				if (eastWall == true)
					{
						System.out.print("|");
					}
				else if (eastWall == false)
					{
						System.out.print(" ");
					}
			}

		public void printSouthWall()
			{
				if (southWall == true)
					{
						System.out.print("-");
					}
				else if (southWall == false)
					{
						System.out.print(" ");
					}
			}

		public void printWestWall()
			{
				if (westWall == true)
					{
						System.out.print("|");
					}
				else if (westWall == false)
					{
						System.out.print(" ");
					}
			}
	}
