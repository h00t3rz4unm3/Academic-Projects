//
//  Class.h
//  Project 1
//
//  Created by Alexandru Gutu on 12/8/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#ifndef __Project_1__Class__
#define __Project_1__Class__

#include <iostream>
#include <string>

#include "Students.h"

// Sets maximum quantity to 10
#define MAX 10

//typedef Students* spointer;

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
	Students** list;
	
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
	int getCounter();
	
	// Functions
	void addStudent();
	void addStudent(string f, string l, int s, int c, double g, Date d, Date m);
	void removeStudent();
	void findStudent();
	void updateStudent();
	
	// Print functions
	void printAll();
	void printAllStudents();
	void printClass();
	void printtofile();
	
	// Input function
	void input();
	
	friend ostream& operator<< (ostream&, const Class&);
	friend istream& operator>> (istream&, Class&);
	
	Class& operator= (const Class& rightside);
	
	// Sort function
	void sort(Students** a, int size);	
};


#endif /* defined(__Project_1__Class__) */
