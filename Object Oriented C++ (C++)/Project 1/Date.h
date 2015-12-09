//
//  Date.h
//  Project 1
//
//  Created by Alexandru Gutu on 12/8/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_1__Date__
#define __Project_1__Date__

#include <iostream>
#include <string>

using namespace std;

class Date {
private:
	int month, day, year;
	void adjust();
	
public:
	// Initializes a date to the default value of January 1, 1970.
	Date();
	
	// Initializes a date to the values in the parameters.  If the
	// date is not legal, sets the date to one of the legal values.
	Date(int m, int d, int y);
	
	// Copy constructor
	Date(const Date& other);
	
	// Returns the month stored by the class
	string getMonth() const;
	
	// Returns the month stored by the class as a number
	int getMonthNum() const;
	
	// Returns the day stored by the class
	int getDay() const;
	
	// Returns the year stored by the class
	int getYear() const;
	
	// solicit the date from the user
	void input();
	
	// output the date in a nice format
	void output() const;
	
	// Operator Overloading
	bool operator==(const Date& x) const;
	bool operator!=(const Date& x) const;
	bool operator<(const Date& x) const;
	bool operator>(const Date& x) const;
	bool operator<=(const Date& x) const;
	bool operator>=(const Date& x) const;
	
	// Friend Operator Overloading
	friend ostream& operator<< (ostream&, const Date&);
	friend istream& operator>> (istream&, Date&);
};


#endif /* defined(__Project_1__Date__) */
