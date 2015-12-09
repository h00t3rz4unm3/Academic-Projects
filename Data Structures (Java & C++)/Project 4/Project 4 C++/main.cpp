//
//  main.cpp
//  Project 4 C++
//
//  Created by Alexandru Gutu on 11/14/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//	www.thegutuproject.com
//

#include "BinarySearchTree.h"
#include <fstream>

using namespace std;

BinarySearchTree *BST = new BinarySearchTree();

string userInput;
string dataInput;
string eoftest;

char operation;

int main()
{
	// File Input
	cout << "What is the name of the input file: " << endl;
	getline(cin, userInput);
	
	ifstream datafile;
	datafile.open(userInput);
	
	if (!datafile)
	{
		cout << "Can't open input file " << userInput << endl;
		return 0;
	}
	
	// Taking data in from the file
	while (datafile >> operation)
	{
		Node *current = BST->getRoot();
	
		if (operation != 'p')
		{
		// Insert data
			datafile >> dataInput;
			if (operation == '+')
			{
				BST->insert(current, stoi(dataInput));
			}
		
		// Search for data
			else if (operation == '*')
			{
				BST->search(stoi(dataInput));
			}
			else
			{
				cout << "Unrecognized operation. Please check input file and try again" << endl;
			}
		}
	
	// Print data
		else if (operation == 'p')
		{
			BST->printFormat("in");
		}
		else
		{
			cout << "Unrecognized operation. Please check input file and try again" << endl;
		}
		
	}
	
	
    return 0;
}
