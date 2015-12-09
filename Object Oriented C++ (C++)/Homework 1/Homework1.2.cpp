//
//  main.cpp
//  Homework 1-2
//
//  Created by Alexandru Gutu on 9/16/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>

using namespace std;

void input();
void operation();

int number;

int main()
{
    
    input();
    operation();
    
    return 0;
}

void input()
{
    cout << "This program will print all the perfect numbers up to the following number: ";
    cin >> number;
}

void operation()
{
    int sum = 0;
    
    for (int i = 1; i <= number; i++)
    {
        for (int j = 1; j < i; j++)
        {
            if (i % j == 0)
            {
                sum += j;
            }
        }
        if (sum == i)
        {
            cout << i << "\t";
        }
        sum = 0;
    }
}