#### _Project 1_
Implement a Roster Management Program using the classes that you developed in homework assignments 2-6. The program should be command-line interfaced.
In Roster Management Program you will have two Modes: “Supervisor Mode” and “User Mode”.
In “Supervisor Mode” you have options to: 
1)	Create a new Roster (that will be stored in a growable array of Rosters in your main program)
2)	Drop a Roster (selected by course number)
3)	Display Roster information (selected by course number)
4)	Display all Rosters (in your system)
5)	Select a Roster to perform following operations:
a) Insert new Student to a Roster
b) Remove a Student from a Roster
c) Update a Student in a Roster
d) List all Students in one Roster in sorted order
In a “User Mode” you can only do the following: 
1) Select a Roster to perform following operations:
    a) Insert new Student to a Roster
    b) Remove a Student from a Roster 
    c) Update a Student in a Roster

In Main menu you will have following options:
A) Supervisor Mode that will be password protected. The user can be authenticated against a database.txt file entries which would contain user/password pair
B) User Mode
C) Exit 
Note: When you start off the program the rosters must be read in from a file called rosters.txt. When you exit a program the rosters must be stored back to a file called rosters.txt. Internally in your program rosters are stored in a growable array of rosters.
The format of the rosters.txt file is:
course1-name | course1-code | number-credits | professor-name
student1 first name | student1 last name|sid|standing|credits|gpa|mm/dd/yyyy|mm/dd/yyyy
student2 first name | student2 last name|sid|standing|credits|gpa|mm/dd/yyyy|mm/dd/yyyy
end_roster|
course2-name | course2-code | number-credits | professor-name
student1 first name | student1 last name|sid|standing|credits|gpa|mm/dd/yyyy|mm/dd/yyyy
end_roster|
