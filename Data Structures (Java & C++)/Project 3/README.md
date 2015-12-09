###Problem Statement:  
Create a Linked List  
Add words from input file into Linked List, keep it sorted using insertion sort  
Count how many occurrences of each word happen  
Print out results  
 
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
11. _last++_; _index_ <== _last_  
    // shift a block of array to the right one element at a time  
12. _array[index]_ <== _array[index - 1]_; _index--_  
13. repeat step 12 until _index_ < _spot_  
14. _array[spot]_ <== _data_  
15. Print _spot_, _last_ and the array from _array[0]_ to _array[last]_  
    // see below for the output format  
15. Repeat step 7 to step 14 until file is empty  
16. Close file  

###Linked List Algorithm
0. Prepare everything for the program  
1. _listHead_ <== create a Linked List with a dummy Node  
2. _data_ <== get a word from the input file  
3. _current_ <== _listHead_  
4. if _current.next_ != _NULL_ and if _current.next.data_ != _data_  
	_current_ = _current.next_  
5. Repeat step 4 until condition fails  
6. if _current.next_ != _NULL_ and if _current.next.data_ == _data_ ==> _current.next.count++_  
    else _newNode_ <- create a new Node with data, set counter to 1  
7. insert new Node after walker  
8. Repeat steps 2-6 until file is empty  


###Input:  
Please see the attached input: _wordstatisticdata1.txt_ and _wordstatisticdata2.txt_ 

_wordsstatisticdata1.txt_:  
I have finished coding the insertion sort with linkedlist. Would you mind sending out the data file that  
you want us to include with our programs or should we just use a dummy data file?  
I have finished coding the insertion sort with linkedlist. Would you mind sending out the data file that  
you want us to include with our programs or should we just use a dummy data file?  
For the next project, and there after, when you  submit the source code by email, please also cc your  
source code to my TA's email address:  
For the next project, and there after, when you  submit the source code by email, please also cc your  
source code to my TA's email address:  
For the next project, and there after, when you  submit the source code by email, please also cc your  
source code to my TA's email address:  
If you did not cc to my TA when you submit your projects,  
Please resubmit it again. Thanks!  
If you did not cc to my TA when you submit your projects,  
Please resubmit it again. Thanks!  
If you did not cc to my TA when you submit your projects,  
Please resubmit it again. Thanks!  
Attached is the source code for my programs.  
Attached is the source code for my programs.  
Attached is the source code for my programs.  

###Output:  
The dummy node has been omitted from printing for obvious reasons.  
(Attached, 3, For)  
(For, 3, I)  
(I, 2, If)  
(If, 3, Please)  
(Please, 3, TA)  
(TA, 3, TA's)  
(TA's, 3, Thanks!)  
(Thanks!, 3, Would)  
(Would, 2, a)  
(a, 2, address:)  
(address:, 3, after,)  
(after,, 3, again.)  
(again., 3, also)  
(also, 3, and)  
(and, 3, by)  
(by, 3, cc)  
(cc, 6, code)  
 
