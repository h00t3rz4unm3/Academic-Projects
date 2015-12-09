//
//  LinkedList.h
//  Project 3 C++
//
//  Created by Alexandru Gutu on 10/18/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_3_C____LinkedList__
#define __Project_3_C____LinkedList__

#include <stdio.h>
#include "Node.h"

using namespace std;

// Linked List function prototype/definition
class LinkedList
{
// Linked List variables
private:
	Node* head;
	
// Linked List functions
public:
	LinkedList();
	void insert(string input);
	void printList();
	~LinkedList();
};

#endif /* defined(__Project_3_C____LinkedList__) */
