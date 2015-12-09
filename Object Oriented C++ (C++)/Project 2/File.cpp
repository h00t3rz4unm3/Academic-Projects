//
//  File.cpp
//  Homework 8
//
//  Created by Alexandru Gutu on 12/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include "File.h"

using namespace std;

File::File()
{
	name = "";
	type = "";
}

File::File(string t, string n)
{
	type = t;
	name = n;
}

string File::getType()
{
	return type;
}

string File::getName()
{
	return name;
}

void File::displayProperties()
{
	cout << "File Properties: " << endl;
	cout << "Name: " << name << endl;
	cout << "Type: " << type << endl;
}
