/**
 * Created by alexandrugutu on 5/17/15.
 */

import java.util.concurrent.Semaphore;

public class DiningRoom
	{
		Semaphore tableCapacity;
		Semaphore numTables;
		Semaphore cafeteriaOpen;
		Semaphore tellTeacher;

		Semaphore groupLeaving;
		Semaphore teacherAssign;

		int groupSize;
		int numberOfTables;
		volatile int studentsInCafeteria;
		volatile int currentGroupSize;
		volatile int numberOfTablesAvailable;

		DiningRoom(int tableCapacity, int numTables)
			{
				groupSize = tableCapacity;
				numberOfTables = numTables;

				this.tableCapacity = new Semaphore(tableCapacity, true);
				this.numTables = new Semaphore(numTables, true);
				cafeteriaOpen = new Semaphore(main.numOfStudents, true);
				cafeteriaOpen.drainPermits();

				groupLeaving = new Semaphore(tableCapacity, true);

				teacherAssign = new Semaphore(tableCapacity, true);
				teacherAssign.drainPermits();

				tellTeacher = new Semaphore(0, true);

				currentGroupSize = 0;
				studentsInCafeteria = 0;
			}

		public synchronized void openCafeteria()
			{
				cafeteriaOpen.release(main.numOfStudents);
			}

		public void increaseCurrentGroupSize()
			{
				currentGroupSize++;
			}

		public int getCurrentGroupSize()
			{
				return currentGroupSize;
			}

		public boolean isReadyToSit()
			{
				if (currentGroupSize == groupSize)
					{
						return true;
					}
				else
					{
						return false;
					}
			}

		public void increaseTablesAvailable()
			{
				numberOfTablesAvailable++;
			}

		public void decreaseTablesAvailable()
			{
				numberOfTablesAvailable--;
			}

		public void resetGroups()
			{
				currentGroupSize = 0;
			}
	}
