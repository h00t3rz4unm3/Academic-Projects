#### _Homework 4_
The aim of this homework assignment is to practice using a class written by someone else and use dynamic allocation. This homework assignment will also help build towards project 1, which will be to write a program implementing the Roster Management Program.
For this assignment, write a program that uses the class Date. As an added challenge, I will not provide you with the .cpp file for this class, rather, only the .o file, to which you can link your program for testing purposes.
Write a program that does the following:
1. Ask the user for a number that is going to be the size of the Date list.
2. Create a list of Date type by storing the date instances in the dynamic array and populate the array with user input.
3. Corresponding to each date there is a number that is between 1 to 9. The number is calculated in the following way: you add each digit of the day, month, and year and keep adding the digits of the answer until you get a single digit. Example: Feb 3, 2006  corresponds to (2 + 3 + 2 + 0 + 0 + 6)  = 13 => 1 + 3 = 4 
4. Create an array of integers that would store integer representation of the date instances stored in the Date array
5. Print out all the Dates and corresponding integers.
6. Make sure to delete the dynamically allocated arrays before terminating the program. 
Note that you do not need to know the implementation of the Date class.
