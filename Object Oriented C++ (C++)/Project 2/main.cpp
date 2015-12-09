//
//  main.cpp
//  Project 2
//
//  Created by Alexandru Gutu on 12/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <sstream>

#include "File.h"
#include "Image.h"
#include "Text.h"

using namespace std;

// File Property Output Function
void output(vector<File*> files);

// File Filter Function
vector<File*> filter(vector<File*> files, string type);

vector<File*> vec;

bool menu = true;

int main()
{
	// Infinitely looping menu so you can load data from file and manipulate it.
	while (menu == true)
	{
		
	cout << "1. Read from File." << endl
		 << "2. Create an Image file." << endl
		 << "3. Create a Text file. " << endl
		 << "4. Print all files" << endl
		 << "5. Print Image files" << endl
		 << "6. Print Text files" << endl
		 << "7. Quit" << endl;
	cout << "\nPlease select from one of the above functions: ";

	int input = 0;

	cin >> input;
	
	switch (input)
	{
			// Read from file
		case 1:
		{
			cout << "Reading Data from file... \n \n";
			
			string ignore;
			string type;
			string name;
			string numofcharacters;
			string row;
			string column;
			string depth;
		
			ifstream testfile("test.txt");
			if (testfile.fail())
			{
				cout << "File could not be opened Please try again." << endl << endl;
				return 0;
			}
			while (!testfile.eof())
			{
				
			getline(testfile, type);
				if (type == "txt")
				{
					getline(testfile, name);
					getline(testfile, numofcharacters);
				
					vec.push_back(new Text(type, name, atoi(numofcharacters.c_str())));
				}
				else if (type == "gif")
				{
					getline(testfile, name);
					getline(testfile, row, 'x');
					getline(testfile, column);
					getline(testfile, depth);
				
					vec.push_back(new Image(type, name, atoi(row.c_str()), atoi(column.c_str()), atoi(depth.c_str())));
				}
				else if (type == "\n")
				{
					getline(testfile, ignore);
				}
			}
		break;
		}
		
		// New Image File
		case 2:
		{
			cout << "New Image file: \n\n";
			
			string namei, rowi, columni, depthi;
			
			cout << "File Name: ";
			cin >> namei;
			
			cout << "\nNumber of pixels in row: ";
			cin >> rowi;
			
			cout << "\nNumber of pixels in columns: ";
			cin >> columni;
			
			cout << "\nColor Depth: ";
			cin >> depthi;
			
			vec.push_back(new Image("gif", namei, atoi(rowi.c_str()), atoi(columni.c_str()), atoi(depthi.c_str())));
			
			break;
		}
		
			// New Text File
		case 3:
		{
			cout << "New Text file: \n\n";
			
			string namet;
			int characterount;
			
			cout << "File Name: ";
			cin >> namet;
			
			cout << "\nCharacter Count: ";
			cin >> characterount;
			vec.push_back(new Text("txt", namet, characterount));
			
			break;
		}
			
			// Print all file properties
		case 4:
		{
			cout << "Print all file properties: \n\n";
			output(vec);
			
			break;
		}
			
			// Print all Image properties
		case 5:
		{
			cout << "Print all Image file properties: \n\n";
			output(filter(vec, "gif"));
			
			break;
		}
		
			// Print all Text properties
		case 6:
		{
			cout << "Print all Text file properties: \n\n";
			output(filter(vec, "txt"));
			
			break;
		}
			
			// Exit
		case 7:
		{
			menu = false;
			break;
		}
			
		default:
			break;
	}
	
	}
}

void output(vector<File*> files)
{
	if (files.size() == 0)
	{
		return;
	}
	else
	{
		File* last = files[files.size()-1];
		files.resize(files.size()-1);
		output(files);
		last->displayProperties();
		cout << endl;
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


