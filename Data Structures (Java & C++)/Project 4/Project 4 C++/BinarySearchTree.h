//
//  BinarySearchTree.h
//  Project 4 C++
//
//  Created by Alexandru Gutu on 11/14/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_4_C____BinarySearchTree__
#define __Project_4_C____BinarySearchTree__

#include <stdio.h>
#include "Node.h"

using namespace std;

class BinarySearchTree
{
private:
	Node *root;
	
public:
	BinarySearchTree();
	
	Node *getRoot();
	
	
	void insert(Node *current, int data);
	
	void search(int data);
	
	void printFormat(string format);
	
	
	void preOrder(Node *current);
	
	void inOrder(Node *current);
	
	void postOrder(Node *current);
	
};

#endif /* defined(__Project_4_C____BinarySearchTree__) */
