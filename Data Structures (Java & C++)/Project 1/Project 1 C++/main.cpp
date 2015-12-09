//
//  main.cpp
//  Project 1 C++
//
//  Created by Alexandru Gutu on 9/17/14.
//  Copyright (c) 2014 Alexandru Gutu. All rights reserved.
//
//  Suppose we are given a data file (data1.txt) which contains integers. We are interested to know:
//	1) How many integers are in data1.txt
//	2) The largest integer in data1.txt
//	3) The smallest integer in data1.txt
//  4) The average of all integers in data1.txt
//
//  Use an array to store the data, and selection sort to sort the array.
//

//  Step 1: Prepare program by importing specific libraries

#include <iostream>
#include <fstream>

using namespace std;

//  Step 2: Initialize variables and opening the data file

double average = 0.0;
int sum = 0;
int counter = 0;
int minimum = 99999999;
int maximum = -99999999;
int iterationcounter = 1;

string userinput;

//  Prints the array, the iteration number, minimumindex, iteration conter and the index values in a neat fashion.

void print(int position, int minimumindex, int count, int iterationcounter, int array[])
{
    cout << endl;
    cout << "Iteration Number: " << iterationcounter << " Position Index: " << position << " minimumimum Index: " << minimumindex << endl;
    for (int i = 0; i < counter; i++)
    {
        cout << array[i] << " ";
        if ((i + 1) % 43 == 0)
        {
            cout << endl;
            for (int i = 0; i < counter; i++)
            {
                cout << i << "  ";
            }
        }
        
    }
    cout << endl;
}

//  Sorting Algorithm - Selection Sort

void sort(int array[], int counter, int& iterationcounter)
{

//  Step 1: Initialize the variables
    
    int position = 0;
    int minimumindex = position;
    int walker = position;
    

    while (position < counter)
    {
        
//  Step 2: Increment walker (did at end of while loop rather than beginning -- no noticable difference
        
        while (walker < counter)
        {
            
//  Step 3: Compare array[minindex] with array[walker], if array[walker] < array[minindex], minindex = walker
            
            if (array[minimumindex] > array[walker])
            {
                minimumindex = walker;
            }
            walker++;
        }

//  Step 4: Repeat steps 2-3 untill walker < counter
        
//  Step 5: Perform swap between array[minindex] and array[position]
        
        int temp = array[position];
        array[position] = array[minimumindex];
        array[minimumindex] = temp;
        
//  Print out iteration display
        print(position, minimumindex, counter, iterationcounter, array);

//  Step 6: Increment position, set walker to position and minindex to position
        
        iterationcounter++;
        
        position++;
        walker = position;
        minimumindex = position;
        
//  Step 7: Repeat steps 2-6 untill position >= counter;
    }
}

int main()
{
// Step 4: Assume data is integer, therefore process data and perform needed functions. In this case, we are asking the user for the location of the file. Then, we are creating a dynamically allocated array and storing the input data in the array. Furthermore, we are processing the data (min/max/sum/etc)
    
    cout << "What is the name of the input file: " << endl;
    getline(cin, userinput);
    
    ifstream inputfile;
    inputfile.open(userinput);
    
    if (!inputfile)
    {
        cout << "Can't open input file " << userinput << endl;
        return 0;
    }

    
    int *array = new int[counter];
    
//  Step 5; Repeat until all data is read (while loop)
    
    while (!inputfile.eof())
    {
        inputfile >> array[counter];
        sum += array[counter];
        
        if (array[counter] < minimum)
        {
            minimum = array[counter];
        }
        else if (array[counter] > maximum)
        {
            maximum = array[counter];
        }
        
        counter++;
    }
    
// Step 6: Print out original array using for loop and the index values.
    
    cout << "Original Array:" << endl;
    for (int i = 0; i < counter; i++)
    {
        cout << array[i] << " ";
        if ((i + 1) % 43 == 0)
        {
            cout << endl;
            for (int i = 0; i < counter; i++)
            {
                cout << i << "  ";
            }
        }
    }
    cout << endl;
    
// Step 7: Call the sort function. This function was made simply to keep the code a little clearer
    
    sort(array, counter, iterationcounter);
    
// Step 8: Display the needed results
    
    average = (double) sum/ (double) counter;
    
    cout << endl;
    
    cout << "There are: " << counter << " integers" << endl;
    cout << "The minimumimum is: " << minimum << endl;
    cout << "The maximum is: " << maximum << endl;
    cout << "The average is: " << average << endl;
    
    inputfile.close();
    
    return 0;
}



