//
//  main.cpp
//  Homework 4
//
//  Created by Alexandru Gutu on 11/10/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <string>

#include "Date.h"

using namespace std;

int arraysize;

int main()
{
	
	cout << "Please enter the size of the Date list: ";
	cin >> arraysize;

	Date *d;
	d = new Date[arraysize];
	for (int index = 1; index < arraysize + 1; index++)
	{
		cout << "\n" << index << ": ";
		d[index].input();
	}
	
	int *n;
	n = new int[arraysize];

	for (int index = 1; index < arraysize + 1; index++)
	{
		int sum_month = 0;
		int sum_day = 0;
		int sum_year = 0;

		while (n[index].getMonthNum() != 0) 
		{
			sum_month += n[index].getMonthNum() % 10;
			n[index].getMonthNum() /= 10;
		}
		while (n[index].getDay() != 0) 
		{
			sum_day += n[index].getDay() % 10;
			n[index].getDay() /= 10;
		}
		while (n[index].getYear() != 0) 
		{
			sum_year += n[index].getYear() % 10;
			n[index].getYear() /= 10;
		}

		n[0][index] = sum_month + sum_day + sum_year;
		if (temp > 9)
			{
				int temp_sum = 0;
				while (temp != 0)
				{
					temp_sum += temp % 10;
					temp /= 10;
				}
				temp = temp_sum;
			}

	}

	for (int index = 1; index < arraysize + 1; index++)
	{
		cout << index << ") ";
		d[index].output();
		cout << "\t || Numerical Value: " << n[0][index] << endl;
	}
    return 0;
}