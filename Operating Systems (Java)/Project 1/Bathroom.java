
/**
 * Created by alexandrugutu on 4/25/15.
 */

import java.util.Random;
import java.util.Vector;

public class Bathroom
	{
		Vector<Thread> lineOfStudents;
		boolean inUse;

		Bathroom(int numOfStudents)
			{
				lineOfStudents = new Vector<Thread>(numOfStudents);
				inUse = false;
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
				setBathroom(true);
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
				removeStudent();
				setBathroom(false);
			}

		protected void removeStudent()
			{
				lineOfStudents.remove(0);
			}
	}
