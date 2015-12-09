//
//  main.cpp
//  Homework 6
//
//  Created by Alexandru Gutu on 11/21/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include <iostream>
#include <string>

#include "Students.h"
#include "Class.h"
#include "Date.h"

using namespace std;

int main()
{
	
	Class rosters;
	rosters.input();
	rosters.addStudent();
	rosters.addStudent();
	
//	rosters.findStudent();
//	rosters.removeStudent();
	
	
	cout << endl << endl << endl;
	
	cout << rosters;
	
    return 0;
}

