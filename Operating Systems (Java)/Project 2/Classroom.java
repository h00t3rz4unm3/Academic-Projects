/**
 * Created by alexandrugutu on 5/7/15.
 */

import java.util.*;
import java.util.concurrent.Semaphore;

public class Classroom
	{
		public Semaphore getClassStudents;

		public static Semaphore class1Entrance;
		public static Semaphore class2Entrance;
		public static Semaphore class3Entrance;

		public static Semaphore class1Exit;
		public static Semaphore class2Exit;
		public static Semaphore class3Exit;

		boolean class1Started;
		boolean class2Started;
		boolean class3Started;

		int classCapacity;

		Classroom(int numOfStudents, int classCapacity)
			{
				class1Started = false;
				class2Started = false;
				class3Started = false;
				this.classCapacity = classCapacity;

				class1Entrance = new Semaphore(0, true);
				class2Entrance = new Semaphore(0, true);
				class3Entrance = new Semaphore(0, true);

				class1Exit = new Semaphore(0, true);
				class2Exit = new Semaphore(0, true);
				class3Exit = new Semaphore(0, true);
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

		boolean getClass1Status()
			{
				return class1Started;
			}

		boolean getClass2Status()
			{
				return class2Started;
			}

		boolean getClass3Status()
			{
				return class3Started;
			}
	}
