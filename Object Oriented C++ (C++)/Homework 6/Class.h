//
//  Class.h
//  Homework 6
//
//  Created by Alexandru Gutu on 11/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef Class_h
#define Class_h

#include <iostream>
#include <string>

#include "Students.h"

// Sets maximum quantity to 10
#define MAX 10

typedef Students* spointer;

using namespace std;

struct Class
{
	
private:
    string course_name;
    int course_code;
    int credits;
    string instructor;
	int counter;
	int size;
	spointer* apointer;

	// Students roster[MAX];

	// Grow Function
	void grow();
    
public:
	// Default Constructors
    Class();
    Class(string cn, int cc, int c, string i, int s, int count);
	
	// Destructor
	~Class();
	
	// Copy Constructor
	Class(const Class& other);
	
	// Mutators
	void setCoursename (string cn);
	void setCoursecode (int cc);
	void setCredits (int c);
	void setInstructor (string i);
	
	// Accessors
	string getCoursename();
	int getCoursecode();
	int getCredits();
	string getInstructor();
	
	// Functions
	void addStudent();
	void removeStudent();
	void findStudent();
	
	// Print functions
	void printAll();
	void printAllStudents();
	void printClass();
	
	// Input function
	void input();
	
	friend ostream& operator<< (ostream&, const Class&);
	friend istream& operator>> (istream&, Class&);
	
	Class& operator= (const Class& rightside);
	
	// Sort function
//	void sort(Students** a, int size);
	void sort(Students**, int);
	
};
#endif