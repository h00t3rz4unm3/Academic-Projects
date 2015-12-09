//
//  File.h
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Homework_8__File__
#define __Homework_8__File__

#include <iostream>

using namespace std;

class File
{
private:
	string type;
	string name;
	
public:
	File();
	File(string t, string n);
	
	string getType();
	string getName();

	// Pure Virtual function for size since that is calculated independently depending on the tye of file
	virtual int getSize() = 0;
	
	// Virtual function that displays properties based on file type.
	virtual void displayProperties();
	
};

#endif /* defined(__Homework_8__File__) */
