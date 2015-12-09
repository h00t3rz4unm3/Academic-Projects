//
//  Node.cpp
//  Project 3 C++
//
//  Created by Alexandru Gutu on 10/18/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include "Node.h"

using namespace std;

// Node function definitions
Node::Node(string input)
{
	this->data = input;
	this->count = 1;
}

Node::Node(string input, Node* next)
{
	this->data = input;
	this->count = 1;
	this->next = next;
}

string Node::getData()
{
	return this->data;
}

Node* Node::getNext()
{
	return this->next;
}

int Node::getCounter()
{
	return this->count;
}

void Node::setData(string input)
{
	this->data = input;
}

void Node::setNext(Node* next)
{
	this->next = next;
}

void Node::increaseCount()
{
	this->count++;
}