/**
 * Project Name: Project 4 Java
 * Created by Alexandru Gutu on 11/1/2014.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */

import java.io.*;
import java.util.Scanner;

public class Main
	{
		public static void main(String[] args) throws FileNotFoundException
			{
				// File Input
				BinarySearchTree BST = new BinarySearchTree();
				String datainput;
				char operation;

				Scanner userinput = new Scanner(System.in);
				System.out.println("What is the name of the input file: ");
				String fileLocation = userinput.nextLine();

				try
					{
						Scanner datafile = new Scanner(new FileReader(fileLocation));

						// Taking data in from the file
						while (datafile.hasNext())
							{
								Node current = BST.getRoot();

								operation = datafile.next().charAt(0);
								if (operation != 'p')
									{
										// Insert data
										datainput = datafile.next();
										if (operation == '+')
											{
												BST.insert(current, Integer.parseInt(datainput));
											}

										// Search for data
										else if (operation == '*')
											{
												BST.search(Integer.parseInt(datainput));
											}
										else
											{
												System.out.println("Unrecognized operation. Please check input file and try again");
											}
									}

								// Print data
								else if (operation == 'p')
									{
										BST.printFormat("in");
									}
								else
									{
										System.out.println("Unrecognized operation. Please check input file and try again");
									}
							}

					}

				catch (FileNotFoundException e)
					{
						System.out.println("File not found!");
					}
			}
	}
