//
//  main.cpp
//  Homework 3
//
//  Created by Alexandru Gutu on 10/15/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include "Students.h"
#include "Class.h"

using namespace std;

int main()
{
	
	Class Test;
	
	// Obtains the class information
	Test.input();
	cout << endl;
	
	// Adds a student
	Test.addStudent();
	cout << endl;
	
	// Adds a student
	Test.addStudent();
	cout << endl;
	cout << endl;
	
	cout << "======================================" << endl;
	// Prints all info
	Test.printAll();
	cout << endl;
	
	cout << "======================================" << endl;
	// Finds a student
	Test.findStudent();
	cout << endl;
	
	cout << "======================================" << endl;
	// Removes a student
	Test.removeStudent();
	cout << endl;
	cout << endl;
	
	cout << "======================================" << endl;
	// Prints Students only
	Test.printAllStudents();
	
    return 0;
	
}

