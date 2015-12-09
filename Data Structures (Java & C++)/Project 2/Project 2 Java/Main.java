import java.io.*;
import java.util.*;

/**
 * Created by alexandrugutu on 9/29/14.
 */

public class Main
	{
		public static void main(String[] args)
			{
				// Initialize variables
				int count = 0;
				int dummydata = 0;

				Scanner userinput = new Scanner(System.in);

				// Ask user for location of file
				System.out.println("What is the name of the input file: ");

				String fileinput = userinput.nextLine();

				System.out.println();

				// Try and open the file. Throw exception if it fails
				try
					{
						// Open file using the location asked by the user
						Scanner firstreading = new Scanner(new FileReader(fileinput));

						// Initial reading of file allows to determine a count
						while (firstreading.hasNextInt())
							{
								count++;
								dummydata = firstreading.nextInt();
							}

						firstreading.close();

						// Second reading allows us to import data
						Scanner secondreading = new Scanner(new FileReader(fileinput));

						// Create an array the size of count based on first reading
						int array[] = new int[count];

						// Call insertionsort function
						insetionsort(array, secondreading);
					}

				// Throw exception if opening file fails
				catch (FileNotFoundException e)
					{
						System.out.println("File not found!");
					}

			}

		static public void insetionsort(int array[], Scanner secondreading)
			{
				int data;
				int last = 0;
				int index;

				data = secondreading.nextInt();
				array[last] = data;

				while (secondreading.hasNextInt())
					{
						int spot = 0;

						data = secondreading.nextInt();

						last++;
						index = last;

						while (array[spot] < data)
							{
								spot++;
								if (spot > last)
									{
										spot = last;
										break;
									}
							}

						while (index > spot)
							{
								array[index] = array[index - 1];
								index--;
							}

						array[spot] = data;

						System.out.println("Last: " + last + " Data: " + data + " Spot: " + spot);
						for (int i = 0; i <= last; i++)
							{
								System.out.print(array[i] + " ");
							}
						System.out.println();
						System.out.println();
					}
			}
	}
