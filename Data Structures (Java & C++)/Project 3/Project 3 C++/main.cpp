//
//  main.cpp
//  Project 3 C++
//
//  Created by Alexandru Gutu on 10/18/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//
//	Use a linked list (Node: word, count, next node)
//	Use insertion sort to sort/count the words in a text file
//	Text file will have words
//	Each time a word is read, add to the linked list. If the word is already there, then increment the counter by 1.
//	Display the entire linked list after.
//

#include <iostream>
#include <fstream>
#include "Node.h"
#include "LinkedList.h"

using namespace std;

// Step 0: Initialize everything needed
string userinput;
string input;

int main()
{
	cout << "What is the name of the input file: " << endl;
	getline(cin, userinput);
	
	ifstream fileinput;
	fileinput.open(userinput);
	
	if (!fileinput)
	{
		cout << "Can't open input file " << userinput << endl;
		return 0;
	}
	
	// Step 1: Create a Linked List with a dummy Node
	LinkedList* wordlist = new LinkedList();
	
	while (!fileinput.eof())
	{
		// Step 2: Obtain data from data file
		fileinput >> input;

		wordlist->insert(input);
	}
	cout << endl;
	
	wordlist->printList();
	
	cout << endl;
	
	
    return 0;
}
