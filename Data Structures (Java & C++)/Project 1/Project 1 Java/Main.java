/**
*   Main.java
*   Project 1 Java
*
*   Created by Alexandru Gutu on 9/17/14.
*   Copyright (c) 2014 Alexandru Gutu. All rights reserved.
*
*   Suppose we are given a data file (data1.txt) which contains integers. We are interested to know:
*   1) How many integers are in data1.txt
*	2) The largest integer in data1.txt
*	3) The smallest integer in data1.txt
*   4) The average of all integers in data1.txt
*
*   Use an array to store the data, and selection sort to sort the array.
**/

//  Step 1: Prepare program by importing specific libraries

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {

//  Step 2: Initialize variables and opening the data file

        double average = 0.0;
        int sum = 0;
        int count = 0;
        int min = 99999999;
        int max = -99999999;
	    int iterationcounter = 1;

// Step 4: Assume data is integer, therefore process data and perform needed functions. In this case, we are asking the user for the location of the file. First, we read the data in the file to get a count of how many integers there will be. Then, we are creating a dynamically allocated array and storing the input data in the array. Furthermore, we are processing the data (min/max/sum/etc)

        Scanner userinput = new Scanner(System.in);

        System.out.println("What is the name of the input file: ");

	    String fileinput = userinput.nextLine();

	    System.out.println();

        try
            {
                Scanner firstreading = new Scanner(new FileReader(fileinput));

	            while (firstreading.hasNextInt())
		            {
			            sum += firstreading.nextInt();
			            count++;
		            }

	            firstreading.close();

	            Scanner secondreading = new Scanner(new FileReader(fileinput));

	            int array[] = new int[count];

//  Step 5; Repeat until all data is read (while loop)

	            System.out.println("Original Array:");
	            for (int i = 0; i < count; i++)
		            {
			            array[i] = secondreading.nextInt();

			            if (array[i] < min)
				            {
					            min = array[i];
				            }
			            else if (array[i] > max)
				            {
					            max = array[i];
				            }
		            }

// Step 6: Print out original array using for loop and the index values.

	            for (int i = 0; i < count; i++)
		            {
			            System.out.print(array[i] + " ");
			            if ((i + 1) % 43 == 0)
				            {
					            System.out.println();
					            for (int j = 0; j < count; j++)
						            {
							            System.out.print(j + "  ");
						            }
				            }
		            }

	            System.out.println();

// Step 7: Call the sort function. This function was made simply to keep the code a little clearer

				sort(array, count, iterationcounter);

// Step 8: Display the needed results

	            average = (double) sum/count;

	            System.out.println(System.getProperty("line.separator") + "There are: " + count + " integers");
	            System.out.println("The minimum is: " + min);
	            System.out.println("The maximum is: " + max);
	            System.out.println("The average is: " + average);

	            secondreading.close();

            }
        catch (FileNotFoundException e)
            {
                System.out.println("File not found!");
            }

    }

//  Prints the array, the iteration number, minimumindex, iteration conter and the index values in a neat fashion.

	static public void print(int position, int minindex, int count, int iterationcounter, int array[])
		{

			System.out.println();
			System.out.println("Iteration Number: " + iterationcounter + " | Position Index: " + position + " | Minimum Index: " + minindex);
			for (int i = 0; i < count; i++)
				{
					System.out.print(array[i] + " ");
					if ((i + 1) % 43 == 0)
						{
							System.out.println();
							for (int j = 0; j < count; j++)
								{
									System.out.print(j + "  ");
								}
						}
				}

			System.out.println();
		}

//  Sorting Algorithm - Selection Sort

	static public void sort(int array[], int count, int iterationcounter)
		{

//  Step 1: Initialize the variables

			int position = 0;
			int minindex = position;
			int walker = position;

			while (position < count)
				{

//  Step 2: Increment walker (did at end of while loop rather than beginning -- no noticable difference

					while (walker < count)
						{

//  Step 3: Compare array[minindex] with array[walker], if array[walker] < array[minindex], minindex = walker

							if (array[minindex] > array[walker])
								{
									minindex = walker;
								}
							walker++;
						}

//  Step 4: Repeat steps 2-3 untill walker < counter

//  Step 5: Perform swap between array[minindex] and array[position]

					int temp = array[position];
					array[position] = array[minindex];
					array[minindex] = temp;

//  Print out iteration display

					print(position, minindex, count, iterationcounter, array);

//  Step 6: Increment position, set walker to position and minindex to position

					iterationcounter++;

					position++;
					walker = position;
					minindex = position;

//  Step 7: Repeat steps 2-6 untill position >= counter;
				}
		}
}
