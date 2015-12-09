/**
 * Created by Alexandru Gutu on 10/17/14.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 *
 * Use a linked list (Node: word, count, next node)
 * Use insertion sort to sort/count the words in a text file
 * Text file will have words
 * Each time a word is read, add to the linked list. If the word is already there, then increment the counter by 1.
 * Display the entire linked list after.
 */

import java.io.*;
import java.util.Scanner;

public class Main
	{
		public static void main(String[] args) throws FileNotFoundException
			{
				// Step 0: Initialize everything needed
				Scanner userinput = new Scanner(System.in);
				System.out.println("What is the name of the input file: ");
				String fileinput = userinput.nextLine();

				try
					{
						Scanner firstreading = new Scanner(new FileReader(fileinput));

						// Step 1: Create a Linked List with a dummy Node
						LinkedList wordlist = new LinkedList();

						while (firstreading.hasNext())
							{
								// Step 2: Obtain data from data file
								wordlist.insert(firstreading.next());
							}

						wordlist.listPrint();

					}

				catch (FileNotFoundException e)
					{
						System.out.println("File not found!");
					}

				System.out.println();
			}
	}
