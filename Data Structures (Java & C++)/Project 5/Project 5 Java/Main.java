import java.io.FileNotFoundException;

/**
 * Created by Alexandru Gutu on 11/7/14.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */

import java.util.*;
import java.io.*;

public class Main
	{
		public static void main(String[] args) throws FileNotFoundException
			{

				// Prepare everything
				Scanner userInput = new Scanner(System.in);
				System.out.println("What is the name of the input file: ");
				String fileLocation = userInput.nextLine();

				try
					{
						Scanner readingCount = new Scanner(new FileReader(fileLocation));

						int temp;
						int count = 1;

						// Read data file to get count
						while (readingCount.hasNextInt())
							{
								readingCount.nextInt();
								count++;
							}

						readingCount.close();

						// Make new array of size count
						int[] PQT = new int[count];

						Scanner inputRead = new Scanner(new FileReader(fileLocation));

						// Import data from File, bubbleUp
						for (int i = 1; i < count; i++)
							{
								PQT[i] = inputRead.nextInt();
								bubbleUp(PQT, i);
								PQT[0]++;
							}

						System.out.println("Before Heap Sort:");

						for (int i = 1; i < count; i++)
							{
								System.out.print(PQT[i] + " ");

							}

						System.out.println();

						System.out.println("After Heap Sort");

						// Run bubbleDown, performing the sort
						for (int i = count - 1; i >= 1; i--)
							{
								System.out.print(PQT[1] + " ");
								PQT[1] = PQT[i];
								bubbleDown(PQT, i);
								PQT[0]--;
							}
					}

				catch (FileNotFoundException e)
					{
						System.out.println("File not found!");
					}

				System.out.println();
			}

		// BubbleUp function
		static void bubbleUp(int[] PQT, int index)
			{
			int temp;

			// Compare the data coming in with the parent node, if parent is bigger, swap
			while (index >= 1 && PQT[index] < PQT[index/2])
				{
				swap(PQT, index, index/2);
				index = index/2;
				}
			}

		// BubbleDown function
		static void bubbleDown(int[] PQT, int lastIndex)
			{
				int index = 1;
				int leftChild = 2 * index;
				int rightChild = (2 * index) + 1;
				int swapTarget = 0;

				// Case 1: Father has two children
				while(PQT[index] > PQT[swapTarget] || !(leftChild > lastIndex && rightChild > lastIndex))
					{
						leftChild = 2 * index;
						rightChild = (2 * index) + 1;

						if(rightChild <= lastIndex)
							{

								// Compare children
								if (PQT[leftChild] < PQT[rightChild])
									{
										swapTarget = leftChild;
									}
								else
									{
										swapTarget = rightChild;
									}
							}

						// Case 2: Father only has left child
						else if(leftChild <= lastIndex && rightChild > lastIndex)
							{
								swapTarget = leftChild;
							}

						// Swap current location with smallest
						if (swapTarget <= lastIndex && PQT[swapTarget] < PQT[index])
							{
								swap(PQT, index, swapTarget);
							}

						// Set current location to swapped target
						index = swapTarget;
					}

			}
		// Swap function
		static void swap(int[] PQT, int parent, int swapTarget)
		{
			int temp = PQT[parent];
			PQT[parent] = PQT[swapTarget];
			PQT[swapTarget] = temp;
		}
	}
