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
