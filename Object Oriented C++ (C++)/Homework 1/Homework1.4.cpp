//
//  main.cpp
//  Homework 1-4
//
//  Created by Alexandru Gutu on 9/16/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>

using namespace std;

void input();
void reversal();

int number;

int main()
{

        while(true)
        {
        input();
        reversal();
        cout << endl;
        }
    
    return 0;
}

void input()
{
    cout << "This program will simply print the inverse of whatever integer the user inputs." << endl;
    cout << "To begin, please enter a positive integer: ";
    cin >> number;
    
    while (number < 0)
    {
        cout << "The number you have entered is not a positive integer. Please try again. " << endl;
        exit(0);
    }
}

void reversal()
{
    int trail = 0;
    int digit = 0;
    
    int modifier = number;
    
    while (modifier != 0)
    {
        trail = modifier % 10;
        digit = digit * 10 + trail;
        modifier = modifier / 10;
    }
    cout << "\nThe original number is: " << number;
    cout << "\nThe reversed number is: " << digit;
}

