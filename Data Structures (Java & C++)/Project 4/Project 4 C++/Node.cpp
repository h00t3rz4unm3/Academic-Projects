//
//  Node.cpp
//  Project 4 C++
//
//  Created by Alexandru Gutu on 11/14/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

#include "Node.h"

using namespace std;

Node::Node(int data)
{
	this->data = data;
	this->left = nullptr;
	this->right = nullptr;
}

const int Node::getData()
{
	return this->data;
}

Node *Node::getLeft()
{
	return this->left;
}

Node *Node::getRight()
{
	return this->right;
}

void Node::setData(int data)
{
	this->data = data;
}

void Node::setLeft(Node *nextLeft)
{
	this->left = nextLeft;
}

void Node::setRight(Node *nextRight)
{
	this->right = nextRight;
}

void Node::printData()
{
	cout << this->data << endl;
}