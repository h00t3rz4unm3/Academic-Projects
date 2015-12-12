/**
 * Created by alexandrugutu on 5/7/15.
 */

import java.util.*;
import java.util.concurrent.Semaphore;

public class Bathroom
	{
		Vector<Thread> lineOfStudents;
		boolean inUse;

		Semaphore bathroomInUse;

		Bathroom(int numOfStudents)
			{
				lineOfStudents = new Vector<Thread>(numOfStudents);
				inUse = false;

				bathroomInUse = new Semaphore(1, true);
			}

		protected void addStudent(Thread student)
			{
				lineOfStudents.add(student);
			}

		protected boolean getBathroomStatus()
			{
				return inUse;
			}

		protected void setBathroom(boolean yesNo)
			{
				inUse = yesNo;
			}

		public void useBathroom()
			{
				bathroomBeingUsed();

				System.out.println(Thread.currentThread().getName() + " is currently using the bathroom");

				try
					{
						Thread.sleep(new Random().nextInt(1000));
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				System.out.println(Thread.currentThread().getName() + " is done using the bathroom");

				bathroomNotBeingUsed();
			}

		protected synchronized void bathroomBeingUsed()
			{
				try
					{
						System.out.println("Take Bathroom permit");
						bathroomInUse.acquire();
					}
				catch (InterruptedException e)
					{
						System.out.println("Interrupt: " + Thread.currentThread().getName() + " is currently using the bathroom");
					}
			}

		protected synchronized void bathroomNotBeingUsed()
			{
				System.out.println("Release bathroom permit");
				bathroomInUse.release();
			}
	}
