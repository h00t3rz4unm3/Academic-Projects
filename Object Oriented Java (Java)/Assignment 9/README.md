### _Assignment 8_

Create a new Node class called Node3, which should behave the same as either the Node or Node 2 class that we have already created, except that the data type in your Node3 class should be a generic. Also create a class LinkedList3 which should behave the same as either the LinkedList or LinkedList2 class that we have already created, except that it should use your new Node3 class and therefore be generic. (It doesnt matter whether you choose 1 or 2, so long as you are consistent between the classes)

The LinkedList3 and Node3 classes should have the same functionality as the original classes. Feel free to copy and paste code from those pre-existing classes and then make whatever adjustments you need to make.

Then create in a _main_ method, 3 instances of your LInkedList3 class:  
**1.** one that stores int values as its data types  
**2.** another that stores Strings  
**3.** another that stores objects of type Node3  

**NOTE**  
In our methods we compared int values during some of the methods in LinkedList.
String class has comparison methods built in. Use the java API to remind yourself how they are used. 
The third data type is the new object that you are creating now. In order to enable simple comparisons to be made, I want you to have this new object implement the interface Compareable. Review the slide show on blackboard on generics, which will give you hints about this interface. Also, use the java API for help.
You may use any comparison algorithm you like, even a random or arbitrary one. (generally these would be very bad comparisons, but they are fine for this assignment)
