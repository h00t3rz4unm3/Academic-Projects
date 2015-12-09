//
//  HashTwo.h
//  Project 7 C++
//
//  Created by Alexandru Gutu on 12/1/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_7_C____HashTwo__
#define __Project_7_C____HashTwo__

#include <stdio.h>
#include <cmath>
#include "Node.h"


class HashTwo
{
	
private:
	Node **bucketList;
	int bucketSize;
	
public:
	HashTwo(int bucketSize);
	int hashTwoFunction(int data);
	Node *findSpot(int data);
	
	void insert(int data);
	
	void printList(int data);
	void printHashTable();
	
	int sumOfDigits(int data);
};

#endif /* defined(__Project_7_C____HashTwo__) */
