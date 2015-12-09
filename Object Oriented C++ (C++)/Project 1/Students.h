//
//  Students.h
//  Project 1
//
//  Created by Alexandru Gutu on 12/8/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_1__Students__
#define __Project_1__Students__

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
	int sid;
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
	Students(string f, string l, int sid, int c, double g, Date d, Date m);
    
	// Mutators
    void setFirstName(string f);
    void setLastName(string l);
	void setSID(int studentid);
	void setStanding();
    void setCredits(int c);
    void setGPA(double d);
    void setDOB(Date d);
    void setMDate(Date m);
    
	// Accessors
	string getFirstName() const;
	string getLastName() const;
	int getSID() const;
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

#endif /* defined(__Project_1__Students__) */
