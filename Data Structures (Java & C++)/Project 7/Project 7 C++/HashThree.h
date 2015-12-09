//
//  HashThree.h
//  Project 7 C++
//
//  Created by Alexandru Gutu on 12/1/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_7_C____HashThree__
#define __Project_7_C____HashThree__

#include <stdio.h>
#include <cmath>
#include "Node.h"

class HashThree
{
	
private:
	Node **bucketList;
	int bucketSize;
	
public:
	HashThree(int bucketSize);
	int hashThreeFunction(int data);
	Node *findSpot(int data);
	
	void insert(int data);
	
	void printList(int data);
	void printHashTable();
	
};

#endif /* defined(__Project_7_C____HashThree__) */
