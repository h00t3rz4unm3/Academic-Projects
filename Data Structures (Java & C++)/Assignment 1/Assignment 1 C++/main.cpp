//
//  main.cpp
//  Assignment 1
//
//  Created by Alexandru Gutu on 9/4/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//
//  Suppose we are given a data file (data1.txt) which contains integers. We are interested to know:
//	1) How many integers are in data1.txt
//	2) The largest integer in data1.txt
//	3) The smallest integer in data1.txt
//  4) The average of all integers in data1.txt
//

// Step 1: Prepare program by importing specific libraries

#include <iostream>
#include <fstream>

using namespace std;

// Step 2: Initializing variables and opening the data file.

int sum = 0;
int counter = 0;
int highest = 0;
int lowest = 0;
int input = 0;

int main()
{
    // Assuming data file will be in the same folder as the source code
    ifstream inFile;    
	inFile.open("data/data1.txt");
	
// Step 3: Reading in data from the data file

    while (!inFile.eof())
    {
	
// Step 4: Assume data is integer, therefore process data and perform functions needed
	
        inFile >> input;
        counter++;
        sum += input;
        
        if (input > highest)
        {
            highest = input;
        }
        else if (input < lowest)
        {
            lowest = input;
        }
    }
    
// Step 5: Repeat steps 3-4 until all data is read (while loop)

//Step 6: Display the needed results
	
    cout << "There are " << counter << " integers in the data file" << endl;
    cout << "The average is " << sum/counter << endl;
    cout << "The highest integer is " << highest << endl;
    cout << "The lowest integer is " << lowest << endl;
    
    return 0;
}

