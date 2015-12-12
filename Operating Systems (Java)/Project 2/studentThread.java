/**
 * Created by alexandrugutu on 5/7/15.
 */

import java.util.*;

public class studentThread extends Thread
	{
		public boolean waitingForClass;
		public boolean usedBathroom;
		public long startTime;

		public long class1Start;
		public long class2Start;
		public long class3Start;

		public int classCount;
		public int scheduleCount;

		studentThread(String threadName)
			{
				super(threadName);
				System.out.println(this);

				waitingForClass = false;
				usedBathroom = false;
				classCount = 0;
				scheduleCount = 0;

				startTime = System.currentTimeMillis();

				start();
			}

		studentThread()
			{
				super();
				System.out.println(this);

				waitingForClass = false;
				usedBathroom = false;
				classCount = 0;
				scheduleCount = 0;

				startTime = System.currentTimeMillis();

				start();
			}

		protected void printMessage(String message)
			{
				System.out.println("[" + (System.currentTimeMillis() - startTime) + "] " + getName() + ": " + message);
			}

		protected void wakeUp()
			{
				try
					{
						Thread.sleep(new Random().nextInt(4000));
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				printMessage("woke up. Going to the bathroom!");
			}

		protected void useBathroom()
			{
				main.bathroom.useBathroom();
			}

		protected void goToClass(int classNumber)
			{
				if (classNumber == 1)
					{
						if (main.classroom.getClass1Status() == false)
							{
								try
									{
										main.classroom.class1Entrance.acquire();
										System.out.println("got permit");
										printMessage("waiting for class 1 to start");
										scheduleCount++;
										classCount++;
										class1Start = (System.currentTimeMillis() - startTime);
										main.classroom.class1Exit.acquire();
										haveFun();
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
						else
							{
								try
									{
										scheduleCount++;
										printMessage("missed class 1. Running errands");
										Thread.sleep(new Random().nextInt(2000));
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}

				else if (classNumber == 2)
					{
						if (main.classroom.getClass2Status() == false)
							{
								try
									{
										main.classroom.class2Entrance.acquire();
										printMessage("waiting for class 2 to start");
										waitingForClass = true;
										scheduleCount++;
										classCount++;
										class2Start = (System.currentTimeMillis() - startTime);
										main.classroom.class2Exit.acquire();
										haveFun();
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
						else
							{
								try
									{
										scheduleCount++;
										printMessage("missed class 2. Running errands");
										Thread.sleep(new Random().nextInt(2000));
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}

				else if (classNumber == 3)
					{
						if (main.classroom.getClass3Status() == false)
							{

								try
									{
										main.classroom.class3Entrance.acquire();
										printMessage("waiting for class 3 to start");
										waitingForClass = true;
										scheduleCount++;
										classCount++;
										class3Start = (System.currentTimeMillis() - startTime);
										main.classroom.class3Exit.acquire();
										haveFun();
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}

						else
							{
								try
									{
										scheduleCount++;
										printMessage("missed class 3. Running errands");
										Thread.sleep(new Random().nextInt(2000));
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}
			}

		protected void inClass()
			{
				classCount++;
				printMessage("in class " + scheduleCount + ", waiting for class to end");

			}

		protected void haveFun()
			{
				try
					{
						printMessage("PARTY TIME!!!!");
						currentThread().setPriority(MAX_PRIORITY);
						sleep(new Random().nextInt(3000));
						printMessage("is done partying");
						setPriority(NORM_PRIORITY);
					}
				catch (InterruptedException e)
					{
						return;
					}
			}

		synchronized protected void printOut(int classesAttended)
			{
				System.out.println();
				if (classesAttended == 0)
					{
						printMessage("LAZY BUM! No classes attended");
					}
				else if (classesAttended == 1)
					{
						printMessage(" Classes Attended: " + classCount + " at: " + class1Start);
					}
				else if (classesAttended == 2)
					{
						printMessage(" Classes Attended: " + classCount + " at: " + class1Start + ", " + class2Start);
					}

				else if (classesAttended == 3)
					{
						printMessage(" Classes Attended: " + classCount + " at: " + class1Start + ", " + class2Start + ", " + class3Start);
					}
				System.out.println();
			}

		protected void goHome()
			{
				printMessage("going home");
				for (int i = main.students.length; i == 0; i--)
					{
						try
							{
								main.students[i-1].join();
							}
						catch (InterruptedException e)
							{
								e.printStackTrace();
							}
					}
			}

		protected void goToDinner()
			{
				try
					{
						printMessage("waiting to enter cafeteria");
						main.diningRoom.studentsInCafeteria++;
						if (main.diningRoom.studentsInCafeteria == main.numOfStudents)
							{
								main.diningRoom.tellTeacher.release();
							}
						main.diningRoom.cafeteriaOpen.acquire();
						printMessage("in cafeteria, ready to get some grub on!");

						main.diningRoom.tableCapacity.acquire();
						printMessage("grouping up");
						main.diningRoom.increaseCurrentGroupSize();
						if (main.diningRoom.getCurrentGroupSize() == main.diningRoom.groupSize)
							{
								main.diningRoom.tableCapacity.release(main.diningRoom.groupSize);

								if (main.diningRoom.numberOfTables > 0)
									{
										printMessage("getting a table");
										main.diningRoom.numTables.acquire();
										main.diningRoom.decreaseTablesAvailable();
									}
								else
									{
										printMessage("no tables available, waiting for teacher to assign one");
										main.diningRoom.teacherAssign.acquire();
									}

								printMessage("done eating, leaving");
								main.diningRoom.numTables.release();
								main.diningRoom.increaseTablesAvailable();

								main.diningRoom.resetGroups();
							}
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		public void run()
			{
				printMessage("is running.");
				wakeUp();
				useBathroom();
				goToClass(1);
				goToClass(2);
				goToClass(3);
				goToDinner();
				printOut(classCount);
				goHome();
			}

	}