/**
 * Created by Alexandru Gutu on 12/1/14.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */

import java.io.*;
import java.util.*;

public class main
	{
		public static void main(String[] args)
			{

				// Step 0: Prepare everything
				Scanner userInput = new Scanner(System.in);

				System.out.println("What is the location of the hash data file: ");
				String fileLocation = userInput.nextLine();

				int userChoice;
				int bucketSize;
				int data;
				boolean validOption = true;

				// Step 1: Attempt to open file
				try
					{
						Scanner fileReading = new Scanner(new FileReader(fileLocation));

						System.out.println();
						System.out.println("Hast One: Data % Number of Buckets:");
						System.out.println("Hash Two: Sum of digits in Data % Number of Buckets");
						System.out.println("Hash Three: Sum of digits in Data modified by 32 % Number of Buckets");

						// Step 2: Ask user for bucket size
						System.out.println();
						System.out.println("Bucket Size: ");
						bucketSize = userInput.nextInt();

						// Step 3: Ask user which Hash Function to use
						System.out.println();
						System.out.println("Please pick a Hash Function to use (1 - 3)");

						System.out.println();
						System.out.println("Hash Function: ");

						while (validOption)
							{
								userChoice = Integer.parseInt(userInput.next());

								// Step 4: Depending on which function the user choose, run respective code
								switch(userChoice)
									{
										case 1:
										{
											// Step 5: Dynamically allocate bucket size
											HashOne hashOne = new HashOne(bucketSize);
											System.out.println();

											// Step 6: Print entire Hash Table
											while (fileReading.hasNextInt())
												{
													data = fileReading.nextInt();
													hashOne.insert(data);
													hashOne.printList(data);
												}

											hashOne.printHashTable();
											validOption = false;
											break;
										}

										case 2:
										{
											// Step 5: Dynamically allocate bucket size
											HashTwo hashTwo = new HashTwo(bucketSize);
											System.out.println();

											// Step 6: Print entire Hash Table
											while (fileReading.hasNextInt())
												{
													data = fileReading.nextInt();
													hashTwo.insert(data);
													hashTwo.printList(data);
												}

											hashTwo.printHashTable();
											validOption = false;
											break;
										}

										case 3:
										{
											// Step 5: Dynamically allocate bucket size
											HashThree hashThree = new HashThree(bucketSize);
											System.out.println();

											// Step 6: Print entire Hash Table
											while (fileReading.hasNextInt())
												{
													data = fileReading.nextInt();
													hashThree.insert(fileReading.nextInt());
													hashThree.printList(data);
												}

											hashThree.printHashTable();
											validOption = false;
											break;
										}

										default:
										{
											System.out.println();
											System.out.print("Incorrect input, please pick a Hash Function to use (1 - 3): ");
										}
									}
							}

						fileReading.close();

					}

				catch (FileNotFoundException e)
					{
						System.out.println("File not found!");
					}
			}
	}
