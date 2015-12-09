//
//  main.cpp
//  Homework 4
//
//  Created by Alexandru Gutu on 11/10/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <string>
#include <cstring>

#include "Date.h"

using namespace std;

void array_creation(int arraysize);
void input();
void calculations(Date d[]);

int sum_month(int arraysize, Date d[]);
int sum_day(int arraysize, Date d[]);
int sum_year(int arraysize, Date d[]);

void print_data(Date d[], int n[]);
void erase_data(Date d[], int n[]);

static int arraysize;

int main()
{
	
	input();
	array_creation(arraysize);
	
	
    return 0;
}

void array_creation(int arraysize)
{
	// Dynamic array of Date objects
	Date *d;
	d = new Date[arraysize];
	for (int index = 1; index < arraysize + 1; index++)
	{
		cout << "\n" << index << ": ";
		d[index].input();
	}
	
	// Dynamic array of int values for date numerical representations
	int *n;
	n = new int[arraysize];
}

	// Array size input
void input()
{
	cout << "Please enter the size of the Date list: ";
	cin >> arraysize;
}

	// Sum of month digits
int sum_month(int arraysize, Date d[])
	{
		int temp_m = d[arraysize].getMonthNum();
        int length = temp_m.ToString().Length;
        string strNumber = temp_m.ToString();
        int month_sum = 0;
        for (int i = 0; i < length; i++)
        {
            month_sum += Convert.ToInt32(strNumber[i].ToString());
        }
        return month_sum;
    }

	// Sum of day digits
int sum_day(int arraysize, Date d[])
{
		int temp_d = d[arraysize].getDay();
        int length = temp_d.ToString().Length;
        string strNumber = temp_d.ToString();
        int day_sum = 0;
        for (int i = 0; i < length; i++)
        {
            day_sum += Convert.ToInt32(strNumber[i].ToString());
        }
        return day_sum;
}

	// Sum of year digits
int sum_year(int arraysize, Date d[])
{
	int temp_y = d[arraysize].getYear();
	int length = temp_y.ToString().Length;
	string strNumber = temp_y.ToString();
	int year_sum = 0;
	for (int i = 0; i < length; i++)
	{
		year_sum += Convert.ToInt32(strNumber[i].ToString());
	}
	return year_sum;
}

	// Sum of all calculations
void calculations(Date d[], int n[arraysize])
{
	for (int index = 1; index < arraysize + 1; index++)
	{
		int total = 0;
		int temp_total = 0;

		temp_total += sum_month(arraysize, &d[arraysize]);
		temp_total += sum_day(arraysize, &d[arraysize]);
		temp_total += sum_year(arraysize, &d[arraysize]);
		
		int length = temp_total.ToString().Length;
		string strNumber = temp_total.ToString();
		for (int i = 0; i < length; i++)
		{
			total += Convert.ToInt32(strNumber[i].ToString());
		}
		n[index] = total;
	}
}

	// Printing out dates and date values (numerical representations)
void print_data(Date d[], int n[arraysize])
{
	for (int index = 1; index < arraysize+1; index++)
	{
		cout << index << ") ";
		d[index].output();
		cout << "\t || Numerical Value: " << n[index] << endl;
	}
};
	
	// Deleting the arrays of Pointers
void erase_data(Date d[], int n[][arraysize])
{
	delete[] n;
	delete[] d;
};
