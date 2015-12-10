### _Assignment 3_

We mentioned during lecture that Arrays are limited in two specific ways:  
1) Their size is fixed and cannot be increased when needed.  
2) Inserting into a sorted array would require a lot of work.  

For this assignment you will create an object that will do the work to address both of these points.  


Create an object called GSSArray. (it stands for growable self-sorting array)

This object will manage an array of type int.
Create a private variable for an array of type int.
In the constructor for this object, take in an int value which will determine the starting size of the array.
The constructor should also instantiate the array.

Create a public method called insert, which will take in an int and find the location in the array where it belongs and insert it there.
If the array is full, then before inserting the value, method insert should call private method increaseSize, which will create a new array which is double the size of the current array. Then it will copy the values from the original array into the new array and set the private variable to this new array.

The array should keep track of how many of its indexes are filled. Create a private variable called lastindex which will be equal to the last index of the array that has a value.

Create a public method delete, which will take an int and if will remove the 1st instance of that number in the array. If the number doesn't exist, the method should return false, otherwise it should return true. (Don't forget to update variable lastindex in methods delete and insert.)

