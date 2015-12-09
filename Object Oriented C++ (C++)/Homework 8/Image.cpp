//
//  Image.cpp
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include "Image.h"

using namespace std;

Image::Image()
{
	rows = 0;
	columns = 0;
	depth = 0;
	size = (rows*columns*depth)/depth;
}

Image::Image(int r, int c, int d)
{
	rows = r;
	columns = c;
	depth = d;
	size = (rows*columns*depth)/depth;
}

int Image::getRows()
{
	return rows;
}

int Image::getColumns()
{
	return columns;
}

int Image::getDepth()
{
	return depth;
}

// Virtual Functions
int Image::getSize()
{
	return size;
}

//Properties include: type, name, size, dimensions and color depth for an Image File, characters for a Text File.
//Provide functions to return type and names of files.
//Provide function to retrieve character count for a Text file.

void Image::displayProperties()
{
	cout << "File Properties: " << endl;
	cout << "Type: " << getType() << endl;
	cout << "Name: " << getName() << endl;
	cout << "Size: " << size << endl;
	cout << "Dimensions: " << rows << " X " << columns << endl;
	cout << "Depth: " << depth << endl;
}