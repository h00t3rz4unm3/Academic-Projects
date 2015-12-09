//
//  HashOne.cpp
//  Project 7 C++
//
//  Created by Alexandru Gutu on 12/1/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include "HashOne.h"

HashOne::HashOne(int bucketSize)
{
	bucketList = new Node*[bucketSize];
	for (int i = 0; i < bucketSize; i++)
		{
			bucketList[i] = new Node(99999999);
		}
	this->bucketSize = bucketSize;
}

// Hash Function
int HashOne::hashOneFunction(int data)
{
	int hash = data % bucketSize;

	return hash;
}

// Search Function
Node *HashOne::findSpot(int data)
{
	int bucketIndex = hashOneFunction(data);
	
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
void HashOne::insert(int data)
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
void HashOne::printList(int data)
{
	int bucketIndex = hashOneFunction(data);
	
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
void HashOne::printHashTable()
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