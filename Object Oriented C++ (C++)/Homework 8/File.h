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

	virtual int getSize() = 0;
	virtual void displayProperties();
	
};

#endif /* defined(__Homework_8__File__) */
