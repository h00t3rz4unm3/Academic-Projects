//
//  Date.cpp
//  Homework 5
//
//  Created by Alexandru Gutu on 11/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <string>

#include "Date.h"

using namespace std;

// Initializes a date to the default value of January 1, 1970
Date::Date() {
	month = 1;
	day = 1;
	year = 1970;
}

// Initializes a date to the values in the parameters.  If the
// date is not legal, sets the date to 1 of the illegal value.
// (Illegal years are set to 2000)
Date::Date(int m, int d, int y) {
	month = m;
	day = d;
	year = y;
	adjust();
}

// Returns the month stored by the class
string Date::getMonth() const {
	if (month == 1)
		return "January";
	if (month == 2)
		return "February";
	if (month == 3)
		return "March";
	if (month == 4)
		return "April";
	if (month == 5)
		return "May";
	if (month == 6)
		return "June";
	if (month == 7)
		return "July";
	if (month == 8)
		return "August";
	if (month == 9)
		return "September";
	if (month == 10)
		return "October";
	if (month == 11)
		return "November";
	return "December";
}

// Returns the month stored by the class as a number
int Date::getMonthNum() const { return month; }

// Returns the day stored by the class
int Date::getDay() const { return day;}

// Retruns the year stored by the class
int Date::getYear() const { return year;}


// solicit the date from the user
void Date::input()
{
	cout << "Input month: ";
	cin >> month;
	cout << "Input day: ";
	cin >> day;
	cout << "Input year: ";
	cin >> year;
	adjust();
	
}

// output the date in a nice format
void Date::output() const
{
	cout << "Date: " << getMonth() << " " << day << ", " << year << endl;
	
}


// Fixes the date so that it is in legal range
void Date::adjust() {
	if (month < 1)
		month = 1;
	if (month > 12)
		month = 12;
	if (day < 1)
		day = 1;
	if (day > 31)
		day = 31;
	if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) &&
		(day > 30))
		day = 30;
	if ((month == 2) && (year % 4 != 0) && (day > 28))
		day = 28;
	if ((month == 2) && (year % 4 == 0) && (day > 29))
		day = 29;
}

// Operator Overloading
bool Date::operator==(const Date& x) const
{
	if (month == x.month && day == x.day && year == x.year)
		return true;
	else
		return false;
}

bool Date::operator!=(const Date& x) const
{
	if (month != x.month || day != x.day || year != x.year)
		return true;
	else
		return false;
}

bool Date::operator<(const Date& x) const
{
	if (month < x.month || day < x.day || year < x.year)
		return true;
	else
		return false;
}

bool Date::operator>(const Date& x) const
{
	if (month > x.month || day > x.day || year > x.year)
		return true;
	else
		return false;
}

bool Date::operator<=(const Date& x) const
{
	if (month <= x.month || day <= x.day || year <= x.year)
		return true;
	else
		return false;}

bool Date::operator>=(const Date& x) const
{
	if (month >= x.month || day >= x.day || year >= x.year)
		return true;
	else
		return false;
}

ostream& operator<< (ostream& output, const Date& x)
{
	output << x.getMonth() << " " << x.getDay() << ", " << x.getYear();
	return output;
}

istream& operator>> (istream& input, Date& x)
{
	int m, d, y;
	cout << "\nMonth: ";
	input >> m;
	cout << "\nDay: ";
	input >> d;
	cout << "\n";
	input >> y;
	Date(m, d, y);
	return input;
}
