/**
 * Created by Alexandru Gutu on 10/18/14.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */

// Linked List function definitions and declaration
public class LinkedList
	{
		private Node head;

		// Constructor creates a dummy node automatically
		public LinkedList()
			{
				head = new Node("Dummy Node");
			}

		public void insert(String input)
			{
				// Step 3: Set walker to listHead
				Node walker = head;

				// Step 4: Compare if the current Node is less than the currently loaded data. If so, move walker to next Node
				while (walker.getNext() != null && walker.getNext().getData().compareTo(input) < 0)
					{
						walker = walker.getNext();
					}
				// Step 5: Repeat Step 4 untill condition fails

				// Step 6: Check if currently loaded data is equal to the data of the next Node. Increment count if they match
				if (walker.getNext() != null && walker.getNext().getData().equals(input))
					{
						walker.getNext().increaseCount();
					}
				else
					{
						// Step 7: If condition fails, create a new Node with the data, increment counter to 1, and insert it after walker
						Node newNode = new Node(input);
						newNode.setNext(walker.getNext());
						walker.setNext(newNode);
					}
			}

		// Print out all Nodes
		public void listPrint()
			{
				Node walker = head;

				int counter = 1;

				System.out.println("The dummy node has been omitted from printing for obvious reasons.");

				while (walker.getNext() != null && counter < 18)
					{
						walker = walker.getNext();

						System.out.println("(" + walker.getData() + ", " + walker.getCounter() + ", " + walker.getNext().getData() + ")");
						counter++;
					}

			}

	}
