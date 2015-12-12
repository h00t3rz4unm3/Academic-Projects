/**
 * Created by alexandrugutu on 5/7/15.
 */

import java.util.*;

public class teacherThread extends Thread
	{
		private static long startTime;
		private static int breakTime;

		teacherThread(String threadName)
			{
				super(threadName);
				System.out.println(this);

				startTime = System.currentTimeMillis();
				breakTime = new Random().nextInt(3000);

				start();
			}

		teacherThread()
			{
				super();
				System.out.println(this);

				startTime = System.currentTimeMillis();
				breakTime = new Random().nextInt(3000);

				start();
			}

		protected void printMessage(String message)
			{
				System.out.println("[" + (System.currentTimeMillis() - startTime) + "] " + getName() + ": " + message);
			}

		protected void class1()
			{
				main.classroom.class1Entrance.release(main.classroom.classCapacity);
				printMessage("Class 1 is open!");
				try
					{
						currentThread().sleep(1000);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				main.classroom.setClass1Started(true);
				main.classroom.class1Entrance.drainPermits();
				printMessage("Class 1 is in session!");
				try
					{
						Thread.sleep(3000);
						printMessage("Class 1 has ended. Get out!!");
						main.classroom.class1Exit.release(main.classroom.classCapacity);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void class2()
			{
				main.classroom.class2Entrance.release(main.classroom.classCapacity);
				printMessage("Class 2 is open!");
				main.classroom.setClass2Started(true);
				printMessage("Class 2 is in session!");
				try
					{
						Thread.sleep(3000);
						printMessage("Class 2 has ended. Get out!!");
						main.classroom.class2Exit.release(main.classroom.classCapacity);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void class3()
			{
				main.classroom.class3Entrance.release(main.classroom.classCapacity);
				printMessage("Class 3 is open!");
				main.classroom.setClass3Started(true);
				printMessage("Class 3 is in session!");
				try
					{
						Thread.sleep(3000);
						printMessage("Class 3 has ended. Get out!!");
						main.classroom.class3Exit.release(main.classroom.classCapacity);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void classBreak()
			{
				try
					{
						printMessage("Break");
						Thread.sleep(breakTime);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void officeHours()
			{
				try
					{
						printMessage("Office Hours");
						Thread.sleep(2 * breakTime);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void foodTime()
			{
				try
					{
						printMessage("waiting for students to arrive");
						main.diningRoom.tellTeacher.acquire();
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				main.diningRoom.openCafeteria();
				printMessage("time to eat fools!");
				try
					{
						while (main.diningRoom.numberOfTablesAvailable <= 0)
							{
								main.diningRoom.numTables.acquire();
								main.diningRoom.teacherAssign.release();
							}
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}

			}

		public void run()
			{

				try
					{
						Thread.sleep(3000);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				class1();
				classBreak();
				class2();
				officeHours();
				class3();
				foodTime();

			}
	}
