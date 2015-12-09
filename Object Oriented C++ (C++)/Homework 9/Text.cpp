//
//  Text.cpp
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include "Text.h"

using namespace std;

Text::Text()
{
	numcharacters = 0;
	size = 0;
}

Text::Text(int charactercount)
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
	cout << "Size: " << size << endl;
	cout << "Characters: " << numcharacters << endl;
}
