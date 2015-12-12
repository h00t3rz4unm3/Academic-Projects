
/**
 * Created by alexandrugutu on 4/27/15.
 */

import java.util.*;

public class Classroom
	{
		Vector<Thread> studentsInClass;
		Iterator<Thread> classIterator;

		private static boolean class1Started;
		private static boolean class2Started;
		private static boolean class3Started;
		private static boolean class1Finished;
		private static boolean class2Finished;
		private static boolean class3Finished;

		Classroom(int numOfStudents)
			{
				studentsInClass = new Vector(numOfStudents);
				class1Started = false;
				class2Started = false;
				class3Started = false;
				class1Finished = false;
				class2Finished = false;
				class3Finished = false;
			}

		void setClass1Started(boolean yesNo)
			{
				class1Started = yesNo;
			}

		void setClass2Started(boolean yesNo)
			{
				class2Started = yesNo;
			}

		void setClass3Started(boolean yesNo)
			{
				class3Started = yesNo;
			}

		void setClass1Finished(boolean yesNo)
			{
				class1Finished = yesNo;
			}

		void setClass2Finished(boolean yesNo)
			{
				class2Finished = yesNo;
			}

		void setClass3Finished(boolean yesNo)
			{
				class3Finished = yesNo;
			}

		boolean getClass1StartStatus()
			{
				return class1Started;
			}

		boolean getClass2StartStatus()
			{
				return class2Started;
			}

		boolean getClass3StartStatus()
			{
				return class3Started;
			}

		boolean getClass1FinishedStatus()
			{
				return class1Finished;
			}

		boolean getClass2FinishedStatus()
			{
				return class2Finished;
			}

		boolean getClass3FinishedStatus()
			{
				return class3Finished;
			}

		synchronized protected void addStudent(Thread student)
			{
				studentsInClass.add(student);
			}

		protected void clearRoster()
			{
				studentsInClass.clear();
			}

		protected void interruptClass()
			{
				classIterator = studentsInClass.iterator();

				while (classIterator.hasNext())
					{
						System.out.println(classIterator.next().getName());
					}


				while (!studentsInClass.isEmpty())
					{
						studentsInClass.firstElement().interrupt();
						studentsInClass.remove(0);
					}

			}
	}
