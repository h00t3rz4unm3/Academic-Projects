//
//  LinkedList.cpp
//  Project 3 C++
//
//  Created by Alexandru Gutu on 10/18/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include "LinkedList.h"

using namespace std;
// Linked List function definitions
// Constructor creates a dummy node automatically
LinkedList::LinkedList()
{
	head = new Node("Dummy Node");
}

void LinkedList::insert(string input)
{
	// Step 3: Set walker to listHead
	Node* walker = head;
	
	// Step 4: Compare if the current Node is less than the currently loaded data. If so, move walker to next Node
	while (walker->getNext() != NULL && walker->getNext()->getData() < input)
	{
		walker = walker->getNext();
	}
	// Step 5: Repeat Step 4 untill condition fails

	// Step 6: Check if currently loaded data is equal to the data of the next Node. Increment count if they match
	if (walker->getNext() != NULL && walker->getNext()->getData() == input)
	{
		walker->getNext()->increaseCount();
	}
	else
	{
	// Step 7: If condition fails, create a new Node with the data, increment counter to 1, and insert it after walker
		Node* newNode = new Node(input);
		newNode->setNext(walker->getNext());
		walker->setNext(newNode);
	}
}

// Print out all Nodes
void LinkedList::printList()
{
	Node* walker = head;
	
	int counter = 1;
	
	cout << "The dummy node has been omitted from printing for obvious reasons" << endl;
	
	while (walker->getNext() != NULL)
	{
		walker = walker->getNext();
		
		cout << "Node: " << counter << " | Count: " << walker->getCounter() << " | Word: " << walker->getData() << endl;
		
		counter++;
	}
}



