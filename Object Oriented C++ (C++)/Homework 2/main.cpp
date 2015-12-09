//
//  main.cpp
//  Homework 2
//
//  Created by Alexandru Gutu on 9/19/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>

using namespace std;

struct Student								// Structure definition
{
private:									// Private Values
    string fname;
    string lname;
    string standing;
    int credits;
    double gpa;
    string dob;
    string mdate;
    
public:										// Public values
    Student();								// Default constructor
	Student(string f, string l, int c, double g, string d, string m);	// Constructor with inline variables
    
    void setFirstName(string f);			// Mutators
    void setLastName(string l);
	void setStanding();
    void setCredits(int c);
    void setGPA(double d);
    void setDOB(string d);
    void setMDate(string m);
    
	string getFirstName();					// Accessors
    string getLastName();
	string getStanding();
	int getCredits();
	double getGPA();
    string getDOB();
    string getMDate();
    
    void output();							// Output Function
    void input();							// Input Function
};




int main()
{
	Student One;							// Initializes structure, names it "One"
	One.input();							// Initializes the input function of "One"
	cout << endl;
	cout << endl;
	One.output();							// Initializes the output function of "One"
	
    return 0;
}

Student::Student()							// Definition of default constructor with default values
{
    fname = "";
    lname = "";
	credits = 0;
	setStanding();
    gpa = 0.0;
    dob = "";
    mdate = "01/01/2000";					// Default date of matriculation
}

Student::Student(string f, string l, int c, double g, string d, string m)	// Construccor with inline passing
{
	fname = f;
	lname = l;
	credits = c;
	setStanding();
	gpa = g;
	dob = d;
	mdate = m;
}

string Student::getFirstName()				// Accessor for first name
{
	return fname;
}

string Student::getLastName()				// Accessor for last name
{
	return lname;
}

string Student::getStanding()				// Accessor for standing
{
	return standing;
}

int Student::getCredits()					// Accessor for credits
{
	return credits;
}

double Student::getGPA()					// Accessor for GPA
{
	return gpa;
}

string Student::getDOB()					// Accessor for date of birth
{
	return dob;
}

string Student::getMDate()					// Accessor for date of matriculation
{
	return mdate;
}

void Student::setFirstName(string f)		// Mutator for first name
{
	fname = f;
}
void Student::setLastName(string l)			// Mutator for last name
{
	lname = l;
}

void Student::setCredits(int c)				// Modifiers the credit value; determines class standing
{
	credits = c;
	setStanding();
}

void Student::setStanding()					// Determines the class standing; standalone function
{
	if (credits > 0 && credits < 15)
	{
		standing = "Lower Freshman";
	}
	if (credits > 15 && credits < 30)
	{
		standing = "Upper Freshman";
	}
	if (credits > 30 && credits < 45)
	{
		standing = "Lower Sophmore";
	}
	if (credits > 45 && credits < 60)
	{
		standing = "Upper Sophmore";
	}
	if (credits > 60 && credits < 75)
	{
		standing = "Lower Junior";
	}
	if (credits > 75 && credits < 90)
	{
		standing = "Upper Junior";
	}
	if (credits > 90 && credits < 105)
	{
		standing = "Lower Senior";
	}
	if (credits > 105 && credits < 120)
	{
		standing = "Upper Senior";
	}
}


void Student::setGPA(double g)				// Mutator for birthday
{
	gpa = g;
}
void Student::setDOB(string d)				// Mutator for date of birth
{
	dob = d;
}
void Student::setMDate(string m)			// Mutator for date of matriculation
{
	mdate = m;
}

void Student::input()						// Input function, part of class
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

void Student::output()						// Output for all info, including standing
{
	cout << "Name: " << fname << " " << lname <<  endl;
	cout << "Standing: " << standing << endl;
	cout << "Credits: " << credits << endl;
	cout << "GPA: " << gpa << endl;
	cout << "Date of Birth: " << dob << endl;
	cout << "Date of Matriculation: " << mdate << endl;
}

