/**
 * Project Name: Project 4 Java
 * Created by Alexandru Gutu on 11/1/2014.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */

public class BinarySearchTree
	{
		private Node root;

		// BST Constructor with significantly large dummy node
		public BinarySearchTree()
			{
				root = new Node(999999999);
			}

		// Returns the root of the BST
		public Node getRoot()
			{
				return root;
			}

		public void insert(Node current, int data)
			{
			// Case 1: Data matches
			if (current.getData() == data)
				{
					System.out.println("Unable to insert, duplicate data [" + data + "]");
					System.out.println();
				}

			// Case 2: Incoming data is less than current node's data
			else if (current.getData() > data)
				{
					if (current.getLeft() == null)
						{
							current.setLeft(new Node(data));
							return;
						}
					else
						{
							insert(current.getLeft(), data);
						}
				}

			// Case 3: Incoming data is more than current node's data
			else if (current.getData() < data)
				{
					if (current.getRight() == null)
						{
							current.setRight(new Node(data));
							return;
						}
					else
						{
							insert(current.getRight(), data);
						}
				}
			}

		// Search for data
		public void search(int data)
			{
				Node current = root.getLeft();

				boolean isFound = false;

				System.out.println();
				System.out.println("Search Steps for " + data);

				while (current != null)
					{
						current.printData();

						if (current.getData() == data)
							{
								System.out.println("Node of value " + data + " has been found.");
								System.out.println();
								isFound = true;
								break;
							}
						else
							{
								if (current.getData() > data)
									{
										current = current.getLeft();
									}
								else
									{
										current = current.getRight();
									}
							}
					}

				if (!isFound)
					{
						System.out.println("The node of value " + data + " has not been found");
						System.out.println();
					}
			}

		// Printing in Pre, In, Post order (All 3 are kept for archiving sake)
		public void printFormat(String format)
			{

				Node current = root.getLeft();

				if (format.equals("pre"))
					{
						preOrder(current);
					}
				else if (format.equals("in"))
					{
						inOrder(current);
					}
				else if (format.equals("post"))
					{
						postOrder(current);
					}
				else
					{
						System.out.println("Unknown operation modifier! Please check input file and try again");
					}
			}

		public void preOrder(Node current)
			{
				if (current == null)
					{
						return;
					}

				current.printData();

				preOrder(current.getLeft());
				preOrder(current.getRight());
			}

		public void inOrder(Node current)
			{
				if (current == null)
					{
						return;
					}

				preOrder(current.getLeft());
				current.printData();
				preOrder(current.getRight());
			}

		public void postOrder(Node current)
			{
				if (current == null)
					{
						return;
					}

				postOrder(current.getLeft());
				postOrder(current.getRight());
				current.printData();
			}
	}
