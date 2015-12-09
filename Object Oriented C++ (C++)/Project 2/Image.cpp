//
//  Image.cpp
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include "Image.h"
#include "File.h"

using namespace std;

Image::Image(string t, string n) : File(t, n)
{
	rows = 0;
	columns = 0;
	depth = 0;
	size = (rows*columns*depth)/8;
}

Image::Image(string t, string n, int r, int c, int d) : File(t, n)
{
	rows = r;
	columns = c;
	depth = d;
	size = (rows*columns*depth)/8;
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

// Pure Virtual Function
int Image::getSize()
{
	return size;
}

// Virtual Function
void Image::displayProperties()
{
	cout << "File Properties: " << endl;
	cout << "Type: " << getType() << endl;
	cout << "Name: " << getName() << endl;
	cout << "Dimensions: " << rows << " X " << columns << endl;
	cout << "Depth: " << depth << endl;
	cout << "Size: " << size << endl;
}