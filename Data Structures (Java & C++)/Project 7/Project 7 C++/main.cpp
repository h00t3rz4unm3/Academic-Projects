//
//  main.cpp
//  Project 7 C++
//
//  Created by Alexandru Gutu on 11/23/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <fstream>

#include "HashOne.h"
#include "HashTwo.h"
#include "HashThree.h"

using namespace std;

ifstream fileInput;

string fileLocation;

int bucketSize;
int hashData;
int userChoice = 0;

bool validOption = true;

int main() {
	
	// Step 0: Prepare everything
	cout << "What is the location of the first input file: " << endl;
	getline(cin, fileLocation);
	
	// Step 1: Attempt to open file
	fileInput.open(fileLocation);
	
	if (!fileInput)
		{
			cout << "Can't open input file " << fileLocation << endl;
			return 0;
		}
	
	cout << endl;
	cout << "Hast One: Data % Number of Buckets:" << endl;
	cout << "Hash Two: Sum of digits in Data % Number of Buckets" << endl;
	cout << "Hash Three: Sum of digits in Data modified by 32 % Number of Buckets" << endl;

	// Step 2: Ask user for bucket size
	cout << endl;
	cout << "Bucket Size: " << endl;
	cin >> bucketSize;

	cout << endl;
	
	// Step 3: Ask user which Hash Function to use
	cout << "Please pick a Hash Function to use (1 - 3)" << endl;
	cout << "Hash Function: ";

	while (validOption)
		{
			cin >> userChoice;
		
			// Step 4: Depending on which function the user choose, run respective code
			switch (userChoice)
			{
				case 1:
				{
					// Step 5: Dynamically allocate bucket size
					HashOne hashOne = *new HashOne(bucketSize);
					cout << endl;
				
					// Step 6: Print entire Hash Table
					while (fileInput >> hashData)
						{
							hashOne.insert(hashData);
							hashOne.printList(hashData);
						}
					
					hashOne.printHashTable();
					validOption = false;
				}
				break;
				
				case 2:
				{
					// Step 5: Dynamically allocate bucket size
					HashTwo hashTwo = *new HashTwo(bucketSize);
					cout << endl;
				
					// Step 6: Print entire Hash Table
					while (fileInput >> hashData)
						{
							hashTwo.insert(hashData);
							hashTwo.printList(hashData);
						}
					
					hashTwo.printHashTable();
					validOption = false;
					break;
				}
				
				case 3:
				{
					// Step 5: Dynamically allocate bucket size
					HashThree hashThree = *new HashThree(bucketSize);
					cout << endl;
				
					// Step 6: Print entire Hash Table
					while (fileInput >> hashData)
						{
							hashThree.insert(hashData);
							hashThree.printList(hashData);
						}
					
					hashThree.printHashTable();
					validOption = false;
					break;
				}
				
				default:
				{
					cout << endl;
					cout << "Incorrect input, please pick a Hash Function to use (1 - 3): ";
				}
			}
		}
	
	return 0;
}

