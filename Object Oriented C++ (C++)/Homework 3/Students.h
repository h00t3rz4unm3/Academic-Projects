//
//  Students.h
//  Homework 3
//
//  Created by Alexandru Gutu on 10/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef Students_h
#define Students_h

#include <iostream>

using namespace std;

struct Students								// Structure definition
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
    Students();								// Default constructor
	Students(string f, string l, int c, double g, string d, string m);	// Constructor with inline variables
    
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

#endif /* defined(__Homework_3__Students__) */
