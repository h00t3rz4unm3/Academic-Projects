//
//  Class.cpp
//  Homework 3
//
//  Created by Alexandru Gutu on 10/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include "Class.h"
#include "Students.h"

using namespace std;

// Default Constructor with defualt values
Class::Class()
{
	course_name = "N/A";
	course_code = 0000;
	credits = 0;
	instructor = "N/A";
	counter = 0;
}

// Inline Constructor
Class::Class(string cn, int cc, int c, string i, int count)
{
	course_name = cn;
	course_code = cc;
	credits = c;
	instructor = i;
	counter = count;
}

// Mutator
void Class::setCoursename(string cn)
{
	course_name = cn;
}

// Mutator
void Class::setCoursecode(int cc)
{
	course_code = cc;
}

// Mutator
void Class::setCredits(int c)
{
	credits = c;
}

// Mutator
void Class::setInstructor(string i)
{
	instructor = i;
}

// Accessor
string Class::getCoursename()
{
	return course_name;
}

// Accessor
int Class::getCoursecode()
{
	return course_code;
}

// Accessor
int Class::getCredits()
{
	return credits;
}

// Accessor
string Class::getInstructor()
{
	return instructor;
}

// Add student function
void Class::addStudent()
{
	cout << "Add Student " << counter << ": " << endl;
	roster[counter].input();
	counter++;
	
	if (counter == 10)
	{
		cout << "Error! Maximum number of students are registered.";
		EXIT_SUCCESS;
	}
}

// Remove student function
void Class::removeStudent()
{
	string fn, ln;
	
	cout << "Remove a Student: " << endl;
	cout << "Please enter a first name: ";
	getline(cin, fn);
	cout << "Please enter a last name: ";
	getline(cin, ln);
	cout << endl;
	
	for (int i = 0; i < counter; i++)
		if (fn == roster[i].getFirstName() && ln == roster[i].getLastName())
		{
			for (int j = i; j < counter-1; j++)
			roster[j] = roster[j+1];
		}
	counter--;
	}

// Function to find student
void Class::findStudent()
{
	string fn, ln;
	
	cout << "Find a Student: " << endl;
	cout << "Please enter a first name: ";
	getline(cin, fn);
	cout << "Please enter a last name: ";
	getline(cin, ln);
	cout << endl;
	
	for (int i = 0; i < counter; i++)
	if (fn == roster[i].getFirstName() && ln == roster[i].getLastName())
		roster[i].output();
		cout << endl;
}

// Function to print class info
void Class::printClass()
{
	cout << "Print Class Info: " << endl;
	cout << "Course Name: " << course_name << endl;
	cout << "Course Code: " << course_code << endl;;
	cout << "Credits: " << credits << endl;
	cout << "Instructor: " << instructor << endl;
}

// Function to print only students
void Class::printAllStudents()
{
	cout << "Print All Students: " << endl;
	cout << "Course Name: " << course_name << endl;
	cout << "Course Code: " << course_code << endl;;
	cout << "Credits: " << credits << endl;
	cout << "Instructor: " << instructor << endl;
	cout << endl;
	
	
	for (int i = 0; i < counter; i++)
	{
		roster[i].output();
		cout << endl;
	}
}

// Function to print everything
void Class::printAll()
{
	cout << "Print All: " << endl;
	cout << "Course Name: " << course_name << endl;
	cout << "Course Code: " << course_code << endl;;
	cout << "Credits: " << credits << endl;
	cout << "Instructor: " << instructor << endl;
	cout << endl;
	
	for (int i = 0; i < MAX; i++)
	{
		roster[i].output();
		cout << endl;
	}
}

// Function for class input
void Class::input()
{
	cout << "Course Name: ";
	getline(cin, course_name);
	cout << "Course Code: ";
	cin >> course_code;
	cout << "Credits: ";
	cin >> credits;
	cin.ignore(1,'\n');
	cout << "Instructor: ";
//	cin.ignore(1,'\n');
	getline(cin, instructor);
	cout << endl;
}
