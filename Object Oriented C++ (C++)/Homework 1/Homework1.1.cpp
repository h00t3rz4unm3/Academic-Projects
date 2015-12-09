//
//  main.cpp
//  Homework 1-1
//
//  Created by Alexandru Gutu on 9/15/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//
//  A prime number is a number other than 1 that is divisible only by 1 and itself. (Example of prime numbers: 2, 3, 5, 7, ...). Write a program that asks the user for a positive integer. The program will print out all prime numbers from 1 to that positibe integer. It is better if you write a separate function to check out if an integer is prime or not.

#include <iostream>
#include <cmath>
using namespace std;

void input();
void primetest();

int number;

bool test;

int main()
{

    input();
    primetest();
    
    
    return 0;
}

void input()
{
    cout << "Hello, please enter a positive integer: ";
    cin >> number;
        if (number < 0)
        {
            cout << "The numberber you have entered is not positive!";
        }
        else
        {
            cout << "You have entered: " << number << endl;
        }
}

void primetest()
{
    for (int i = 2; i <= number; i++)
    {
        test = true;
        for(int j = 2; j < i; j++)
        {
            if( i % j == 0)
            {
                test = false;
                break;
            }
        }
        if (test == true)
            cout << i << " ";
    }
    
    if (test == false)
    {
        cout << endl;
        cout << number << " is not Prime";
    }
    
    else
    {
        cout << endl;
        cout << number << " is Prime";
    }

}

