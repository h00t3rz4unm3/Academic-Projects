//
//  Node.h
//  Project 3 C++
//
//  Created by Alexandru Gutu on 10/18/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_3_C____Node__
#define __Project_3_C____Node__

#include <stdio.h>

using namespace std;

// Node prototype/definition
class Node
{
// Node data
private:
	string data;
	int count;
	Node* next;
	
// Node functions
public:
	Node(string input);
	
	Node(string input, Node* next);
	
	string getData();
	
	Node* getNext();
	
	int getCounter();
	
	void setData(string input);
	
	void setNext(Node* next);
	
	void increaseCount();
	
	~Node();
};

#endif /* defined(__Project_3_C____Node__) */
