//
//  Students.cpp
//  Homework 3
//
//  Created by Alexandru Gutu on 10/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include "Students.h"

using namespace std;

Students::Students()							// Definition of default constructor with default values
{
    fname = "";
    lname = "";
	credits = 0;
	setStanding();
    gpa = 0.0;
    dob = "";
    mdate = "01/01/2000";					// Default date of matriculation
}

Students::Students(string f, string l, int c, double g, string d, string m)	// Construccor with inline passing
{
	fname = f;
	lname = l;
	credits = c;
	setStanding();
	gpa = g;
	dob = d;
	mdate = m;
}

string Students::getFirstName()				// Accessor for first name
{
	return fname;
}

string Students::getLastName()				// Accessor for last name
{
	return lname;
}

string Students::getStanding()				// Accessor for standing
{
	return standing;
}

int Students::getCredits()					// Accessor for credits
{
	return credits;
}

double Students::getGPA()					// Accessor for GPA
{
	return gpa;
}

string Students::getDOB()					// Accessor for date of birth
{
	return dob;
}

string Students::getMDate()					// Accessor for date of matriculation
{
	return mdate;
}

void Students::setFirstName(string f)		// Mutator for first name
{
	fname = f;
}
void Students::setLastName(string l)			// Mutator for last name
{
	lname = l;
}

void Students::setCredits(int c)				// Modifiers the credit value; determines class standing
{
	credits = c;
	setStanding();
}

void Students::setStanding()					// Determines the class standing; standalone function
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


void Students::setGPA(double g)				// Mutator for birthday
{
	gpa = g;
}
void Students::setDOB(string d)				// Mutator for date of birth
{
	dob = d;
}
void Students::setMDate(string m)			// Mutator for date of matriculation
{
	mdate = m;
}

ostream& operator <<(ostream& outputStream, const Students& output)
{
	Students::output();
}

istream& operator >>(istream& inputStream, Students& input)
{
	Students::input();
}



void Students::input()						// Input function, part of class
{
    cout << "First Name: ";
    getline(cin, fname);					// Inputs first name
    cout << "Last Name: ";
    getline(cin, lname);					// Inputs last name
    cout << "Credits: ";
    cin >> credits;							// Input for credits
	setStanding();
    cout << "Current GPA: ";
    cin >> gpa;								// Input for GPA
	cin.ignore(1,'\n');
    cout << "Date of Birth: ";
    getline(cin, dob);						// Input for Date of Birth
    cout << "Matriculation Date: ";
    getline(cin, mdate);					// Input for Date of Matriculation
}

void Students::output()						// Output for all info, including standing
{
	cout << "Name: " << fname << " " << lname <<  endl;
	cout << "Standing: " << standing << endl;
	cout << "Credits: " << credits << endl;
	cout << "GPA: " << gpa << endl;
	cout << "Date of Birth: " << dob << endl;
	cout << "Date of Matriculation: " << mdate << endl;
}

