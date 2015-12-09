//
//  main.cpp
//  Homework 1-3
//
//  Created by Alexandru Gutu on 9/16/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
using namespace std;

void leapyear();
void input();

int lower_limit;
int upper_limit;

int main()
{
    input();
    leapyear();
    
    
    return 0;
}

void input()
{
    cout << "Hello, this program will check for leap years within the given range set by you." << endl;
    cout << "Please enter the lower limit: ";
    cin >> lower_limit;
    cout << "Now, please enter the upper limit: ";
    cin >> upper_limit;
    if (lower_limit < 0 || upper_limit < 0 || lower_limit > upper_limit)
    {
        cout << "The years you have entered is not valid!";
    }
}

void leapyear()
{
    int counter = 0;
    for (int year = lower_limit; year <= upper_limit; year++)
        {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            {
                cout << year << " ";
                counter++;
                if (counter%5==0)
                {
                    cout << endl;
                }
            }
        }
}