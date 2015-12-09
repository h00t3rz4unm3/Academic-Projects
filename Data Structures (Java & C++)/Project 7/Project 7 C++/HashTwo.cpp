//
//  HashTwo.cpp
//  Project 7 C++
//
//  Created by Alexandru Gutu on 12/1/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include "HashTwo.h"

HashTwo::HashTwo(int bucketSize)
{
	bucketList = new Node*[bucketSize];
	
	for (int i = 0; i < bucketSize; i++)
		{
			bucketList[i] = new Node(99999999);
		}
	
	this->bucketSize = bucketSize;
}

// Hash Function
int HashTwo::hashTwoFunction(int data)
{
	int hash = sumOfDigits(data) % bucketSize;
	
	return hash;
}

// Search Function
Node *HashTwo::findSpot(int data)
{
	int bucketIndex = hashTwoFunction(data);
	
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
void HashTwo::insert(int data)
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
void HashTwo::printList(int data)
{
	int bucketIndex = hashTwoFunction(data);
	
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
void HashTwo::printHashTable()
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

int HashTwo::sumOfDigits(int data)
{
	if (data < 10)
		{
			return data;
		}
	
	int sum = 0;
	
	while (data > 0)
		{
			sum += data % 10;
			data = data / 10;
		}

	return sumOfDigits(sum);
}