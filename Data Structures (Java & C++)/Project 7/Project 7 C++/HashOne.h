//
//  HashOne.h
//  Project 7 C++
//
//  Created by Alexandru Gutu on 12/1/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_7_C____HashOne__
#define __Project_7_C____HashOne__

#include <stdio.h>
#include "Node.h"

class HashOne
{

private:
	Node **bucketList;
	int bucketSize;
	
public:
	HashOne(int bucketSize);
	int hashOneFunction(int data);
	Node *findSpot(int data);
	
	void insert(int data);
	
	void printList(int data);
	void printHashTable();
	
};

#endif /* defined(__Project_7_C____HashOne__) */
