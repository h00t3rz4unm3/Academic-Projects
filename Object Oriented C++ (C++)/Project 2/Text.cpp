//
//  Text.cpp
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include "Text.h"
#include "File.h"

using namespace std;

Text::Text(string t, string n) : File(t, n)
{
	numcharacters = 0;
	size = 0;
}

Text::Text(string t, string n, int charactercount) : File(t, n)
{
	numcharacters = charactercount;
	size = numcharacters/8;
}

int Text::getNumcharacters()
{
	return numcharacters;
}

// Virtual Functions
int Text::getSize()
{
	return size;
}

void Text::displayProperties()
{
	cout << "File Properties: " << endl;
	cout << "Type: " << getType() << endl;
	cout << "Name: " << getName() << endl;
	cout << "Characters: " << numcharacters << endl;
	cout << "Size: " << size << endl;

}
