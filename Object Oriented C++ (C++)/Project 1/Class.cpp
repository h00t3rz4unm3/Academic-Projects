//
//  Class.cpp
//  Project 1
//
//  Created by Alexandru Gutu on 12/8/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <string>
#include <fstream>

#include "Class.h"

using namespace std;

// Default Constructor with defualt values
Class::Class()
{
	course_name = "N/A";
	course_code = 0000;
	credits = 0;
	instructor = "N/A";
	size = 10;
	counter = 0;
	list = new Students*[size];
}

// Inline Constructor
Class::Class(string cn, int cc, int c, string i, int s, int count)
{
	course_name = cn;
	course_code = cc;
	credits = c;
	instructor = i;
	size = s;
	counter = count;
	list = new Students*[size];
	sort(list, counter);
}

Class::~Class()
{
	for (int i = 0; i < counter; i++)
	{
		delete list[i];
	}
	delete [] list;
}

Class::Class(const Class& other)
{
	size = other.size;
	counter = other.counter;
	list = new Students*[size];
	
	for (int i = 0; i < size; i++)
	{
		list[i] = new Students(*(other.list[i]));
	}
}

// Grow Function
void Class::grow()
{
	Students** temp = list;
	list = new Students*[size*2];

	for (int i = 0; i < counter; ++i){
		list[i] = temp[i];
	}
	delete [] temp;
	size = size * 2;
}

//================================================

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

//================================================

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

int Class::getCounter()
{
	return counter;
}

//================================================

// Add student function
void Class::addStudent()
{
	cout << "Add Student " << counter << ": " << endl;
	if (counter >= size)
	{
		grow();
	}
	
	list[counter] = new Students;
	list[counter]->input();
	
	counter++;
	sort(list, counter);
}

void Class::addStudent(string f, string l, int s, int c, double g, Date d, Date m)
{

	if (counter >= size)
	{
		grow();
	}
	list[counter] = new Students(f, l, s, c, g, d, m);
	counter++;
	
	sort(list, counter);
}

// Remove student function
void Class::removeStudent()
{
	string fn, ln;
	
	cout << "Remove a Student: " << endl;
	cout << "Please enter a first name: ";
	cin >> fn;
	cout << "Please enter a last name: ";
	cin >> ln;
	cout << endl;
	
	string ftemp;
	int lengthf = fn.size();
	for(int i = 0; i < lengthf; i++)
	{
		ftemp += toupper(fn[i]);
	}
	fn = ftemp;
	
	string ltemp;
	int lengthl = ln.size();
	for(int i = 0; i < lengthl; i++)
	{
		ltemp += toupper(ln[i]);
	}
	ln = ltemp;
	
	for (int i = 0; i < counter; i++)
	{
		if (fn == list[i]->getFirstName() && ln == list[i]->getLastName())
		{
			for (int j = i; j < counter-1; j++)
				list[j] = list[j+1];
		}
	}
	counter--;
}

// Function to find student
void Class::findStudent()
{
	string fn, ln;
	
	cout << "Find a Student: " << endl;
	cout << "Please enter a first name: ";
	cin >> fn;
	cout << "Please enter a last name: ";
	cin >> ln;
	cout << endl;
	
	string ftemp;
	int lengthf = fn.size();
	for(int i = 0; i < lengthf; i++)
	{
		ftemp += toupper(fn[i]);
	}
	fn = ftemp;
	
	string ltemp;
	int lengthl = ln.size();
	for(int i = 0; i < lengthl; i++)
	{
		ltemp += toupper(ln[i]);
	}
	ln = ltemp;
	
	for (int i = 0; i < counter; i++)
		if (fn == list[i]->getFirstName() && ln == list[i]->getLastName())
			list[i]->output();

	cout << endl;
}

// Function to update student information
void Class::updateStudent()
{
	string fn, ln;
	
	cout << "Update a Student: " << endl;
	cout << "Please enter a first name: ";
	cin >> fn;
	cout << "Please enter a last name: ";
	cin >> ln;
	cout << endl;
	
	string ftemp;
	int lengthf = fn.size();
	for(int i = 0; i < lengthf; i++)
	{
		ftemp += toupper(fn[i]);
	}
	fn = ftemp;
	
	string ltemp;
	int lengthl = ln.size();
	for(int i = 0; i < lengthl; i++)
	{
		ltemp += toupper(ln[i]);
	}
	ln = ltemp;
	
	for (int i = 0; i < counter; i++)
		if (fn == list[i]->getFirstName() && ln == list[i]->getLastName())
		{
			cout << "1) First Name" <<
					"\n2) Last Name" <<
					"\n3) Student ID" <<
					"\n4) Credits" <<
					"\n5) GPA" <<
					"\n6) Date of Birth" <<
					"\n7) Date of Matriculation" << endl;
			cout << "\n\nWhat field would you like to modify: ";
			
			int answer;
			
			cin >> answer;
			
			switch (answer)
			{
				case 1:
				{
					string newFname;
					cout << "New First Name: ";
					cin >> newFname;
					list[i]->setFirstName(newFname);
					break;
				}
				case 2:
				{
					string newLname;
					cout << "New Last Name: ";
					cin >> newLname;
					list[i]->setLastName(newLname);
					break;
				}
				case 3:
				{
					int newSID;
					cout << "New Student ID: ";
					cin >> newSID;
					list[i]->setSID(newSID);
					break;
				}
				case 4:
				{
					int newCredits;
					cout << "New Credits: ";
					cin >> newCredits;
					list[i]->setCredits(newCredits);
					break;
				}
				case 5:
				{
					int newGPA;
					cout << "New GPA: ";
					cin >> newGPA;
					list[i]->setGPA(newGPA);
					break;
				}
				case 6:
				{
					Date newDOB;
					cout << "New Date of Birth: " << endl;
					newDOB.input();
					list[i]->setDOB(newDOB);
					break;
				}
				case 7:
				{
					Date newMdate;
					cout << "New Date of Matriculation: " << endl;
					newMdate.input();
					list[i]->setMDate(newMdate);
				}
					
				default:
					break;
			}
		}
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
	cout << endl << endl;
	
	for (int i = 0; i < counter; i++)
	{
		list[i]->output();
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
	
	for (int i = 0; i < size; i++)
	{
		list[i]->output();
		cout << endl;
	}
}

// Prints students to file
void Class::printtofile()
{
	ofstream fileOutput;
	fileOutput.open("outputtest.txt", ios::app);
	fileOutput << getCoursename() << "|" << getCoursecode() << "|" << getCredits() << "|" << getInstructor() << "|" << endl; 
	for (int i = 0; i < counter; i++)
		fileOutput << list[i]->getFirstName() << "|" << list[i]->getLastName() << "|" << list[i]->getSID() << "|" << list[i]->getCredits() << "|" << list[i]->getGPA() << "|" << list[i]->getDOB() << "|" << list[i]->getMDate() << "|" << endl;
	fileOutput << "|end_roster|" << endl;
	fileOutput.close();
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
	cout << "Instructor: ";
	cin >> instructor;
	cout << endl;
}

ostream& operator<< (ostream& output, const Class& x)
{
	output	<< "Print All Students: " << endl
	<< "Course Name: " << x.course_name << endl
	<< "Course Code: " << x.course_code << endl
	<< "Credits: " << x.credits << endl
	<< "Instructor: " << x.instructor << endl << endl;
	
	for (int i = 0; i < x.counter; i++)
	{
		x.list[i]->output();
		cout << endl;
	}
	return output;
}

istream& operator>> (istream& input, Class& x)
{
	cout << "Course Name: ";
	input >> x.course_name;
	cout << "Course Code: ";
	input >> x.course_code;
	cout << "Credits: ";
	input >> x.credits;
	cout << "Instructor: ";
	input >> x.instructor;
	cout << endl;
	return input;
}

Class& Class::operator= (const Class& rightside)
{
	if (this == &rightside)
		return *this;
	else
	{
		
		for (int i = 0; i < counter; i++)
		{
			delete list[i];
		}
		delete [] list;
		
		size = rightside.size;
		counter = rightside.counter;
		list = new Students*[size];
		for (int i = 0; i < size; i++)
		{
			list[i] = new Students(*(rightside.list[i]));
		}
		return *this;
	}
}

// Function to sort
void Class::sort(Students** a, int size)
{
	for (int i = 0; i < size - 1; i++)
	{
		int indexOfSmallest = i;
		for (int j = i+1; j < size; j++)
		{
			if (a[j] < a[indexOfSmallest])
				indexOfSmallest = j;
		}
		if (i != indexOfSmallest)
		{
			Students* temp = a[i];
			a[i] = a[indexOfSmallest];
			a[indexOfSmallest] = temp;
		}
	}
}