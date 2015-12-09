//
//  InsertionSort.cpp
//  Project 2 C++
//
//  Created by Alexandru Gutu on 9/29/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

using namespace std;

#include <iostream>
#include <fstream>

void insertionsort(int array[], int data);

	// Initialize variables
int counter = 0;
int dummydata;

string userinput;

int main()
{
	// Ask user for file location
	cout << "What is the name of the input file: " << endl;
	getline(cin, userinput);
	
	// Open file
	ifstream fileinput;
	fileinput.open(userinput);
	
	// Check if file is found
	if (!fileinput)
	{
		cout << "Can't open input file " << userinput << endl;
		return 0;
	}
	
	cout << endl;
	
	// Import data into array
	while (!fileinput.eof())
	{
		fileinput >> dummydata;
		counter++;
	}
	
	// Initialize an array of size counter
	int *array = new int[counter];

	fileinput.close();
	
	// Call insertion sort function
	insertionsort(array, counter);
	
	return 0;
}

void insertionsort(int array[], int counter)
{
	ifstream fileinput;
	fileinput.open(userinput);
	
	int data = 0;
	int last = 0;
	int index;

	fileinput >> data;
	array[last] = data;

	while (!fileinput.eof())
	{
		int spot = 0;
		
		fileinput >> data;
		
		last++;
		index = last;

		while (array[spot] < data)
		{
			spot++;
			if (spot > last)
			{
				spot = last;
				break;
			}
		}
		
		while (index > spot)
		{
			array[index] = array[index - 1];
			index--;
		}

		array[spot] = data;

		// Print iterations sort
		cout << "Last: " << last << " Data: " << data << " Spot: " << spot << endl;
		for (int i = 0; i <= last; i++)
		{
			cout << array[i] << " ";
		}
		cout << endl;
		cout << endl;
		
	}
	
}