//
//  Students.h
//  Homework 5
//
//  Created by Alexandru Gutu on 11/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef Students_h
#define Students_h

#include <iostream>
#include <string>

#include "Date.h"

using namespace std;

// Structure definition
struct Students
{
	// Private Values
private:
    string fname;
    string lname;
    string standing;
    int credits;
    double gpa;
    Date dob;
    Date mdate;
	
	// Public values
public:
	// Default constructor
    Students();
	
	// Constructor with inline variables
	Students(string f, string l, int c, double g, Date d, Date m);
    
	// Mutators
    void setFirstName(string f);
    void setLastName(string l);
	void setStanding();
    void setCredits(int c);
    void setGPA(double d);
    void setDOB(Date d);
    void setMDate(Date m);
    
	// Accessors
	string getFirstName() const;
	string getLastName() const;
	string getStanding() const;
	int getCredits() const;
	double getGPA() const;
	Date getDOB() const;
    Date getMDate() const;
	
	// Operator Overloading
	bool operator==(const Students& y) const;
	bool operator!=(const Students& y) const;
	bool operator<(const Students& y) const;
	bool operator>(const Students& y) const;
	bool operator<=(const Students& y) const;
	bool operator>=(const Students& y) const;
	
	friend ostream& operator<< (ostream&, const Students&);
	friend istream& operator>> (istream&, Students&);
	
	// Function to convert to uppercase
	void touppercase();
    
	// Output Function
    void output() const;
	// Input Function
    void input();
};

#endif
