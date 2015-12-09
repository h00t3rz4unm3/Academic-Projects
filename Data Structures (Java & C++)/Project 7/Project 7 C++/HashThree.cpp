//
//  HashThree.cpp
//  Project 7 C++
//
//  Created by Alexandru Gutu on 12/1/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include "HashThree.h"

HashThree::HashThree(int bucketSize)
{
	bucketList = new Node*[bucketSize];
	for (int i = 0; i < bucketSize; i++)
		{
		bucketList[i] = new Node(99999999);
		}
	this->bucketSize = bucketSize;
}

// Hash Function
int HashThree::hashThreeFunction(int data)
{
	string dataString = to_string(data);
	
	int dataValue = 0;
	for (int i = 0; i < dataString.length(); i++)
		{
			dataValue = dataValue * 32 + (int)dataString[i];
		}
	
	int hash = dataValue % bucketSize;
	
	return hash;
}

// Search Function
Node *HashThree::findSpot(int data)
{
	int bucketIndex = hashThreeFunction(data);
	
	Node *current = bucketList[bucketIndex];
	
	while (current->getNext() != NULL && current->getNext()->getData() < data)
		{
			current = current->getNext();
		}
	
	if (current->getNext() != NULL && current->getNext()->getData() == data)
		{
			return nullptr;
		}
	else
		{
			return current;
		}
}

// Insert Function
void HashThree::insert(int data)
{
	if (findSpot(data) == nullptr)
		{
			cout << "Unable to insert, " << data << " is already present." << endl;
		}
	else
		{
			Node *current = findSpot(data);
		
			Node* newNode = new Node(data);
			newNode->setNext(current->getNext());
			current->setNext(newNode);
		}
}


// Print Function
void HashThree::printList(int data)
{
	int bucketIndex = hashThreeFunction(data);
	
	cout << "Hash Bucket " << bucketIndex << ": " << endl;
	
	Node *current = bucketList[bucketIndex];
	
	while (current->getNext() != NULL)
		{
			cout << current->getData() << " ";
			current = current->getNext();
		}
	
	cout << current->getData() << endl << endl;
	
}

// Hash Table Print Function
void HashThree::printHashTable()
{
	for (int i = 0; i < bucketSize; i++)
		{
		cout << "Hash Bucket " << i << ": ";
		
		Node *current = bucketList[i];
		
		while (current->getNext() != NULL)
			{
				cout << current->getData() << " ";
				current = current->getNext();
			}
		
		cout << current->getData() << endl;
		}
}