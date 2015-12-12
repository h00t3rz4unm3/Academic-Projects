### Project 2 - Thread Synchronzation using Semaphores

The project must be done individually without any help.  No exceptions. You are asked to synchronize the two types of threads (Student and Teacher) of the following story using semaphores and operations on semaphores.   Do NOT use busy waiting. Do NOT use synchronized methods (beside the operations on semaphores).   Do NOT use wait( ), notify( ) or notifyAll( ) as monitor methods.  Use the semaphore class and its methods only.  

You should keep the concurrency of the threads as high as possible, however the access to shared structures has to be done in a Mutual Exclusive fashion, using a mutex semaphore.  

Many of the activities can be simulated using sleep(of a random time) method.  

Use appropriate System.out.println( ) statements to reflect the time of each particular action done by a specific thread. This is necessary for us to observe how the synchronization is working.  
The number of threads should be read as command line arguments.  
```
    Default values: 
        Num_Students = 15; 
        TableCapacity = 4; 
        numTables = 3;  
```

Students at the Blue College live in dorms.  In the morning, after the student wakes up (it will take a random time) he will head to the bathroom to get ready for a new school day.  If the bathroom is already taken, the student will **wait** for the bathroom to become available.   

Next, student(s) will move on to the auditorium.  The student(s) will **wait** for the teacher to arrive and enter the auditorium. If the class is in session the student will leave (use **sleep(random time)**) and come back later. Once the teacher enters the auditorium, he will **signal** the waiting students.  The class is now in session, the students that entered the auditorium will wait for the class to end.   

Once having arrived at the school the teacher will teach three classes.  Each class takes a fixed amount of time.  Between any two classes there is a break.  The break between the second and third class is longer (doubled) due to office hours.   
When all three classes end, students and teacher will head on to the cafeteria to have dinner.  Students will sit at the table in groups of **TableCapacity**.  Initially there are **numTables** tables available.  

Students group in groups of size **TableCapacity**.  Once a group is formed if there is an available table the group will occupy the table.  If there is no table available the students of the group will **wait** _until the teacher assigns_ the next available table. The students leave the table in the order in which they took the table.   

Initially, there are no students at the cafeteria.  

Next, students go back to their dorms.  Once arrived at the dorms the student will terminate.  The last student to arrive at the dorm will let the teacher know that he can terminate as well (use semaphores). 
A daily report with information about what classes and when each student attended throughout the day must be displayed.  Something like:  

Student Name   Total Number of classes taken    Class Name (or number)     
