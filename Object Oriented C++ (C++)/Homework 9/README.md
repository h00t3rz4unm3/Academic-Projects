#### _Homework 9_
The aim of this homework assignment is to practice writing recursive functions. 
For this homework assignment write two recursive functions: 
The first one receives a vector of File pointers and recursively outputs properties of every file stored inside this vector. 
void output(vector<File*> files);
The second function receives a vector of File pointers and a string which represents a type of the file (gif or txt). The function should return another vector of File pointers containing only Image files or Text files, depending on the second parameter. The function should be recursive. 
vector<File*> filter(vector<File*> files, string type);
