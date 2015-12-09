//
//  main.cpp
//  Project 5 C++
//
//  Created by Alexandru Gutu on 11/12/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <fstream>

using namespace std;

// Prepare everything
string userInput;
int temp;
int counter = 0;
int *PQT;

void bubbleUp(int index);
void bubbleDown(int index);
void swap(int parent, int child);


int main()
{
	
	cout << "What is the name of the input file: " << endl;
	getline(cin, userInput);
	
	ifstream readingCount;
	readingCount.open(userInput);
	
	if (!readingCount)
	{
		cout << "Can't open input file " << userInput << endl;
		return 0;
	}
	
	PQT = new int[counter + 1];
	
	while (!readingCount.eof())
	{
		// Read data file to get count
		readingCount >> PQT[counter + 1];
		counter++;
	}
	
	readingCount.close();
	
	// Input data into array
	for (int i = 1; i < counter; i++)
	{
		bubbleUp(i);
		PQT[0]++;
	}
	
	cout << "Before Heap Sort: " << endl;
	
	for (int i = 1; i < counter; i++)
	{
		cout << PQT[i] << " ";
	}
	
	cout << endl;
	
	cout << "After Heap Sort: " << endl;
	
	// Run bubbleDown, performing the sort
	for (int i = counter - 1; i >= 1; i--)
	{
		cout << PQT[1] << " ";
		PQT[1] = PQT[i];
		bubbleDown(i);
		PQT[0]--;
	}

	cout << endl;
	
	return 0;
}

// BubbleUp function
void bubbleUp(int index)
{
	// Compare the data coming in with the parent node, if parent is bigger, swap
	while (index >= 1 && PQT[index] < PQT[index/2])
	{
		swap(index, index/2);
		index = index/2;
	}
}

// BubbleDown function
void bubbleDown(int lastIndex)
{
	int index = 1;
	int leftChild = 2 * index;
	int rightChild = (2 * index) + 1;
	int swapTarget = 0;
	
	// Case 1: Father has two children
	while(PQT[index] > PQT[swapTarget] || !(leftChild > lastIndex && rightChild > lastIndex))
	{
		leftChild = 2 * index;
		rightChild = (2 * index) + 1;
		
		if(rightChild <= lastIndex)
		{
			// Compare children
			if (PQT[leftChild] < PQT[rightChild])
			{
				swapTarget = leftChild;
			}
			else
			{
				swapTarget = rightChild;
			}
		}
		
		// Case 2: Father only has left child
		else if(leftChild <= lastIndex && rightChild > lastIndex)
		{
			swapTarget = leftChild;
		}
		
		// Swap current location with smallest
		if (swapTarget <= lastIndex && PQT[swapTarget] < PQT[index])
		{
			swap(index, swapTarget);
		}

		// Set current location to swapped target
		index = swapTarget;
	}
}

// Swap function
void swap(int parent, int child)
{
	int temp = PQT[parent];
	PQT[parent] = PQT[child];
	PQT[child] = temp;
}





