//
//  main.cpp
//  Homework 5
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
	
	cout << rosters;
	
    return 0;
}

