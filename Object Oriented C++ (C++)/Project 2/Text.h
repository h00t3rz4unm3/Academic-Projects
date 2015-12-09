//
//  Text.h
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Homework_8__Text__
#define __Homework_8__Text__

#include <iostream>
#include "File.h"

using namespace std;

class Text : public File
{
private:
	int numcharacters;
	int size;
	
public:
	Text(string t, string n);
	Text(string t, string n, int charactercount);
	
	int getNumcharacters();
		
	// Virtual Functions
	int getSize();
	void displayProperties();

};

#endif /* defined(__Homework_8__Text__) */
