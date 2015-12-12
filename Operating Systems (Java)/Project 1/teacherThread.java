/**
 * Created by Alexandru Gutu on 4/16/15.
 *
 * Copyright (c) 2015 Alexandru Gutu. All rights reserved.
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
				main.classroom.setClass1Started(true);
				printMessage("Class 1 is in session!");
				try
					{
						Thread.sleep(3000);
						printMessage("Class 1 has ended. Get out!!");
						main.classroom.interruptClass();
						main.classroom.setClass1Finished(true);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void class2()
			{
				main.classroom.setClass2Started(true);
				printMessage("Class 2 is in session!");
				try
					{
						Thread.sleep(3000);
						printMessage("Class 2 has ended. Get out!!");
						main.classroom.interruptClass();
						main.classroom.setClass2Finished(true);
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		protected void class3()
			{
				main.classroom.setClass3Started(true);
				printMessage("Class 3 is in session!");
				try
					{
						Thread.sleep(3000);
						printMessage("Class 3 has ended. Get out!!");
						main.classroom.interruptClass();
						main.classroom.setClass3Finished(true);
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

		public void run()
			{
				try
					{
						Thread.sleep(1000);
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
			}
	}
