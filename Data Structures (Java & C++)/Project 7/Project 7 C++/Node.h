//
//  Node.h
//  Project 7 C++
//
//  Created by Alexandru Gutu on 11/23/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_7_C____Node__
#define __Project_7_C____Node__

#include <stdio.h>
#include <iostream>

using namespace std;

class Node
{
private:
	int data;
	Node* nextNode;
	
public:
	Node(int data);
	Node(int data, Node* next);
	
	int getData();
	Node* getNext();
	
	void setNext(Node* next);
};

#endif /* defined(__Project_7_C____Node__) */
