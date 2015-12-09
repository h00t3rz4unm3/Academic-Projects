###Problem Statement:  
1. Suppose we are given a data file (data1.txt) which contains integers. We are interested to know:
  a. How many integers in data.txt
  b. The largest integer in data.txt
  c. The smallest integer in data.txt
  d. The average of all the integers in data.txt


###Algorithm:  
1) Prepare everything that is needed (open files, import, etc)  
2) Initialize all variables  
3) Read data from file, one integer at a time  
4) Assume data is integers and  
    a. Increase count variable  
    b. Add input to sum variable  
    c. Use if statement to compare input to highest value so far  
    d. Use if statement to compare input to lowest value so far  
5)Repeat steps 3-4 until all data is read  
6)Compute average  
7)Display to console:  
    a.Count  
    b.largest  
    c.Smallest  
    d.Average  


###Input:  
91 322 702  
9999  
12 133  
4152 213  
23 1724  
825 127 538 29 -91 92 93  
730  
361  
637 2255  
213  
388 99  
322  
739  
16 -702  
95 588  
3999 9599  
945  
818 19 420  
538 32 -935 834 35 361 637  


###Output:  
**There are:** 43 integers  
**The minimum is:** -935  
**The maximum is:** 9999  
**The average is:** 977.3720930232558  
