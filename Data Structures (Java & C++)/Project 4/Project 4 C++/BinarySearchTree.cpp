//
//  BinarySearchTree.cpp
//  Project 4 C++
//
//  Created by Alexandru Gutu on 11/14/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include "BinarySearchTree.h"

// BST Constructor with significantly large dummy node
BinarySearchTree::BinarySearchTree()
{
	root = new Node(999999999);
}

// Returns the root of the BST
Node *BinarySearchTree::getRoot()
{
	return root;
}

void BinarySearchTree::insert(Node *current, int data)
{
	bool done = false;
	
	// Case 1: Data matches
	if (current->getData() == data)
	{
		cout << "Unable to insert, duplicate data [" << data << "]" << endl;
		cout << endl;
	}
	
	// Case 2: Incoming data is less than current node's data
	else if (current->getData() > data)
	{
		if (current->getLeft() == nullptr)
		{
			current->setLeft(new Node(data));
			done = true;
		}
		else
		{
			insert(current->getLeft(), data);
		}
	}
	
	// Case 3: Incomign data is larger than current node's data
	else if (current->getData() < data)
	{
		if (current->getRight() == nullptr)
		{
			current->setRight(new Node(data));
			done = true;
		}
		else
		{
			insert(current->getRight(), data);
		}
	}
}

// Search for data
void BinarySearchTree::search(int data)
{
	Node *current = root->getLeft();
	
	bool isFound = false;
	
	cout << endl;
	cout << "Search steps for " << data << endl;
	
	while (current != nullptr)
	{
		current->printData();
		
		if (current->getData() == data)
		{
			cout << "Node of value " << data << " has been found." << endl;
			cout << endl;
			isFound = true;
			break;
		}
		else
		{
			if (current->getData() > data)
			{
				current = current->getLeft();
			}
			else
			{
				current = current->getRight();
			}
		}
	}
	
	if (isFound == false)
	{
		cout << "The node of value " << data << " has not been found" << endl;
		cout << endl;
	}
}

// Printing in Pre, In, and Post order (all 3 are kept for archiving sake)
void BinarySearchTree::printFormat(string format)
{
	Node *current = root->getLeft();
	
	if (format == "pre")
	{
		preOrder(current);
	}
	else if (format == "in")
	{
		inOrder(current);
	}
	else if (format == "post")
	{
		postOrder(current);
	}
	else
	{
		cout << "Unknown operation modifier! Please check input file and try again" << endl;
	}
}

void BinarySearchTree::preOrder(Node *current)
{
	if (current == nullptr)
	{
		return;
	}
	
	current->printData();
	preOrder(current->getLeft());
	preOrder(current->getRight());
}

void BinarySearchTree::inOrder(Node *current)
{
	if (current == nullptr)
	{
		return;
	}
	
	preOrder(current->getLeft());
	current->printData();
	preOrder(current->getRight());
}

void BinarySearchTree::postOrder(Node *current)
{
	if (current == nullptr)
	{
		return;
	}
	
	preOrder(current->getLeft());
	preOrder(current->getRight());
	current->printData();
}