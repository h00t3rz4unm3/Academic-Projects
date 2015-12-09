//
//  Image.h
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Homework_8__Image__
#define __Homework_8__Image__

#include <iostream>
#include "File.h"

using namespace std;

class Image : public File
{
private:
	int rows;
	int columns;
	int depth;
	int size;

public:
	Image(string t, string n);
	Image(string t, string n, int r, int c, int d);
	int getRows();
	int getColumns();
	int getDepth();
		
	// Virtual Functions
	int getSize();
	void displayProperties();
	
};

#endif /* defined(__Homework_8__Image__) */
