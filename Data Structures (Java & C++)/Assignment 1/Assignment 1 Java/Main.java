/**
 *
 * Main.java
 * Assignment 1
 *
 * Created by Alexandru Gutu on 9/6/2014.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 *
 * Objectives:
 * Suppose we are given a data file (data1.txt) which contains integers. We are interested to know:
 * 1) How many integers are in data1.txt
 * 2) The largest integer in data1.txt
 * 3) The smallest integer in data1.txt
 * 4) The average of all integers in data1.txt
 *
 */

// Step 1: Prepare program by importing specific libraries

import java.io.*;
import java.util.Scanner;

public class Main
	{
		 public static void main(String[] args) throws FileNotFoundException
			{

// Step 2: Initializing variables and opening the data file.

				int sum = 0;
				int counter = 0;
				int lowest = 0;
				int highest = 0;
				int input = 0;
                double average = 0.0;
				
				// Assuming input file will be stored in /data (relative to source file)
				Scanner inFile = new Scanner(new FileReader("data/data1.txt"));

// Step 3: Reading in data from the data file

				while (inFile.hasNextInt())
					{
// Step 4: Assume data is integer, therefore process data and perform functions needed

						input = inFile.nextInt();
						counter++;
						sum += input;
						if (input > highest)
							{
								highest = input;
							}
						else if (input < lowest)
							{
								lowest = input;
							}

                        average = (double) sum/counter;
					}

// Step 5: Repeat steps 3-4 until all data is read (while loop)

// Step 6: Display the needed results

				System.out.println("There are " + counter + " integers");
				System.out.println("The average is " + average);
				System.out.println("The highest integer is " + highest);
				System.out.println("The lowest integer is " + lowest);
			}
	}
