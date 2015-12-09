//
//  Node LinkedList.cpp
//  Project 2 C++
//
//  Created by Alexandru Gutu on 9/29/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//

using namespace std;

#include <iostream>

class Node
{
	// Node data
private:
	string strData;
	Node* nextNode;
	
	// Node functions
public:
	Node(string data);
	Node(string data, Node* next);
	string getData();
	Node* getNext();
	void setNext(Node* newNode);
	~Node();
};

class linkedList
{
	// Linked List variables
private:
	Node* listHead;
	
	// Linked List functions
public:
	linkedList(string strData);
	linkedList(Node* n);
	void insert();
	~linkedList();
};

	// Node constructor using one parameter
Node::Node(string data)
{
	this-> strData = data;
}

	// Node constructor using two parameters
Node::Node(string data, Node* next)
{
	this-> strData = data;
	this-> nextNode = next;
}

	// Node function to return Node data
string Node::getData()
{
	return this-> strData;
}
	// Node function to return next linked Node
Node* Node::getNext()
{
	return this-> nextNode;
}

	// Node function to set the next linked node
void Node::setNext(Node* newNode)
{
	this-> nextNode = newNode;
}

	// Linked List constructor accepting one parameter - String
linkedList::linkedList(string strData)
{
	listHead = new Node(strData);
}

	// Linked List constructor accepting one parameter - Node
linkedList::linkedList(Node* n)
{
	listHead = n;
}

// Linked List function for insert
void linkedList::insert()
{
	
}

// Deconstructor for the Nodes
Node::~Node()
{
	if (nextNode != NULL)
	{
		delete nextNode;
	}
}

// Deconstructor for the Linked List
linkedList::~linkedList()
{
	Node* currentNode = this-> listHead;
	while (currentNode)
	{
		Node* nextNode = currentNode-> getNext();
		delete currentNode;
		currentNode = nextNode;
	}
}