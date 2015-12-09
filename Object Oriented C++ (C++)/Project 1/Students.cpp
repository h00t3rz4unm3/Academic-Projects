//
//  Students.cpp
//  Project 1
//
//  Created by Alexandru Gutu on 12/8/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <string>
#include <cstring>
#include <cctype>

#include "Students.h"

using namespace std;

// Definition of default constructor with default values
Students::Students()
{
    fname = "";
    lname = "";
	sid = 0000000000;
	credits = 0;
	setStanding();
    gpa = 0.0;
    dob = Date();
    mdate = Date(01,01,2000);
}

// Constructor with inline passing
Students::Students(string f, string l, int s, int c, double g, Date d, Date m)
{
	fname = f;
	lname = l;
	sid = s;
	credits = c;
	setStanding();
	gpa = g;
	dob = d;
	mdate = m;
	
	touppercase();
}
// Accessors
// Accessor for first name
string Students::getFirstName()	const
{
	return fname;
}

// Accessor for last name
string Students::getLastName() const
{
	return lname;
}

// Accessor for Student ID
int Students::getSID() const
{
	return sid;
}

// Accessor for standing
string Students::getStanding() const
{
	return standing;
}

// Accessor for credits
int Students::getCredits() const
{
	return credits;
}

// Accessor for GPA
double Students::getGPA() const
{
	return gpa;
}

// Accessor for date of birth
Date Students::getDOB() const
{
	return dob;
}

// Accessor for date of matriculation
Date Students::getMDate() const
{
	return mdate;
}

// Mutators
// Mutator for first name
void Students::setFirstName(string f)
{
	fname = f;
	
	touppercase();
}

// Mutator for last name
void Students::setLastName(string l)
{
	lname = l;
	
	touppercase();
}

// Mutator for Student ID
void Students::setSID(int studentid)
{
	sid = studentid;
}

// Modifiers the credit value; determines class standing
void Students::setCredits(int c)
{
	credits = c;
	setStanding();
}

// Determines the class standing; standalone function
void Students::setStanding()
{
	if (credits > 0 && credits <= 15)
	{
		standing = "Lower Freshman";
	}
	if (credits > 15 && credits <= 30)
	{
		standing = "Upper Freshman";
	}
	if (credits > 30 && credits <= 45)
	{
		standing = "Lower Sophmore";
	}
	if (credits > 45 && credits <= 60)
	{
		standing = "Upper Sophmore";
	}
	if (credits > 60 && credits <= 75)
	{
		standing = "Lower Junior";
	}
	if (credits > 75 && credits <= 90)
	{
		standing = "Upper Junior";
	}
	if (credits > 90 && credits <= 105)
	{
		standing = "Lower Senior";
	}
	if (credits > 105 && credits <= 120)
	{
		standing = "Upper Senior";
	}
}

// Mutator for birthday
void Students::setGPA(double g)
{
	gpa = g;
}

// Mutator for date of birth
void Students::setDOB(Date d)
{
	dob = d;
}

// Mutator for date of matriculation
void Students::setMDate(Date m)
{
	mdate = m;
}

// Operator Overloading Definitions

bool Students::operator==(const Students& y) const
{
	if (lname == y.lname && fname == y.fname && sid == y.getSID())
		return true;
	else
		return false;
}

bool Students::operator!=(const Students& y) const
{
	if (lname != y.lname || fname != y.fname || sid != y.getSID())
		return true;
	else
		return false;
}

bool Students::operator<(const Students& y) const
{
	if (lname < y.lname || fname < y.fname || dob < y.dob)
		return true;
	else
		return false;
}

bool Students::operator>(const Students& y) const
{
	if (lname > y.lname && fname > y.fname && dob > y.dob)
		return true;
	else
		return false;
}

bool Students::operator<=(const Students& y) const
{
	if ((lname < y.lname || lname == y.lname) || (fname < y.fname || fname == y.fname) || (dob < y.dob || dob == y.dob))
		return true;
	else
		return false;}

bool Students::operator>=(const Students& y) const
{
	if ((lname > y.lname || lname == y.lname) || (fname > y.fname || fname == y.fname) || (dob > y.dob || dob == y.dob))
		return true;
	else
		return false;
}

ostream& operator<< (ostream& output, const Students& x)
{
	output << "Name: " << x.getFirstName() << " " << x.getLastName() << endl
	<< "Student ID: " << x.getSID() << endl
	<< "Standing: " << x.getStanding() << endl
	<< "Credits: " << x.getCredits() << endl
	<< "GPA: " << x.getGPA() << endl
	<< "Date of Birth: \n" << x.getDOB() << endl
	<< "Date of Matriculation: \n" << x.getMDate() << endl;
	return output;
}

istream& operator>> (istream& input, Students& x)
{
	string f, l;
	int s, c, g;
	int m1, m2, d1, d2, y1, y2;
	
	cout << "First Name: ";
	input >> f;
	x.fname = f;
    cout << "Last Name: ";
	input >> l;
	x.lname = l;
	cout << "Student ID: ";
	input >> s;
	x.sid = s;
    cout << "Credits: ";
    input >> c;
	x.credits = c;
	x.setStanding();
    cout << "Current GPA: ";
    input >> g;
	x.gpa = g;
	cin.ignore(1,'\n');
    
	// Input for Date of Birth using >>
	cout << "Date of Birth" << endl;
	cout << "\nMonth: ";
	input >> m1;
	cout << "\nDay: ";
    input >> d1;
	cout << "\nYear: ";
	input >> y1;
	x.dob = Date(m1, d1, y1);
	
	// Input for Date of Matriculation using >>
    cout << "Matriculation Date: " << endl;
	cout << "\nMonth: ";
	input >> m2;
	cout << "\nDay: ";
    input >> d2;
	cout << "\nYear: ";
	input >> y2;
	x.mdate = Date(m2, d2, y2);
	return input;
}

// Function to convert names to uppercase
void Students::touppercase()
{
	string ftemp;
	int lengthf = fname.size();
	for(int i = 0; i < lengthf; i++)
	{
		ftemp += toupper(fname[i]);
	}
	fname = ftemp;
	
	string ltemp;
	int lengthl = lname.size();
	for(int i = 0; i < lengthl; i++)
	{
		ltemp += toupper(lname[i]);
	}
	lname = ltemp;
}

// Input function
void Students::input()
{
    cout << "First Name: ";
	//    getline(cin, fname);
	cin >> fname;
    cout << "Last Name: ";
	//    getline(cin, lname);
	cin >> lname;
	cout << "Student ID: ";
	cin >> sid;
    cout << "Credits: ";
    cin >> credits;
	setStanding();
    cout << "Current GPA: ";
    cin >> gpa;
	cin.ignore(1,'\n');
    cout << "Date of Birth: " << endl;
    dob.input();
    cout << "Date of Matriculation: " << endl;
    mdate.input();
	touppercase();
}

// Output function
void Students::output()	const					// Output for all info, including standing
{
	cout << "Name: " << fname << " " << lname <<  endl;
	cout << "Student ID: " << sid << endl;
	cout << "Standing: " << standing << endl;
	cout << "Credits: " << credits << endl;
	cout << "GPA: " << gpa << endl;
	cout << "Date of Birth: \n" << dob << endl;
	cout << "Date of Matriculation: \n" << mdate << endl;
}