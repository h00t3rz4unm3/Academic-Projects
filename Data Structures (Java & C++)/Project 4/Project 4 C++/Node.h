//
//  Node.h
//  Project 4 C++
//
//  Created by Alexandru Gutu on 11/14/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_4_C____Node__
#define __Project_4_C____Node__

#include <stdio.h>
#include <iostream>

class Node
{
private:
	int data;
	Node *left;
	Node *right;
	
public:
	Node(int data);
	
	const int getData();
	Node *getLeft();
	Node *getRight();
	
	void setData(int input);
	void setLeft(Node *nextLeft);
	void setRight(Node *nextRight);
	
	void printData();
};


#endif /* defined(__Project_4_C____Node__) */
