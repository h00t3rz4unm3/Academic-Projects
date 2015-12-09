//
//  main.cpp
//  Project 1
//
//  Created by Alexandru Gutu on 12/8/13.
//  Copyright (c) 2013 Alexandru Gutu. All rights reserved.
//

#include "Students.h"
#include "Class.h"
#include "Date.h"

#include <string>
#include <sstream>
#include <fstream>

using namespace std;

void admin();
void adminmode();
void adminmode2();
void usermode();
void incorrectinput();
string line;
string username, password;
string usernamedb, passworddb;
int input = 0;
static int course_code = 000;
static int rostercounter = 0;
bool adminstatus = false;
static bool course = true;
Class** roster = new Class*[rostercounter];

int main()
{
	{
	ifstream myroster("rosters.txt");
	if (myroster.fail())
	{
		cout << "File could not be opened Please try again." << endl << endl;
		return 0;
	}
	while (course == true)
	{
		string coursetitle, coursecode, coursecredits, courseinstructor;
		string fname, lname, sid, credits, gpa;
		string dobm, dobd, doby, mdm, mdd, mdy;
		
		getline(myroster, coursetitle, '|');
	if (myroster.eof()) { break; }
		getline(myroster, coursecode, '|');
		getline(myroster, coursecredits, '|');
		getline(myroster, courseinstructor);
		roster[rostercounter] = new Class(coursetitle, atoi(coursecode.c_str()), atoi(coursecredits.c_str()), courseinstructor, 1, 0);
		course = false;
		while(course == false)
		{
			getline(myroster, fname, '|');
			if (fname == "end_roster")
			{
				string ignore;
				getline(myroster, ignore);
				rostercounter++;
				course = true;
				break;
			}
			getline(myroster, lname, '|');
			getline(myroster, sid, '|');
			getline(myroster, credits, '|');
			getline(myroster, gpa, '|');
			getline(myroster, dobm, '/');
			getline(myroster, dobd, '/');
			getline(myroster, doby, '|');
			getline(myroster, mdm, '/');
			getline(myroster, mdd, '/');
			getline(myroster, mdy);
			roster[rostercounter]->addStudent(fname, lname, atoi(sid.c_str()), atoi(credits.c_str()), atof(gpa.c_str()), Date(atoi(dobm.c_str()), atoi(dobd.c_str()), atoi(doby.c_str())), Date(atoi(mdm.c_str()), atoi(mdd.c_str()), atoi(mdy.c_str())));
		}
	}
	}	// File Input
	
	{
	for (int i = 0; i < rostercounter; i++)
	{
		cout << i << ": ";
		roster[i]->printClass();
		cout << endl;
	}
	
	cout << "Rostercounter: " << rostercounter << endl << endl;
	
	//roster[rostercounter-1]->~Class();
	
	for (int i = 0; i < rostercounter; i++)
	{
		cout << i << ": ";
		roster[i]->printAllStudents();
		cout << endl;
	}
	}	// PrePrint info
	
	
	for (int i = 0; i < rostercounter; i++)
	{
		roster[i]->printtofile();
	}

	
	cout << "Welcome to the Gutu Roster Management System." << endl;
	cout << "\n 1. Administrator Mode";
	cout << "\n 2. User Mode";
	cout << "\n 3. Exit";
	cout << "\n\nPlease choose one of the options above (1-3): " << endl;
	cin >> input;
	
	switch (input)
	{
		case 1:
		{
			cout << "\n\n In order to use this mode, you need to log in.";
			cout << "\n\nPlease enter your username: ";
			cin >> username;
			cout << "Please enter your password: ";
			cin >> password;
			ifstream myfile("database.txt");
			while (!myfile.eof())
			{
				myfile >> usernamedb >> passworddb;
			}
			if (username == usernamedb && password == passworddb)
			{
				adminstatus = true;
				cout << "\nLogin successful!\n\n";
			}
			else if (adminstatus == false)
			{
				cout << "\nLogin unsuccessful. Please try again.\n\n";
			}
			myfile.close();
			
			if (adminstatus == false)
			{
				return 0;
			}
			
			cout << "Administrator Mode";
			
			cout << "\n\n 1. Create a new Roster";
			cout << "\n 2. Drop a Roster by Course Number";
			cout << "\n 3. Display Roster information by Course Number";
			cout << "\n 4. Display all Rosters in the system";
			cout << "\n 5. Select a Roster to perform a series of operations";
			
			cout << "\n\nPlease choose one of the options above: ";
			
			cin >> input;
			
			switch (input)		// Admin Mode
			{
				case 1:			// Create new Roster
				{
					roster[rostercounter] = new Class();
					rostercounter++;
					
					for (int i = 0; i < rostercounter; i++)
					{
						cout << i << ": ";
						roster[i]->printClass();
						cout << endl;
					}
				}
					break;
					
				case 2:				// Drop a roster
				{
					cout << "Please enter the course number of the roster you'd like to drop: ";
					cin >> course_code;
					for (int i = 0; i < rostercounter; i++)
						if (roster[i]->getCoursecode() == course_code)
						{
							Class* temp;
							for (int j = i; j < rostercounter; j++)
								
							{
								temp = roster[j];
								roster[j] = roster[j+1];
								roster[j+1] = temp;
							}
							roster[rostercounter]->~Class();
							delete roster[rostercounter];
							rostercounter--;
						}
					
						else
						{
							cout << "No matching course found." << endl <<endl;
						}
				}
					break;
					
				case 3:					// Display Roster info by course number
				{
					cout << "Please enter a course code you'd like to view more information on: " << endl;
					cin >> course_code;
					for (int i = 0; i < rostercounter; i++)
					{
						cout << "Course information: " << endl;
						
						if (course_code == roster[i]->getCoursecode())
							roster[i]->printClass();
						else
							cout << "No matching records. Please try again." << endl;
						break;
					}
				}
					break;
					
				case 4:					// Display all roasters in the system
				{
					for (int i = 0; i < rostercounter; i++)
					{
						roster[i]->printClass();
						cout << endl;
					}
				}
					break;
					
				case 5:					// Select a roster to perform a series of operations
				{
					adminmode2();
				}
					break;
					
				default:
					incorrectinput();
					break;
			}
			
		}
			break;
			
		case 2:
		{
			cout << "User Mode.";
			
			cout << "\n 1. Insert new Student to a Roster";
			cout << "\n 2. Remove a Student from a Roster";
			cout << "\n 3. Update a Student in a Roster";

			cin >> input;
			
			cout << "Please enter the course code of the class you'd like to modify: ";
			cin >> course_code;
			
			cout << "\n\n Please choose one of the options above: " << endl;
			
			for (int i = 0; i < rostercounter; i++)
			{
				if (course_code == roster[i]->getCoursecode())
				{
					switch (input)
					{
						case 1:
							roster[i]->addStudent();		// Add a student
							break;
							
						case 2:
							roster[i]->removeStudent();		// Remove a student
							break;
							
						case 3:
							roster[i]->updateStudent();		// Update a student
							break;
							
						default:
							cout << "Incorrect input, please try again.\n";
							break;
					}
				}
			}
		}
			break;
		
		case 3:
			return 0;
			
		default:
			break;
	}
	
		
}

void adminmode()
{
	cout << "Administrator Mode";
	
	cout << "\n 1. Create a new Roster";
	cout << "\n 2. Drop a Roster by Course Number";
	cout << "\n 3. Display Roster information by Course Number";
	cout << "\n 4. Display all Rosters in the system";
	cout << "\n 5. Select a Roster to perform a series of operations";
	
	cout << "\n\nPlease choose one of the options above: ";
}

void adminmode2()
{
	cout << "Please enter the course code of the class you'd like to modify: ";
	cin >> course_code;
	for (int i = 0; i < rostercounter; i++)
	{
		if (course_code == roster[i]->getCoursecode())
		{
			cout << "\n 1. Insert a new Student to Roster";
			cout << "\n 2. Remove a Student from Roster";
			cout << "\n 3. Update a Student in Roster";
			cout << "\n 4. List all Students in a Roster in sorted order";
			cout << "\n\n Please choose one of the options above: ";
			cin >> input;
			
			switch (input)
			{
				case 1:
					roster[i]->addStudent();
					break;

				case 2:
				{
					roster[i]->removeStudent();
					break;
				}

				case 3:
				{
					roster[i]->updateStudent();
					break;
				}
					
				case 4:
				{
					roster[i]->printAllStudents();
				}
				
				default:
					incorrectinput();
			}
		}
			
		else
			cout << "No matching records. Please try again." << endl;
		break;
	}
}
void usermode()
{
	cout << "User Mode.";
	
	cout << "\n 1. Insert new Student to a Roster";
	cout << "\n 2. Remove a Student from a Roster";
	cout << "\n 3. Update a Student in a Roster";
}

void incorrectinput()
{
	cout << "Incorrect input, please try again.\n";
}

void admin()
{
	cout << "\n\n In order to use this mode, you need to log in.";
	cout << "\n\nPlease enter your username: ";
	cin >> username;
	cout << "Please enter your password: ";
	cin >> password;
	ifstream myfile("database.txt");
	while (!myfile.eof())
	{
		myfile >> usernamedb >> passworddb;					// input username and password from .txt file
	}
	if (username == usernamedb && password == passworddb)	// Compare input data with data in file
	{
		adminstatus = true;									// bool true if valid
		cout << "\nLogin successful!\n\n";
	}
	else if (adminstatus == false)							// false if invalid
	{
		cout << "Login unsuccessful. Please try again.\n";
	}
	myfile.close();
}
