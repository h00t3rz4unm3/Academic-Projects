import java.io.BufferedReader;
import java.io.FileReader;
/**
 * this program takes a 10*10 integer array fulfill with 0s and 1s
 * and find a path through 0s
 * 
 * @author Weiwei
 *
 */
public class Project3 {

	static boolean found,startBtrack; //found: is the path found? startBtrack: start back tracking or not
	static int[][] maze; //the result maze which will be print out
	static int[][] temp; //the temporary maze to sketch
	static int nr, nc; //next row and next column

	/**
	 * 
	 * @param args input file
	 */
	public static void main (String [] args) {

		if (args.length == 0) System.out.println("No file specified."); //no file chosen
		else {
			FileReader theFile;
			BufferedReader inFile; 
			try {                       // FileNotFoundException must be caught
				theFile = new FileReader(args[0]);
				inFile = new BufferedReader(theFile);
				String Line = inFile.readLine();

				while (Line!=null){
					found = false;
					maze = new int[10][10];
					temp = new int[10][10];
					nr = 0;
					nc = 0;
					startBtrack = false;
					//initialize everything in order to do a new maze

					for(int r = 0; r<10; r++){
						String[]numbers = Line.split(" ");
						for(int c = 0; c<10; c++){
							maze[r][c] = Integer.parseInt(numbers[c]);
							temp[r][c] = Integer.parseInt(numbers[c]);
						}
						Line = inFile.readLine(); 
					} //fill up the result maze and temporary maze

					findWay(temp,0,0);	

					System.out.println("");
					Line = inFile.readLine(); //skip the empty line between two maze
				}

			}                                                                    

			catch (Exception e){ 
				e.printStackTrace();
			}
		}
	} // main

	/**
	 * recursive method to try each direction
	 * find out the path and put down a 2.
	 * 
	 * @param temp 	temporary maze
	 * @param sr	start row
	 * @param sc	start column
	 */
	private static void findWay(int[][] temp, int sr, int sc) {

		if(sr== 9 && sc == 9) //if reach [9][9] that means the path is found
			found = true;
		else{
			temp[sr][sc] = 1; //mark the position
			while (!found && possibleToMove(temp,sr,sc)){//if path no found, try one possible direction
				findWay(temp,nr,nc);
				if(found) {
					maze[sr][sc] = 2; //mark the path
					if(sr == 0 && sc == 0){
						System.out.println("");

						for(int x = 0; x<10;x++){
							for(int y = 0; y<10;y++)
								System.out.print(maze[x][y]+" ");
							System.out.println("");} // double for loop to print out the result maze
					}
					else{
						System.out.println(">>> BackTreacking from ["+nr+","+nc+"] to ["+sr+","+sc+"]");
						nr = sr;
						nc = sc;
						if(sr == 0 && sc == 0)
							System.out.println("No path exists");
						return;
					}
				}
			}
			System.out.println(">>> Start Backtracking from ["+sr+","+sc+"]");
			nr = sr;
			nc = sc;
		}



		/*	else if(!startBtrack){
			System.out.println(">>> Start Backtracking from ["+sr+","+sc+"]");
			nr = sr;
			nc = sc;
			startBtrack = true;
		} 	//if program reach here that means we have no way to go 
		  	//and if startBtrack is false that means we hit a dead-end
			//so begin to backtrack
		else {
			System.out.println(">>> BackTreacking from ["+nr+","+nc+"] to ["+sr+","+sc+"]");
			nr = sr;
			nc = sc;
			if(sr == 0 && sc == 0)
				System.out.println("No path exists");
		}	//starBtrack is true that means we are already start backtracking
			//so print out the two position we backtrack. */
	}	//findWay method

	/**
	 * this method find the possible direction to move
	 * return true and change the value of next row and next column
	 * 
	 * if there is not place to go
	 * then return false.
	 * 
	 * order of direction searching: north - east - south - west
	 * 
	 * @param temp	temporary maze
	 * @param sr	start row
	 * @param sc	start column
	 * @return
	 */
	private static boolean possibleToMove(int[][] temp,int sr, int sc) {



		if (sc!=9&&temp[sr][sc+1] == 0){
			nr = sr;
			nc = sc+1;
			startBtrack = false;
			return true;
		} 	//check east

		if(sr!=0&&temp[sr-1][sc] == 0){
			nr = sr-1;
			nc = sc;
			startBtrack = false;
			return true;
		}	//check north

		if(sc!=0&&temp[sr][sc-1] == 0){
			nr = sr;
			nc = sc-1;
			startBtrack = false;
			return true;
		}	//check west
		if(sr!=9&&temp[sr+1][sc] == 0){
			nr = sr+1;
			nc = sc;
			startBtrack = false;
			return true;
		}	//check south


		return false;
	}	//possibleToMove method

} 	//Project3