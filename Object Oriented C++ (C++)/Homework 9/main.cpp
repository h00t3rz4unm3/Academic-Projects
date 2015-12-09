//
//  main.cpp
//  Homework 9
//
//  Created by Alexandru Gutu on 12/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <vector>
#include <fstream>

#include "File.h"
#include "Image.h"
#include "Text.h"

using namespace std;

void output(vector<File*> files);
vector<File*> filter(vector<File*> files, string type);

int main()
{
    return 0;
}

void output(vector<File*> files)
{
	if (files.size() == 0)
	{
		return;
	}
	else
	{
		File* last = files[files.size()];
		files.resize(files.size()-1);
		output(files);
		last->displayProperties();
	}
}

vector<File*> filter(vector<File*> files, string type)
{
	if (files.size() == 0)
		{
		vector<File*> v;
		return v;
		}
	File* last = files[files.size()-1];
	vector<File*> v;
	files.resize(files.size()-1);
	v = filter(files, type);
	if (last->getType() == type)
		v.push_back(last);
	return v;
}

