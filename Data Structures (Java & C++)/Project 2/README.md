###Problem Statement: 
1-D array implementation of the Insertion Sort  
    Define a Node class that include:  
      - a string variable, named strData  
      - a node pointer, named next  
      - one or two node constructors  

Define a linkedList class that include:  
    - a node pointer, named listHead  
    - a linkedList constructor  
 
###Insertion Sort Algorithm  
0. Initializing everything for processing.  
1. Open the input file for reading.  
2. Count <== Read and count the number of data elements in the file  
3. Close the file  
4. Dynamic allocate a 1-D integer array the size of count  
5. Reopen the file  
6. _last_ <== 0  
7. _data_ <== get a date from the input file  
8. _array[last]_ <== _data_  
9. _data_ <== get data from the input file  
10. _spot_ <== find the index where _array[spot]_ > _data_  
11. _last++_  
         _index_ <== _last_  
    // shift a block of array to the right one element at a time  
12. _array[index]_ <== _array[index - 1]_; _index--_  
13. repeat step 12 until _index_ < _spot_  
14. _array[spot]_ <== _data_  
15. Print _spot_, _last_ and the array from _array[0]_ to _array[last]_  
    // see below for the output format  
15. Repeat step 7 to step 14 until file is empty  
16. Close file  


###Input:  
99  
88  
70  
999  
12 33  
14  
5 21 3    

###Output:   
**Last: 1 | Data: 88 | Spot: 0**  
88 99  

**Last: 2 | Data: 70 | Spot: 0**  
70 88 99  

**Last: 3 | Data: 999 | Spot: 3**  
70 88 99 999  

**Last: 4 | Data: 12 | Spot: 0**  
12 70 88 99 999  

**Last: 5 | Data: 33 | Spot: 1**  
12 33 70 88 99 999  

**Last: 6 | Data: 14 | Spot: 1**  
12 14 33 70 88 99 999  

**Last: 7 | Data: 5 | Spot: 0**  
5 12 14 33 70 88 99 999  

**Last: 8 | Data: 21 | Spot: 3**  
5 12 14 21 33 70 88 99 999  

**Last: 9 | Data: 3 | Spot: 0**  
3 5 12 14 21 33 70 88 99 999  
 
