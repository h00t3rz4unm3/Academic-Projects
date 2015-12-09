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

/***
void calculate_month();
void calculate_day();
void calculate_year();
***/

int main()
{
	
	cout << "Please enter the size of the Date list: ";
	cin >> arraysize;

	Date *d;
	d = new Date[arraysize];
	for (int index = 1; index < arraysize + 1; index++)
	{
		cout << "Date " << index << ": ";
		d[index].input();
	}

	int *n[5];
	for (int i = 0; i < 5; i++)
	{
		n[i] = new int[arraysize];
	}

	for (int index = 1; index < arraysize + 1; index++)
	{
		n[1][index] = d[index].getMonthNum();
		n[2][index] = d[index].getDay();
		n[3][index] = d[index].getYear();
	}

	for (int index = 1; index < arraysize + 1; index++)
	{
		cout << index << ") ";
		d[index].output();
		cout << "Month: " << n[1][index] << " Day: " << n[2][index] << " Year: " << n[3][index];
	}
	

	

    return 0;
	
	
}

/***
void calculate_month(p)
{
	for (int index = 0; index < 5; index++)
	{
		return p[index].getMonthNum();
	}
	
}
void calculate_day()
{
	for (int index = 0; index < 5; index++)
	{
		return p[index].getDay();
	}
}
void calculate_year()
{
	for (int index = 0; index < 5; index++)
	{
		return p[index].getYear();
	}
}
***/




/***
void NumRep(Date p[])
{

	int temp_m[5];
	int temp_d[5];
	int temp_y[5];

	for (int index = 0; index < arraysize; index++)
	{
		temp_m[index] = p[index].getMonthNum();
		temp_d[index] = p[index].getDay();
		temp_y[index] = p[index].getYear();
	}

	for (int index = 0; index < arraysize; index++)
	{
		int sum_m = 0;
		int sum_d = 0;
		int sum_y = 0;

		while (temp_m[index] != 0)
		{
			sum_m += temp_m[index] % 10;
			temp_m[index] /= 10;
		}
		while (temp_d[index] != 0)
		{
			sum_d += temp_d[index] % 10;
			temp_d[index] /= 10;
		}	while (temp_y[index] != 0)
		{
			sum_y += temp_y[index] % 10;
			temp_y[index] /= 10;
		}
	}

	cout << sum_m;
	cout << sum_d;
	cout << sum_y;


}
***/