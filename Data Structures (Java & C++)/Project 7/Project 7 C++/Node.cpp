//
//  Node.cpp
//  Project 7 C++
//
//  Created by Alexandru Gutu on 11/23/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include "Node.h"

Node::Node(int data)
{
	this->data = data;
}

Node::Node(int data, Node* next)
{
	this->data = data;
	this->nextNode = next;
}

int Node::getData()
{
	return data;
}

Node* Node::getNext()
{
	return nextNode;
}

void Node::setNext(Node* next)
{
	this->nextNode = next;
}