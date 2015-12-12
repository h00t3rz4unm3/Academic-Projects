### Project 1 - Thread Synchronization

Through its implementation, this project will familiarize you with the creation and execution of threads, and with the use of the Thread class methods.  In order to synchronize the threads you will have to use: run( ), start( ), currentThread( ), getName( ), join( ), yield( ), sleep(time), isAlive( ), getPriority( ), setPriority( ), and interrupt( ) when necessary.  In synchronizing threads, do NOT use any semaphores, wait( ), notify( ) or notifyAll( ).  


Create num_Student student thread and one teacher thread.  


----------  

Students at the Blue College live in dorms.  In the morning, after the student wakes up (it will take a random time) he will head to the bathroom to get ready for a new school day.  If the bathroom is already taken, the student takes a break (use yield()) and later on he will wait (use busy waiting) for the bathroom to become available.  Students will use the bathroom in a First Come First Serve basis (you can use a Boolean array/vector for having them released in order).  Next, student(s) will move on to the auditorium.  If the class is already in session, the student(s) will leave for a while (sleep(random time)) and walk around the campus doing some errands.    If the class is not in session yet, student(s) will wait for the teacher to arrive and open the auditorium door (use busy wait).  Once the teacher opens the auditorium, students can get in. The class is now in session, the students that entered the auditorium will wait for the class to end (use sleep(for a long time) such that they will have to be interrupted).  When the class ends, the teacher will interrupt() the student(s). Students will leave the classroom and hurry up to have some fun between classes (simulate this by having the student increase his priority. Next he will sleep(random time) and when woken up he will set his priority back to default value (use getPriority( ), setPriority()).   

 
The teacher teaches three classes.  Each class takes a fixed amount of time.  Between any two classes there is a break.  The break between the second and third class is longer (doubled) due to office hours.   


The school closes after the three classes end.  A daily report with information about what classes and when each student attended throughout the day must be displayed.  Something like: Student Name   Total Number of classes taken    Class Name (or number) 


When the school day ends, students go back to their dorms.  Each student will join another student; they will leave in sequential order. Student N joins with student N-1, student N-1 joins with N-2, …, student 2 joins with student 1 (use join( ), isAlive( )).  

----------  

Using Java programming, synchronize the two types of threads, student, teacher, in the context of the problem.  Closely follow the implementation requirements.  

Choose appropriate amount of sleep time(s) that will agree with the content  of the story. 

----------  

**Guidelines**  

1. Do not submit any code that does not compile and run. If there are parts of the code that contain bugs, comment it out and leave the code in. A program that does not compile nor run will not be graded.  2. Follow all the requirements of the Project’s description.  3. Main class is run by the main thread. The other threads must be manually specified by either implementing the Runnable interface or extending the Thread class. Separate the classes into separate files.  Do not leave all the classes in one file.  Create a class for each type of thread.   
4. The program asks you to create two different types of thread – student and teacher threads. For student thread type, there is more than one instance of the thread.  No manual specification of each thread's activity is allowed (e.g. no Student1.doErrands()).   
5. Add the following lines to all the threads you make:  
```Java 
        public static long time = System.currentTimeMillis();     
        public void msg(String m)  
        {  
            System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);  
        }
 ```  
6. There should be printout messages indicating the execution interleaving. Whenever you want to print something from that thread use: msg("some message here");    
7.  NAME YOUR THREADS or the above lines that were added would mean nothing. Here's how the constructors could look like (you may use any variant of this as long as each thread is unique and distinguishable):  
// Default constructor public RandomThread(int id) {      setName("RandomThread-" + id); }  
8. Design an OOP program. All thread-related tasks must be specified in its respective classes, no class body should be empty. An example demonstrating this is as follows:   
public Student implements Runnable {   public void waitLecture() { … } …   public void run() { … waitLecture(); … }  }   
9. No implementation of semaphores or use of wait( ), notify( ) or notifyAll( ) are allowed.  10. Thread.sleep() is not busy wait.   while (expr) {..} is busy wait.  
11. "Synchronized" is not FCFS implementation. “Synchronized” keyword in Java allows a lock on the method or on an object, any thread that accesses the lock first will control that block of code; it is used to enforce mutual exclusion on the critical section.  FCFS should be implemented in queue or other data structure.  
12. DO NOT USE System.exit(0); the threads are supposed to terminate naturally by running to the end of their run methods.  
13.  Command line arguments must be implemented to allow changes to the num_student  
14.  Javadoc is not required. Proper basic commenting explaining the flow of program, self-explanatory variable names, correct whitespace and indentations are required. 
